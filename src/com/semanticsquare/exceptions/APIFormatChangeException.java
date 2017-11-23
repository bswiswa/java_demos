package com.semanticsquare.exceptions;

public class APIFormatChangeException extends Exception {
	String response;
	String element;
	String partner;
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public APIFormatChangeException(String response, String element, String partner) {
		super("Response: "+ response + " Element: "+ element + " Partner: "+ partner);
		this.response = response;
		this.element = element;
		this.partner = partner;
	}
	
	
    
}