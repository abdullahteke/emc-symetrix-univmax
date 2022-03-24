package com.abdullahteke.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Unimax {
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String> symmetrixId;

	public List<String> getSymmetrixId() {
		return symmetrixId;
	}

	public void setSymmetrixId(List<String> symmetrixId) {
		this.symmetrixId = symmetrixId;
	}

	public Unimax() {
		super();
	}

	@Override
	public String toString() {
		return "Unimax [symmetrixId=" + symmetrixId + "]";
	}
	
	
	
	
}
