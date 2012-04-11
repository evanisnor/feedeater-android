/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.xml;

import com.intergalapptic.feedeater.android.standards.IFeedStandardType;

/**
 * <p>FeedElement</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class FeedElement extends AbstractFeedElement {

	private String value;

	/**
	 * @param type
	 */
	public FeedElement(IFeedStandardType<?> type) {
		super(type);
	}
	
	/**
	 * @param type
	 * @param value
	 */
	public FeedElement(IFeedStandardType<?> type, String value) {
		super(type);
		this.value = value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + value + "[/" + getType().getStandard().name() + "." + getType().name() + "]";
	}

}
