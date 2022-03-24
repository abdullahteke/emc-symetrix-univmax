package com.abdullahteke.model.thinpool;

import java.util.List;

public class ThinPoolMetricRequest {

	private Long startDate;
	private Long endDate;
	private String symmetrixId;
	private String poolId;
	private String dataFormat;
	private List<String> metrics;

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getSymmetrixId() {
		return symmetrixId;
	}

	public void setSymmetrixId(String symmetrixId) {
		this.symmetrixId = symmetrixId;
	}

	public String getPoolId() {
		return poolId;
	}

	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public List<String> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<String> metrics) {
		this.metrics = metrics;
	}

	public ThinPoolMetricRequest() {
		super();
	}

	@Override
	public String toString() {
		return "ThinPoolMetricRequest [startDate=" + startDate + ", endDate=" + endDate + ", symmetrixId=" + symmetrixId
				+ ", poolId=" + poolId + ", dataFormat=" + dataFormat + ", metrics=" + metrics + "]";
	}
	
}
