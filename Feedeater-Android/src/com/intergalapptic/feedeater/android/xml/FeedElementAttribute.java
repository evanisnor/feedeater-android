/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.xml;

/**
 * <p>FeedElementAttribute</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class FeedElementAttribute {
	private String name;
	private String value;
	
	/**
	 * 
	 */
	public FeedElementAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
		return name + "=\"" + value + "\"";
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof FeedElementAttribute) {
			FeedElementAttribute other = (FeedElementAttribute) o;
			return (other.name.equals(name));
		}
		return false;
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
