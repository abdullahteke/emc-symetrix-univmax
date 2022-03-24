package com.abdullahteke.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symmetrix {

	private String symmetrixId;

	public String getSymmetrixId() {
		return symmetrixId;
	}

	public void setSymmetrixId(String symmetrixId) {
		this.symmetrixId = symmetrixId;
	}

	public Symmetrix() {
		super();
	}

	public Symmetrix(String symmetrixId) {
		super();
		this.symmetrixId = symmetrixId;
	}

	@Override
	public String toString() {
		return "Symmetrix [symmetrixId=" + symmetrixId + "]";
	}
	
}
