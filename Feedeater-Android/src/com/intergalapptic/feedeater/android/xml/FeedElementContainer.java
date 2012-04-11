/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.xml;

import java.util.LinkedList;
import java.util.List;

import com.intergalapptic.feedeater.android.standards.IFeedStandardType;

/**
 * <p>FeedElementContainer</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class FeedElementContainer extends AbstractFeedElement {
	private List<AbstractFeedElement> children;
	
	/**
	 * 
	 */
	public FeedElementContainer(IFeedStandardType<?> type) {
		super(type);
		this.children = new LinkedList<AbstractFeedElement>();
	}
	
	/**
	 * 
	 * @param element
	 */
	public void addChildElement(AbstractFeedElement element) {
		children.add(element);
	}
	
	/**
	 * @return the children
	 */
	public List<AbstractFeedElement> getChildren() {
		return children;
	}
	
	/**
	 * @return the children
	 */
	public List<AbstractFeedElement> getChildren(IFeedStandardType<?> type) {
		List<AbstractFeedElement> filteredList = new LinkedList<AbstractFeedElement>();
		for (AbstractFeedElement child : children) {
			if (child.getType() == type) {
				filteredList.add(child);
			}
		}
		return filteredList;
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Override
	public String toString() {
		String out = "";
		for (AbstractFeedElement child : children) {
			if (!out.equals("")) {
				out += "\n\t";
			}
			out += child.toString();
		}
		return super.toString() + "\n\t" + out + "\n\t" + "[/" + getType().getStandard().name() + "." + getType().name() + "]";
	}

}
