package com.analyzer.data.inner;

import com.analyzer.data.IDisplayParameters;

public class HtmlVersion implements IDisplayParameters {
	String htmlVersion;
	private static final String _DisplayName = "Html Version";

	public HtmlVersion(String version) {
		this.htmlVersion = version;
	}

	public String getHtmlVersion() {
		return htmlVersion;
	}

	public void setHtmlVersion(String htmlVersion) {
		this.htmlVersion = htmlVersion;
	}

	@Override
	public String getDisplayName() {
		return _DisplayName;
	}
}
