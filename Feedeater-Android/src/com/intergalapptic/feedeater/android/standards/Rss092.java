/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.standards;


/**
 * <p>Rss092</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Apr 1, 2012
 */
public enum Rss092 implements IFeedStandardType<Rss092> {
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
	Docs			("docs", ElementType.Element),
	Rating			("rating", ElementType.Element),
	TextInput		("textInput", ElementType.Container),
	SkipHours		("skipHours", ElementType.Element),
	SkipDays		("skipDays", ElementType.Element),
	Cloud			("cloud", ElementType.Element),
	Item			("item", ElementType.Container),
	Name			("name", ElementType.Element),
	Enclosure		("enclosure", ElementType.Element),
	Category		("category", ElementType.Element),
	Source			("source", ElementType.Element);
	
	private String elementName;
	private ElementType type;
	
	private Rss092(String elementName, ElementType type) {
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
		return FeedStandard.Rss092;
	}
	
}