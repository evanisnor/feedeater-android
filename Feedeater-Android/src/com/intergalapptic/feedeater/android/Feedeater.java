/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.intergalapptic.feedeater.android.parser.FeedHandler;
import com.intergalapptic.feedeater.android.xml.FeedElementContainer;

/**
 * <p>Feedeater</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class Feedeater {
	public static final String TAG = "Feedeater";
	
	public static FeedElementContainer process(String webAddress) throws IOException {
		return FeedHandler.parse((new URL(webAddress).openStream()));
	}
	
	public static FeedElementContainer process(InputStream inputStream) throws IOException {
		return FeedHandler.parse(inputStream);
	}
}
