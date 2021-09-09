package com.domain;

public enum Position {
	Junior("Junior"), Mid("Mid"), Senior("Senior"), TeamManager("Team Manager"), Boss("Boss");
	
	private String name;
	
	private Position (String position) {
		this.setName(position);
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
