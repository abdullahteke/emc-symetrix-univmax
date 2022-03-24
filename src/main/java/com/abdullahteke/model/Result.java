package com.abdullahteke.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result {
	private Long timestamp;
	private Double CriticalAlertCount;
	private Double OverallHealthScore;
	private Double HardwareHealthScore;
	private Double SoftwareHealthScore;
	private Double SubscribedCapacityTB;
	private Double UsableCapacityTB;
	private Double AllocatedCapacityTB;
	private Double PercentUsedCapacity;
	private Double TotalPoolCapacity;
	private Double EnabledPoolCapacity;
	private Double UsedPoolCapacity;
	private Double TotalSRPCapacity;
	private Double UsedSRPCapacity;

	public Result() {

	}

	public Result(String string) {
		if (string.equalsIgnoreCase("Default")) {
			this.AllocatedCapacityTB=-1.0;
			this.CriticalAlertCount=-1.0;
			this.EnabledPoolCapacity=-1.0;
			this.HardwareHealthScore=-1.0;
			this.OverallHealthScore=-1.0;
			this.PercentUsedCapacity=-1.0;
			this.SoftwareHealthScore=-1.0;
			this.SubscribedCapacityTB=-1.0;
			this.timestamp=-1L;
			this.TotalPoolCapacity=-1.0;
			this.TotalSRPCapacity=-1.0;
			this.UsableCapacityTB=-1.0;
			this.UsedPoolCapacity=-1.0;
			this.UsedSRPCapacity=-1.0;
		}
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Double getCriticalAlertCount() {
		return CriticalAlertCount;
	}

	public void setCriticalAlertCount(Double criticalAlertCount) {
		CriticalAlertCount = criticalAlertCount;
	}

	public Double getOverallHealthScore() {
		return OverallHealthScore;
	}

	public void setOverallHealthScore(Double overallHealthScore) {
		OverallHealthScore = overallHealthScore;
	}

	public Double getHardwareHealthScore() {
		return HardwareHealthScore;
	}

	public void setHardwareHealthScore(Double hardwareHealthScore) {
		HardwareHealthScore = hardwareHealthScore;
	}

	public Double getSoftwareHealthScore() {
		return SoftwareHealthScore;
	}

	public void setSoftwareHealthScore(Double softwareHealthScore) {
		SoftwareHealthScore = softwareHealthScore;
	}

	public Double getSubscribedCapacityTB() {
		return SubscribedCapacityTB;
	}

	public void setSubscribedCapacityTB(Double subscribedCapacityTB) {
		SubscribedCapacityTB = subscribedCapacityTB;
	}

	public Double getUsableCapacityTB() {
		return UsableCapacityTB;
	}

	public void setUsableCapacityTB(Double usableCapacityTB) {
		UsableCapacityTB = usableCapacityTB;
	}

	public Double getAllocatedCapacityTB() {
		return AllocatedCapacityTB;
	}

	public void setAllocatedCapacityTB(Double allocatedCapacityTB) {
		AllocatedCapacityTB = allocatedCapacityTB;
	}

	public Double getPercentUsedCapacity() {
		return PercentUsedCapacity;
	}

	public void setPercentUsedCapacity(Double percentUsedCapacity) {
		PercentUsedCapacity = percentUsedCapacity;
	}

	public Double getTotalPoolCapacity() {
		return TotalPoolCapacity;
	}

	public void setTotalPoolCapacity(Double totalPoolCapacity) {
		TotalPoolCapacity = totalPoolCapacity;
	}

	public Double getEnabledPoolCapacity() {
		return EnabledPoolCapacity;
	}

	public void setEnabledPoolCapacity(Double enabledPoolCapacity) {
		EnabledPoolCapacity = enabledPoolCapacity;
	}

	public Double getUsedPoolCapacity() {
		return UsedPoolCapacity;
	}

	public void setUsedPoolCapacity(Double usedPoolCapacity) {
		UsedPoolCapacity = usedPoolCapacity;
	}

	public Double getTotalSRPCapacity() {
		return TotalSRPCapacity;
	}

	public void setTotalSRPCapacity(Double totalSRPCapacity) {
		TotalSRPCapacity = totalSRPCapacity;
	}

	public Double getUsedSRPCapacity() {
		return UsedSRPCapacity;
	}

	public void setUsedSRPCapacity(Double usedSRPCapacity) {
		UsedSRPCapacity = usedSRPCapacity;
	}

	@Override
	public String toString() {
		return "Result [timestamp=" + timestamp + ", CriticalAlertCount=" + CriticalAlertCount + ", OverallHealthScore="
				+ OverallHealthScore + ", HardwareHealthScore=" + HardwareHealthScore + ", SoftwareHealthScore="
				+ SoftwareHealthScore + ", SubscribedCapacityTB=" + SubscribedCapacityTB + ", UsableCapacityTB="
				+ UsableCapacityTB + ", AllocatedCapacityTB=" + AllocatedCapacityTB + ", PercentUsedCapacity="
				+ PercentUsedCapacity + ", TotalPoolCapacity=" + TotalPoolCapacity + ", EnabledPoolCapacity="
				+ EnabledPoolCapacity + ", UsedPoolCapacity=" + UsedPoolCapacity + ", TotalSRPCapacity="
				+ TotalSRPCapacity + ", UsedSRPCapacity=" + UsedSRPCapacity + "]";
	}

	
}
