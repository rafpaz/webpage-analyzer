package com.analyzer.data.inner;

public class HtmlVersion extends ADisplayRow {
	private String htmlVersion;
	private static final String _DISPLAY_NAME = "Html Version";

	public HtmlVersion(String version) {
		super(_DISPLAY_NAME);
		this.htmlVersion = version;
	}

	@Override
	String getDisplayName() {
		return _DISPLAY_NAME;
	}

	public String getHtmlVersion() {
		return htmlVersion;
	}
	public void setHtmlVersion(String htmlVersion) {
		this.htmlVersion = htmlVersion;
	}
}
