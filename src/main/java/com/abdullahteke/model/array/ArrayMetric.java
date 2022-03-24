package com.abdullahteke.model.array;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ArrayMetric {

	private Double overallHealthScore=-1.0;
	private Double hardwareHealthScore=-1.0;
	private Double softwareHealthScore=-1.0;
	private Double criticalAlertCount=-1.0;
	private Double usableCapacityTb=-1.0;
	private Double subscribedCapacityTb=-1.0;
	private Double allocatedCapacityTb=-1.0;

	public Double getOverallHealthScore() {
		return overallHealthScore;
	}

	public void setOverallHealthScore(Double overallHealthScore) {
		this.overallHealthScore = overallHealthScore;
	}

	public Double getHardwareHealthScore() {
		return hardwareHealthScore;
	}

	public void setHardwareHealthScore(Double hardwareHealthScore) {
		this.hardwareHealthScore = hardwareHealthScore;
	}

	public Double getSoftwareHealthScore() {
		return softwareHealthScore;
	}

	public void setSoftwareHealthScore(Double softwareHealthScore) {
		this.softwareHealthScore = softwareHealthScore;
	}

	public Double getCriticalAlertCount() {
		return criticalAlertCount;
	}

	public void setCriticalAlertCount(Double criticalAlertCount) {
		this.criticalAlertCount = criticalAlertCount;
	}

	public Double getUsableCapacityTb() {
		return usableCapacityTb;
	}

	public void setUsableCapacityTb(Double usableCapacityTb) {
		this.usableCapacityTb = usableCapacityTb;
	}

	public Double getSubscribedCapacityTb() {
		return subscribedCapacityTb;
	}

	public void setSubscribedCapacityTb(Double subscribedCapacityTb) {
		this.subscribedCapacityTb = subscribedCapacityTb;
	}

	public Double getAllocatedCapacityTb() {
		return allocatedCapacityTb;
	}

	public void setAllocatedCapacityTb(Double allocatedCapacityTb) {
		this.allocatedCapacityTb = allocatedCapacityTb;
	}

	public ArrayMetric() {
		super();
	}

	@Override
	public String toString() {
		return "ArrayMetric [overallHealthScore=" + overallHealthScore + ", hardwareHealthScore=" + hardwareHealthScore
				+ ", softwareHealthScore=" + softwareHealthScore + ", criticalAlertCount=" + criticalAlertCount
				+ ", usableCapacityTb=" + usableCapacityTb + ", subscribedCapacityTb=" + subscribedCapacityTb
				+ ", allocatedCapacityTb=" + allocatedCapacityTb + "]";
	}

}
