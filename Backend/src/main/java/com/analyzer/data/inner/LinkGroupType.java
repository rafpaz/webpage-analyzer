package com.analyzer.data.inner;

import java.util.Set;

public class LinkGroupType {
	LinkType type;
	Set<HyperMediaLink> links;

	public LinkGroupType(LinkType type, Set<HyperMediaLink> links) {
		this.type = type;
		this.links = links;
	}

	public LinkType getType() { return type; }
	public void setType(LinkType type) { this.type = type; }
	public Set<HyperMediaLink> getLinks() { return links; }
	public void setLinks(Set<HyperMediaLink> links) { this.links = links; }
}
