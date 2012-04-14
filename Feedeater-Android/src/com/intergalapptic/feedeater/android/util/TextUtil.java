/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.util;


/**
 * <p>TextUtil</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Apr 13, 2012
 */
public class TextUtil {

	
	/**
	 * Function that strips HTML out of feed data.
	 * @param input
	 * @return
	 */
	public static String parseString(String text) {
		if (text == null) {
			return "";
		}
		return text.replaceAll("</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/?>", "");
	}
}
