/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.standards;

import org.xml.sax.Attributes;



/**
 * <p>Specification</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public enum FeedStandard {
	Rss091(Rss091.class, ""),
	Rss092(Rss092.class, ""),
	Rss2(Rss2.class, ""),
	Atom1(Atom1.class, "http://www.w3.org/2005/Atom");
	
	private Class<? extends IFeedStandardType<?>> type;
	private String namespaceAddress;
	
	private FeedStandard(Class<? extends IFeedStandardType<?>> type, String namespaceAddress) {
		this.type = type;
		this.namespaceAddress = namespaceAddress;
	}
	
	/**
	 * @return the specImplementation
	 */
	public Class<? extends IFeedStandardType<?>> getStandardType() {
		return type;
	}
	
	/**
	 * @return the namespaceAddress
	 */
	public String getNamespaceAddress() {
		return namespaceAddress;
	}
	
	public static FeedStandard findStandard(String address, String elementName, Attributes attributes) {
		if (elementName.equals("rss")) {
			for (int attributeIndex = 0; attributeIndex < attributes.getLength(); attributeIndex++) {
				if (attributes.getLocalName(attributeIndex).equals("version")) {
					if (attributes.getValue(attributeIndex).equals("0.91")) {
						return Rss091;
					}
					else if (attributes.getValue(attributeIndex).equals("0.92")) {
						return Rss091;
					}
					else if (attributes.getValue(attributeIndex).equals("2.0")) {
						return Rss2;
					}
				}
			}
		}
		else {
			for (FeedStandard std : FeedStandard.values()) {
				if (std.getNamespaceAddress().equals(address)) {
					return std;
				}
			}
		}
		return null;
	}
	
}
