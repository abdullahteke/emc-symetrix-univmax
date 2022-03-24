package com.abdullahteke.model.srp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Srp {

	private String srpId = "";
	private Long firstAvailableDate = -1L;
	private Long lastAvailableDate = -1L;

	public String getSrpId() {
		return srpId;
	}

	public void setSrpId(String srpId) {
		this.srpId = srpId;
	}

	public Long getFirstAvailableDate() {
		return firstAvailableDate;
	}

	public void setFirstAvailableDate(Long firstAvailableDate) {
		this.firstAvailableDate = firstAvailableDate;
	}

	public Long getLastAvailableDate() {
		return lastAvailableDate;
	}

	public void setLastAvailableDate(Long lastAvailableDate) {
		this.lastAvailableDate = lastAvailableDate;
	}

	public Srp() {
		super();
	}

	@Override
	public String toString() {
		return "Srp [srpId=" + srpId + ", firstAvailableDate=" + firstAvailableDate + ", lastAvailableDate="
				+ lastAvailableDate + "]";
	}

}
