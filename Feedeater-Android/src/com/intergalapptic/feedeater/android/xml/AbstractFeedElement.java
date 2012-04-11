/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.xml;

import java.util.LinkedList;
import java.util.List;

import com.intergalapptic.feedeater.android.standards.IFeedStandardType;

/**
 * <p>AbstractFeedElement</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public abstract class AbstractFeedElement {
	private IFeedStandardType<?> type;
	private List<FeedElementAttribute> attributes;
	
	protected AbstractFeedElement(IFeedStandardType<?> type) {
		this.type = type;
		this.attributes = new LinkedList<FeedElementAttribute>();
	}
	
	public void addAttribute(FeedElementAttribute attribute) {
		attributes.add(attribute);
	}
	
	/**
	 * @return the type
	 */
	public IFeedStandardType<?> getType() {
		return type;
	}
	
	/**
	 * @return the attributes
	 */
	public List<FeedElementAttribute> getAttributes() {
		return attributes;
	}
	
	public FeedElementAttribute getAttribute(String name) {
		for (FeedElementAttribute attribute : attributes) {
			if (attribute.getName().equals(name)) {
				return attribute;
			}
		}
		return null;
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public String toString() {
		String out = "[" + type.getStandard().name() + "." + type.name();
		String attributeString = "";
		for (FeedElementAttribute attribute : attributes) {
			if (!attributeString.equals("")) {
				attributeString += " ";
			}
			attributeString += attribute.toString();
		}
		if (!attributeString.equals("")) {
			out += " " + attributeString;
		}
		return out + "]";
	}
	
}
