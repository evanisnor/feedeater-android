/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.parser;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.intergalapptic.feedeater.android.Feedeater;
import com.intergalapptic.feedeater.android.exception.UnsupportedElementException;
import com.intergalapptic.feedeater.android.exception.UnsupportedNamespaceException;
import com.intergalapptic.feedeater.android.xml.AbstractFeedElement;
import com.intergalapptic.feedeater.android.xml.FeedElement;
import com.intergalapptic.feedeater.android.xml.FeedElementAttribute;
import com.intergalapptic.feedeater.android.xml.FeedElementContainer;

/**
 * <p>FeedHandler</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class FeedHandler extends DefaultHandler {
	private static ElementFactory elementFactory;
	
	private XMLReader xmlReader;
	private int depth;
	private AbstractFeedElement rootElement;
	private List<FeedElementContainer> documentBreadtrail;
	private AbstractFeedElement currentElement;
	private StringBuffer elementText;
	
	private List<String> unsupportedNamespaceList;
	private List<String> unsupportedElementList;

	/**
	 * 
	 * @param input
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends AbstractFeedElement> T parse(InputStream inputStream) {
		return (T) new FeedHandler().parseStream(inputStream);
	}
	
	/**
	 * Default constructor. Initializes all supported {@link IUnmarshalable} classes
	 * and initializes SAX for XML parsing.
	 */
	private FeedHandler() {
		elementFactory = ElementFactory.getInstance();
		unsupportedNamespaceList = new LinkedList<String>();
		unsupportedElementList = new LinkedList<String>();
		initializeSax();
	}
	
	/**
	 * Initialize the SAX Parser.
	 */
	private void initializeSax() {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			xmlReader = sp.getXMLReader();
			xmlReader.setContentHandler(this);
		}
		catch (Exception e) {
			Log.e(Feedeater.TAG, e.getClass().getSimpleName() + ": " + Log.getStackTraceString(e));
		}
	}
	
	/**
	 * 
	 * @param bais
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T extends AbstractFeedElement> T parseStream(InputStream inputStream) {
		try {
			xmlReader.parse(new InputSource(inputStream));
		}
		catch (Exception e) {
			Log.e(Feedeater.TAG, e.getClass().getSimpleName() + ": " + Log.getStackTraceString(e));
		}
		return (T) rootElement;
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		depth = 0;
		documentBreadtrail = new LinkedList<FeedElementContainer>();
		rootElement = null;
		currentElement = null;
		elementText = null;
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		documentBreadtrail.clear();
		unsupportedNamespaceList.clear();
		unsupportedElementList.clear();
		elementFactory.clearNamespaces();
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String namespace, String elementName, String qName, Attributes attributes)
			throws SAXException {
		try {
			elementFactory.setNamespace(namespace, elementName, attributes);
			AbstractFeedElement parsedElement = elementFactory.getElement(namespace, elementName);
			for (int attributeIndex = 0; attributeIndex < attributes.getLength(); attributeIndex++) {
				FeedElementAttribute attribute = new FeedElementAttribute(
						attributes.getLocalName(attributeIndex),
						attributes.getValue(attributeIndex));
				parsedElement.addAttribute(attribute);
			}
			
			if (depth == 0) {
				//Keep the depth 0 reference as the root object.
				rootElement = parsedElement;
			}
			else {
				documentBreadtrail.get(depth - 1).addChildElement(parsedElement);
			}
			
			if (parsedElement instanceof FeedElementContainer) {
				//Increase the depth of the document tree if this element is an Array. It will contain
				//children.
				documentBreadtrail.add(depth, (FeedElementContainer) parsedElement);
				depth++;
			}
			else if (parsedElement instanceof FeedElement) {
				//The element is not an array and it may have a property value.
				currentElement = parsedElement;
			}
		}
		catch (UnsupportedElementException uee) {
			if (!unsupportedElementList.contains(elementName)) {
				Log.d(Feedeater.TAG, "Can't read unsupported element \'" + elementName + "\' from namespace \'" + namespace + "\'");
				unsupportedElementList.add(elementName);
			}
			currentElement = null;
		}
		catch (UnsupportedNamespaceException une) {
			if (!unsupportedNamespaceList.contains(namespace)) {
				Log.d(Feedeater.TAG, "Can't read unsupported namespace \'" + namespace + "\'");
				unsupportedNamespaceList.add(namespace);
			}
			currentElement = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String namespace, String elementName, String qName)
			throws SAXException {
		try {
			AbstractFeedElement parsedElement = elementFactory.getElement(namespace, elementName);
			if (parsedElement instanceof FeedElementContainer) {
				depth--;
			}
			else if (parsedElement instanceof FeedElement) {
				if (elementText != null) {
					FeedElement e = (FeedElement) currentElement;
					e.setValue(new String(elementText.toString()));
					elementText = null;
				}
			}
		}
		catch (UnsupportedElementException uee) {
			elementText = null;
		}
		catch (UnsupportedNamespaceException une) {
			elementText = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currentElement != null && currentElement instanceof FeedElement) {
			//Parse the element's value
			String content = new String(ch, start, length);
			if (!content.trim().equals("")) {
				if (elementText == null) {
					elementText = new StringBuffer();
				}
				elementText.append(content);
			}
		}
	}
}
