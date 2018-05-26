package com.analyzer.data.inner;

public class PageTitle extends ADisplayRow {

	private static final String _DISPLAY_NAME = "Page Title";

	String pageTitle;

	public PageTitle(String pageTitle) {
		super(_DISPLAY_NAME);
		this.pageTitle = pageTitle;
	}

	public String getPageTitle() { return pageTitle; }
	public void setPageTitle(String pageTitle) { this.pageTitle = pageTitle; }
}
