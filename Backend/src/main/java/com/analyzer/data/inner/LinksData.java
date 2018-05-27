package com.analyzer.data.inner;

import java.util.Set;

public class LinksData {
	Set<HyperMediaLink> linksData;

	public LinksData(Set<HyperMediaLink> hyperLinks) {
		this.linksData = hyperLinks;
	}

	public Set<HyperMediaLink> getLinksData() { return linksData; }
	public void setLinksData(Set<HyperMediaLink> linksData) { this.linksData = linksData; }
}
