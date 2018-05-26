package com.analyzer;

import com.analyzer.data.ResponseData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Analyzer {
	private ResponseData responseData;

	public static String analyze(String url){
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println("bla");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
