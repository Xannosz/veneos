package hu.xannosz.veneos.next;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import hu.xannosz.veneos.core.HttpHandler.RequestMethod;
import lombok.Getter;
import lombok.Setter;

public class NextMap {

	public static final String REQUEST_METHOD = "requestMethod";
	public static final String ACTIVITY_TITLE = "activityTitle";
	private static final String ENCODING = "UTF-8";
	private static final int OB = new Random(System.currentTimeMillis()).nextInt((int) System.currentTimeMillis());

	private Map<String, String> map = new HashMap<>();
	@Setter
	private boolean obfuscate = false;
	@Getter
	private Map<String, String> requestMap;

	public void parseMap(String requestURI) throws UnsupportedEncodingException {
		String deObfuscated;
		if (obfuscate) {
			deObfuscated = deObfuscate(requestURI.replace("map/", ""));
		} else {
			deObfuscated = requestURI.replace("map/", "");
		}
		String[] splitted = deObfuscated.split("&");
		for (int i = 0; i < splitted.length - 1; i++) {
			String[] fields = splitted[i].split("=");
			map.put(URLDecoder.decode(fields[0], ENCODING), URLDecoder.decode(fields[1], ENCODING));
		}
	}

	private String obfuscate(String input) {
		StringBuilder builder = new StringBuilder();
		for (char c : input.toCharArray()) {
			builder.append((char) (c + OB));
		}
		return builder.toString();
	}

	private String deObfuscate(String input) {
		StringBuilder builder = new StringBuilder();
		for (char c : input.toCharArray()) {
			builder.append((char) (c - OB));
		}
		return builder.toString();
	}

	public String getMap(String act) throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		for (Entry<String, String> row : map.entrySet()) {
			builder.append(URLEncoder.encode(row.getKey(), ENCODING));
			builder.append("=");
			builder.append(URLEncoder.encode(row.getValue(), ENCODING));
			builder.append("&");
		}
		builder.append(URLEncoder.encode(ACTIVITY_TITLE, ENCODING));
		builder.append("=");
		builder.append(URLEncoder.encode(act, ENCODING));
		if (obfuscate) {
			return obfuscate("map/" + builder.toString());
		} else {
			return "map/" + builder.toString();
		}
	}

	public String get(String key) {
		return map.get(key);
	}

	public String put(String key, String value) {
		return map.put(key, value);
	}

	public void addBasics(RequestMethod requestMethod, Map<String, String> requestMap) {
		put(REQUEST_METHOD, requestMethod.toString());
		this.requestMap = requestMap;
	}
}
