package com.analyzer.data.inner;

public enum LinkType {
	A("href", "a[href]"), SRC("src", "[src]"), LINK("href", "link[href]");

	private String attr;
	private String query;

	LinkType(String attr, String query){
		this.attr = attr;
		this.query = query;
	}

	public String getAttr(){
		return attr;
	}
	public String getQuery() { return query; }
}