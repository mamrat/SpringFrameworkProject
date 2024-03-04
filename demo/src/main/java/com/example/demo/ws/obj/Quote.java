package com.example.demo.ws.obj;

public class Quote {

	private String value;
	private String by;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getBy() {
		return by;
	}
	
	public void setBy(String by) {
		this.by = by;
	}
	
	public Quote(String value, String by) {
		super();
		this.value = value;
		this.by = by;
	}
	
}
