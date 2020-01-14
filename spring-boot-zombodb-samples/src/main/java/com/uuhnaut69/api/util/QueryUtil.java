package com.uuhnaut69.api.util;

public final class QueryUtil {

	public static String fullTextSearch(String text) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM products WHERE products ==> '");
		sb.append(text);
		sb.append("'");
		return sb.toString();
	}

	private QueryUtil() {

	}
}
