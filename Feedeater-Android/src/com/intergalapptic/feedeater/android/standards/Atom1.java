/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.standards;



/**
 * <p>Atom1</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public enum Atom1 implements IFeedStandardType<Atom1> {
	
	Feed			("feed", ElementType.Container),
	Title			("title", ElementType.Element),
	Link			("link", ElementType.Element),
	Updated			("updated", ElementType.Element),
	Author			("author", ElementType.Container),
	Name			("name", ElementType.Element),
	Uri				("uri", ElementType.Element),
	Email			("email", ElementType.Element),
	Id				("id", ElementType.Element),
	Category		("category", ElementType.Element),
	Contributor		("contributor", ElementType.Container),
	Generator		("generator", ElementType.Element),
	Icon			("icon", ElementType.Element),
	Logo			("logo", ElementType.Element),
	Rights			("rights", ElementType.Element),
	Subtitle		("subtitle", ElementType.Element),
	Entry			("entry", ElementType.Container),
	Summary			("summary", ElementType.Element),
	Content			("content", ElementType.Element),
	Published		("published", ElementType.Element),
	Source			("source", ElementType.Element);
	
	private String elementName;
	private ElementType type;
	
	
	private Atom1(String elementName, ElementType type) {
		this.elementName = elementName;
		this.type = type;
	}
	
	
	/**
	 * @{inheritDoc}
	 */
	public String getElementName() {
		return elementName;
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public ElementType getElementType() {
		return type;
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public FeedStandard getStandard() {
		return FeedStandard.Atom1;
	}
}