package com.abdullahteke.model.thinpool;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.ALWAYS)
public class ThinPoolInfo {

	private List<ThinPool> poolInfo;

	public List<ThinPool> getPoolInfo() {
		return poolInfo;
	}

	public void setPoolInfo(List<ThinPool> poolInfo) {
		this.poolInfo = poolInfo;
	}

	public ThinPoolInfo() {
		super();
	}

	@Override
	public String toString() {
		return "ThinPoolInfo [poolInfo=" + poolInfo + "]";
	}
	
	
}
