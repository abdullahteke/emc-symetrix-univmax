package com.abdullahteke.model.thinpool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ThinPoolMetric {
	
	private Double percentUsedCapacity;
	private Double totalPoolCapacity;
	private Double usedPoolCapacity;
	private Double enabledPoolCapacity;

	public Double getPercentUsedCapacity() {
		return percentUsedCapacity;
	}

	public void setPercentUsedCapacity(Double percentUsedCapacity) {
		this.percentUsedCapacity = percentUsedCapacity;
	}

	public Double getTotalPoolCapacity() {
		return totalPoolCapacity;
	}

	public void setTotalPoolCapacity(Double totalPoolCapacity) {
		this.totalPoolCapacity = totalPoolCapacity;
	}

	public Double getUsedPoolCapacity() {
		return usedPoolCapacity;
	}

	public void setUsedPoolCapacity(Double usedPoolCapacity) {
		this.usedPoolCapacity = usedPoolCapacity;
	}

	public Double getEnabledPoolCapacity() {
		return enabledPoolCapacity;
	}

	public void setEnabledPoolCapacity(Double enabledPoolCapacity) {
		this.enabledPoolCapacity = enabledPoolCapacity;
	}

	public ThinPoolMetric() {
		super();
	}

	@Override
	public String toString() {
		return "ThinPoolMetric [percentUsedCapacity=" + percentUsedCapacity
				+ ", totalPoolCapacity=" + totalPoolCapacity + ", usedPoolCapacity=" + usedPoolCapacity
				+ ", enabledPoolCapacity=" + enabledPoolCapacity + "]";
	}

}
