package io.valhala.adobecsv.main;

public enum Mode {
	
	FACSTAFF,
	STUDENT;
	
	private String mode;
	
	public void setMode(String mode) { this.mode = mode; }
	
	public String getMode() { return mode.toString(); }

}
