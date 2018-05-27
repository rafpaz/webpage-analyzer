package com.analyzer.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class UTUrl {

	private static final String _WWW = "www.";

	public static boolean isExternalUrl(String origLink, String linkToCheck){
		if (!isAbsolute(linkToCheck))
			return false;
		String origDomain = getDomain(origLink);
		String toCheckDomain = getDomain(linkToCheck);
		if (origDomain == null || toCheckDomain == null) return false;
		return !origDomain.equals(toCheckDomain) && !toCheckDomain.endsWith(origDomain);
	}

	private static String getDomain(String url){
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}

		String domain = uri.getHost();
		if (domain == null)
			return null;

		return domain.startsWith(_WWW) ? domain.substring(4) : domain ;

	}

	private static boolean isAbsolute(String url){
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
		return uri.isAbsolute();
	}
}
