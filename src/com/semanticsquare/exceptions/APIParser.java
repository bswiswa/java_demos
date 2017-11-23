package com.semanticsquare.exceptions;

public class APIParser {
	public static int parseSendResponseCode(String response, String data, String partner) throws APIFormatChangeException {
		int responseCode = -1;
		try {
			String startTag = "<code>";
			String endTag = "</code>";
			if (response.contains(startTag)) {
				int beginIndex = response.indexOf(startTag) + startTag.length();
				int endIndex = response.indexOf(endTag);
				System.out.println("code: " + response.substring(beginIndex, endIndex));
				responseCode = Integer.parseInt(response.substring(beginIndex, endIndex));
			}
		} catch (NumberFormatException e) {
			APIFormatChangeException higher = new APIFormatChangeException(response ,"code" , partner);
			higher.initCause(e);
			throw higher;
		}
		
		return responseCode;
	}
}
