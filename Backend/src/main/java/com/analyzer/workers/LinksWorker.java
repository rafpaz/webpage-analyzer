package com.analyzer.workers;

import com.analyzer.data.inner.HyperMediaLink;
import com.analyzer.data.inner.LinkGroupType;
import com.analyzer.data.inner.LinkType;
import com.analyzer.data.inner.Links;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

public class LinksWorker {

	public static final String _A_TAG_QUERY = "a[href]";
	public static final String _SRC_QUERY = "[src]";
	public static final String _LINK_QUERY = "link[href]";

	public static Links getData(Document doc){
		Elements hyperLinks = getHyperMediaLinks(doc);
		return null;
	}

	private static Elements getHyperMediaLinks(Document doc) {
		Set<HyperMediaLink> aTagLinks = convertToHyperMediaLinks(LinkType.A, doc);
		Set<HyperMediaLink> srcLinks = convertToHyperMediaLinks(LinkType.SRC, doc);
		Set<HyperMediaLink> importLinks = convertToHyperMediaLinks(LinkType.LINK, doc);

		//merge all types to a single set
		Set<HyperMediaLink> links = new HashSet<>(aTagLinks);
		links.addAll(srcLinks);
		links.addAll(importLinks);

		buildLinkSummary(links);

		return null;
	}

	private static void buildLinkSummary(Set<HyperMediaLink> links) {

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
