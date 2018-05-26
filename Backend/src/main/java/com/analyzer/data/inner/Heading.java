package com.analyzer.data.inner;

import java.util.HashMap;
import java.util.Map;

public class Heading extends ADisplayRow{
	private static final String _DISPLAY_NAME = "Headings";
	Map<String, Integer> headingValues;

	public Heading() {
		super(_DISPLAY_NAME);
		headingValues = new HashMap<>();
	}

	public void addHeadingValue(String heading, Integer value){
		headingValues.put(heading, value);
	}

	public void increaseHeadingValue(String heading){
		if (headingValues.containsKey(heading))
			headingValues.put(heading, headingValues.get(heading) + 1);
		else
			headingValues.put(heading, 1);
	}
}
