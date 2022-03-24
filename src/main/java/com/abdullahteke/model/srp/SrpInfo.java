package com.abdullahteke.model.srp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SrpInfo {

	private List<Srp> srpInfo;

	public List<Srp> getSrpInfo() {
		return srpInfo;
	}

	public void setSrpInfo(List<Srp> srpInfo) {
		this.srpInfo = srpInfo;
	}

	public SrpInfo() {
		super();
	}

	@Override
	public String toString() {
		return "SrpInfo [srpInfo=" + srpInfo + "]";
	}

}
