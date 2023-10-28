package com.javatpoint.model;

public class StatusFacts {

	private String verified;
	private int sentCount;
	
	public StatusFacts() {
		
	}
	
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public int getSentCount() {
		return sentCount;
	}
	public void setSentCount(int sentCount) {
		this.sentCount = sentCount;
	}

	@Override
	public String toString() {
		return "StatusFacts [verified=" + verified + ", sentCount=" + sentCount + "]";
	}
	
	
}
