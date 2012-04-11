/**
 * $LICENSE
 */
package com.intergalapptic.feedeater.android;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.intergalapptic.feedeater.android.standards.Atom1;
import com.intergalapptic.feedeater.android.standards.FeedStandard;
import com.intergalapptic.feedeater.android.standards.Rss2;
import com.intergalapptic.feedeater.android.xml.AbstractFeedElement;
import com.intergalapptic.feedeater.android.xml.FeedElementContainer;

/**
 * <p>MainActivity</p>
 * 
 * <p>TODO Description</p>
 *
 * @author	Evan W. Isnor (ewisnor@gmail.com)
 * @date	Mar 31, 2012
 */
public class MainActivity extends Activity {
	/**
	 * @{inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		try {
//			InputStream is = getResources().getAssets().open("sgu.xml");
//			InputStream is = getResources().getAssets().open("atomexample1.xml");
//			InputStream is = getResources().getAssets().open("atomexample2.xml");
//			InputStream is = getResources().getAssets().open("rss2example1.xml");
			
//			List<AbstractFeedElement> episodes = getEpisodes("http://www.theskepticsguide.org/feed/rss.aspx?feed=SGU");
//			
//			for (AbstractFeedElement episode : episodes) {
//				Log.i(Feedeater.TAG, episode.toString());
//			}
//		}
//		catch (IOException e) {
//			Log.e(Feedeater.TAG, e.getClass().getSimpleName() + " -- " +e.getMessage() + ": " + Log.getStackTraceString(e));
//		}
	}
	
//	private List<AbstractFeedElement> getEpisodes(String url) throws IOException {
//		FeedElementContainer feed = Feedeater.process(url);
//		List<AbstractFeedElement> episodes = new LinkedList<AbstractFeedElement>();
//		if (feed.getType().getStandard() == FeedStandard.Rss2) {
//			episodes.addAll(feed.getChildren(Rss2.Item));
//		}
//		else if (feed.getType().getStandard() == FeedStandard.Atom1) {
//			episodes.addAll(feed.getChildren(Atom1.Entry));
//		}
//		return episodes;
//	}
}
