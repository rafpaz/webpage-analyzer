package com.analyzer.data.inner;

public abstract class ADisplayRow {
	String displayName;

	public ADisplayRow(String displayName) {
		this.displayName = displayName;
	}

	String getDisplayName(){
		return displayName;
	}
}
