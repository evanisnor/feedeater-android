/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.exception;

/**
 * <p>UnsupportedElementException</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Apr 13, 2012
 */
public class UnsupportedElementException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5003135725815255350L;

	public UnsupportedElementException(String elementName, String namespace) {
		super("Unsupported Element \'" + elementName + "\' from namespace \'" + namespace + "\'");
		
	}
	
}
