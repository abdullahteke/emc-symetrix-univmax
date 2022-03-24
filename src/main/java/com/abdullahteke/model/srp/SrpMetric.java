package com.abdullahteke.model.srp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SrpMetric {
	
	private Double totalSrpCapacity=-1.0;
	private Double usedSrpCapacity=-1.0;

	public Double getTotalSrpCapacity() {
		return totalSrpCapacity;
	}

	public void setTotalSrpCapacity(Double totalSrpCapacity) {
		this.totalSrpCapacity = totalSrpCapacity;
	}

	public Double getUsedSrpCapacity() {
		return usedSrpCapacity;
	}

	public void setUsedSrpCapacity(Double usedSrpCapacity) {
		this.usedSrpCapacity = usedSrpCapacity;
	}

	public SrpMetric() {
		super();
	}

	@Override
	public String toString() {
		return "SrpMetric [totalSrpCapacity=" + totalSrpCapacity + ", usedSrpCapacity="
				+ usedSrpCapacity + "]";
	}
}
