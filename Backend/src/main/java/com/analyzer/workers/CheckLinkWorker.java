package com.analyzer.workers;

import com.analyzer.data.inner.HyperMediaLink;
import sun.net.www.protocol.mailto.MailToURLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public class CheckLinkWorker implements Callable<HyperMediaLink> {
	private HyperMediaLink link;

	public CheckLinkWorker(HyperMediaLink url) {
		this.link = url;
	}

	@Override
	public HyperMediaLink call() throws Exception {
		try {
			System.out.println("Checking availability for: " + link.getLink());
			URL url = new URL(link.getLink());

			URLConnection connection = url.openConnection();
			if (connection instanceof HttpURLConnection) {
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					System.out.println("Success for link: " + link.getLink());
					link.setAvailable(true);
				}
				else {
					link.setAvailable(false);
					link.setMessage(httpConnection.getResponseMessage());
					System.out.println(link.getLink() + " is not available");
					System.out.println("Error message: " + httpConnection.getResponseMessage());
				}
			} else {
				link.setAvailable(false);
				link.setMessage("Not Http Connection Link");
			}
		} catch (IOException e) {
			System.out.println(link.getLink() + " is not available (exception)");
			link.setAvailable(false);
			link.setMessage("Exception on ping");
		}
		return link;
}
}
