/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.exception;

/**
 * <p>UnsupportedNamespaceException</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Apr 13, 2012
 */
public class UnsupportedNamespaceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5003135725815255350L;

	public UnsupportedNamespaceException(String namespace) {
		super("Unsupported namespace \'" + namespace + "\'");
		
	}
	
}
