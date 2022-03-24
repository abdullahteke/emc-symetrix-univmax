package com.abdullahteke.model.thinpool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ThinPool {

	private String poolId;
	private Long firstAvailableDate;
	private Long lastAvailableDate;

	public String getPoolId() {
		return poolId;
	}

	public void setPoolId(String poolId) {
		this.poolId = poolId;
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

	public ThinPool() {
		super();
	}

	@Override
	public String toString() {
		return "ThinPool [poolId=" + poolId + ", firstAvailableDate=" + firstAvailableDate + ", lastAvailableDate="
				+ lastAvailableDate + "]";
	}

}
