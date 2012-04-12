/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <p>Rss2DateUtility</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Apr 11, 2012
 */
public class Rss2DateUtility {
    private static final String RFC822_FORMAT_OPTION1 = "EEE, d MMM yyyy HH:mm:ss Z";
    private static final String RFC822_FORMAT_OPTION2 = "EEE, d MMM yyyy HH:mm Z";
    private static final String RFC822_FORMAT_OPTION3 = "d MMM yyyy HH:mm:ss Z";
    private static final String RFC822_FORMAT_OPTION4 = "d MMM yyyy HH:mm Z";
    private static final String ISO8601_FORMAT = "d MMM yyyy HH:mm Z";
    
    public static Date parse(String dateString) throws ParseException {
    	Date result = new Date();
    	
    	String[] formatOptions = new String[] {
    		RFC822_FORMAT_OPTION1,
    		RFC822_FORMAT_OPTION2,
    		RFC822_FORMAT_OPTION3,
    		RFC822_FORMAT_OPTION4,
    		ISO8601_FORMAT
    	};
    	
    	for (String formatString : formatOptions) {
    		SimpleDateFormat sdf = new SimpleDateFormat(formatString, Locale.US);
    		try {
				result = sdf.parse(dateString);
				return result;
			}
    		catch (ParseException e) {
    			if (formatString.equals(ISO8601_FORMAT)) {
    				throw e;
    			}
			}
    	}
    	
    	
    	return result;
    }
}
