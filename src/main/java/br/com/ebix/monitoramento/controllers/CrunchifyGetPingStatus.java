package br.com.ebix.monitoramento.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.ebix.monitoramento.model.Evento;

public class CrunchifyGetPingStatus {
	
	public static void main(String args[]) throws Exception {
		
		 
		String[] hostList = 
			{ 
				"http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", 
				"https://google.com","http://www.example.co", "https://paypal.com", 
				"http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
				"https://thenextweb.com/", "http://wordpress.com/", 
				"http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
				"https://ebay.co.uk/", "http://google.co.uk/", "http://wikipedia.org/"
			};
 
		for (int i = 0; i < hostList.length; i++) {
 
			String url = hostList[i];
			getStatus(url);
 
		}
 
		System.out.println("Task completed...");
	}
 
	public static String getStatus(String url) throws IOException {
 
		String result = "";
		int code = 200;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();
 
			code = connection.getResponseCode();
			if (code == 200) {
				result = "-> Green <-\t" + "Code: " + code;
				;
			} else {
				result = "-> Yellow <-\t" + "Code: " + code;
			}
		} catch (Exception e) {
			result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
 
		}
		System.out.println(url + "\t\tStatus:" + result);
		return result;
	}
}
