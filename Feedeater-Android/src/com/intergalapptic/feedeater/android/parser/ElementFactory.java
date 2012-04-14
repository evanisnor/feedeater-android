/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.parser;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;

import android.util.Log;

import com.intergalapptic.feedeater.android.Feedeater;
import com.intergalapptic.feedeater.android.exception.UnsupportedElementException;
import com.intergalapptic.feedeater.android.exception.UnsupportedNamespaceException;
import com.intergalapptic.feedeater.android.standards.ElementType;
import com.intergalapptic.feedeater.android.standards.FeedStandard;
import com.intergalapptic.feedeater.android.standards.IFeedStandardType;
import com.intergalapptic.feedeater.android.xml.AbstractFeedElement;
import com.intergalapptic.feedeater.android.xml.FeedElement;
import com.intergalapptic.feedeater.android.xml.FeedElementContainer;

/**
 * <p>ElementFactory</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class ElementFactory {
	private static ElementFactory instance = null;
	
	public static ElementFactory getInstance() {
		if (instance == null) {
			instance = new ElementFactory();
		}
		return instance;
	}
	
	private Map<String, FeedStandard> namespaceMap;
	
	private ElementFactory() {
		this.namespaceMap = new HashMap<String, FeedStandard>();
	}
	
	public void setNamespace(String namespace, String elementName, Attributes attributes) throws UnsupportedNamespaceException {
		if (!namespaceMap.containsKey(namespace)) {
			FeedStandard std = FeedStandard.findStandard(namespace, elementName, attributes);
			if (std == null) {
				throw new UnsupportedNamespaceException(namespace);
			}
			Log.i(Feedeater.TAG, "Mapping " + std.name() + " to namespace " + namespace);
			namespaceMap.put(namespace, std);
		}
	}
	
	public void clearNamespaces() {
		namespaceMap.clear();
	}
	
	public AbstractFeedElement getElement(String namespace, String elementName) throws UnsupportedElementException, UnsupportedNamespaceException {
		FeedStandard expectedStandard = namespaceMap.get(namespace);
		if (expectedStandard == null) {
			throw new UnsupportedElementException(elementName, namespace);
		}
		else {
			IFeedStandardType<?> type = parseType(elementName, expectedStandard);
			if (type == null) {
				throw new UnsupportedNamespaceException(namespace);
			}
			AbstractFeedElement element = getElementInstance(type);
			return element;
		}
	}
	
	private IFeedStandardType<?> parseType(String elementName, FeedStandard std) {
		try {
			for (IFeedStandardType<?> type : std.getStandardType().getEnumConstants()) {
				if (type.getElementName().equals(elementName)) {
					return type;
				}
			}
		}
		catch (Exception e) {
			Log.e(Feedeater.TAG, e.getClass().getSimpleName() + ": " + Log.getStackTraceString(e));
		}
		
		return null;
	}
	
	
	private AbstractFeedElement getElementInstance(IFeedStandardType<?> type) {
		if (type.getElementType() == ElementType.Container) {
			return new FeedElementContainer(type);
		}
		else {
			return new FeedElement(type);
		}
	}
}
