/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.standards;


/**
 * <p>ISpecification</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public interface IFeedStandardType<T> {
	String getElementName();
	ElementType getElementType();
	FeedStandard getStandard();
	String name();
}
