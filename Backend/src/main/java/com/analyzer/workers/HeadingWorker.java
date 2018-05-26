package com.analyzer.workers;

import com.analyzer.data.inner.Heading;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HeadingWorker{
	private static final String _HeadingQuery = "h1, h2, h3, h4, h5, h6";

	public static Heading getData(Document doc){
		Heading heading = new Heading();
		Elements headings = doc.select(_HeadingQuery);
		for (Element elem : headings) {
			heading.increaseHeadingValue(elem.tagName());
		}
		return heading;
	}
}
