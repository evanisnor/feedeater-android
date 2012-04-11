/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.standards;


/**
 * <p>Rss2</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public enum Rss2 implements IFeedStandardType<Rss2> {
	Rss				("rss", ElementType.Container),
	Channel			("channel", ElementType.Container),
	Title			("title", ElementType.Element),
	Link			("link", ElementType.Element),
	Description		("description", ElementType.Element),
	Image			("image", ElementType.Container),
	Url				("url", ElementType.Element),
	Width			("width", ElementType.Element),
	Height			("height", ElementType.Element),
	Language		("language", ElementType.Element),
	Copyright		("copyright", ElementType.Element),
	ManagingEditor	("managingEditor", ElementType.Element),
	WebMaster		("webMaster", ElementType.Element),
	PubDate			("pubDate", ElementType.Element),
	LastBuildDate	("lastBuildDate", ElementType.Element),
	Category		("category", ElementType.Element),
	Generator		("generator", ElementType.Element),
	Docs			("docs", ElementType.Element),
	Cloud			("cloud", ElementType.Element),
	Ttl				("ttl", ElementType.Element),
	Rating			("rating", ElementType.Element),
	TextInput		("textInput", ElementType.Container),
	SkipHours		("skipHours", ElementType.Element),
	SkipDays		("skipDays", ElementType.Element),
	Item			("item", ElementType.Container),
	Author			("author", ElementType.Element),
	Comments		("comments", ElementType.Element),
	Enclosure		("enclosure", ElementType.Element),
	Guid			("guid", ElementType.Element),
	Source			("source", ElementType.Element);
	
	private String elementName;
	private ElementType type;
	
	private Rss2(String elementName, ElementType type) {
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
		return FeedStandard.Rss2;
	}
	
}