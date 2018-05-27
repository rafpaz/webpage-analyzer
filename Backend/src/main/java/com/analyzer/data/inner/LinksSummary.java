package com.analyzer.data.inner;

public class LinksSummary extends ADisplayRow{
	private int innerLinks;
	private int externalLinks;
	private static final String _DISPLAY_NAME = "Links Summary";

	public LinksSummary() {
		super(_DISPLAY_NAME);
		this.innerLinks = 0;
		this.externalLinks = 0;
	}

	public void increaseInner(){ this.innerLinks++; }
	public void increaseExternal(){ this.externalLinks++; }

	public int getInnerLinks() { return innerLinks; }
	public void setInnerLinks(int innerLinks) { this.innerLinks = innerLinks; }
	public int getExternalLinks() { return externalLinks; }
	public void setExternalLinks(int externalLinks) { this.externalLinks = externalLinks; }
}
