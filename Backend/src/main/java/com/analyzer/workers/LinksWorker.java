package com.analyzer.workers;

import com.analyzer.data.inner.*;
import com.analyzer.utils.UTUrl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class LinksWorker {

	public static Links getData(Document doc){
		Links result = new Links();
		Set<HyperMediaLink> hyperLinks = getHyperMediaLinks(doc);
		if (hyperLinks == null)
			return null;

		result.setLinksSummary(buildLinkSummary(doc, hyperLinks));
		result.setLinksData(buildLinkAvailability(hyperLinks));
		return result;
	}

	private static LinksData buildLinkAvailability(Set<HyperMediaLink> hyperLinks) {
		for (HyperMediaLink hyperLink : hyperLinks) {
			try {
				System.out.println("Checking availability for: " + hyperLink.getLink());
				URL url = new URL(hyperLink.getLink());
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
					hyperLink.setAvailable(true);
				} else {
					hyperLink.setAvailable(false);
					hyperLink.setMessage(connection.getResponseMessage());
					System.out.println(hyperLink.getLink() + " is not available");
					System.out.println("Error message: " + connection.getResponseMessage());
				}
			} catch (IOException e) {
				System.out.println(hyperLink.getLink() + " is not available (exception)");
				hyperLink.setAvailable(false);
				hyperLink.setMessage("Exception on ping");
				e.printStackTrace();
			}
		}
		return new LinksData(hyperLinks);
	}

	private static Set<HyperMediaLink> getHyperMediaLinks(Document doc) {
		Set<HyperMediaLink> aTagLinks = convertToHyperMediaLinks(LinkType.A, doc);
		Set<HyperMediaLink> srcLinks = convertToHyperMediaLinks(LinkType.SRC, doc);
		Set<HyperMediaLink> importLinks = convertToHyperMediaLinks(LinkType.LINK, doc);

		//merge all types to a single set
		Set<HyperMediaLink> links = new HashSet<>(aTagLinks);
		links.addAll(srcLinks);
		links.addAll(importLinks);
		return links;
	}

	private static LinksSummary buildLinkSummary(Document doc, Set<HyperMediaLink> links) {
		LinksSummary summary = new LinksSummary();
		String origUrl = doc.baseUri();
		for (HyperMediaLink link : links) {
			if (UTUrl.isExternalUrl(origUrl, link.getLink())){
				link.setExternal(true);
				summary.increaseExternal();
			} else {
				link.setExternal(false);
				String sLink = link.getLink();
				if (!sLink.startsWith("//") && sLink.startsWith("/"))
					link.setLink(origUrl + sLink.substring(1));
				summary.increaseInner();
			}
		}
		return summary;
	}

	private static Set<HyperMediaLink> convertToHyperMediaLinks(LinkType type, Document doc) {
		Set<HyperMediaLink> resLinks = new HashSet<>();
		Elements elems =  doc.select(type.getQuery());
		for (Element elem : elems) {
			resLinks.add(new HyperMediaLink(elem.attr(type.getAttr())));
		}
		return resLinks;
	}
}
