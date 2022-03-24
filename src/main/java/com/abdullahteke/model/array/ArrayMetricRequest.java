package com.abdullahteke.model.array;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ArrayMetricRequest {

	private Long startDate;
	private Long endDate;
	private String symmetrixId;
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

	public ArrayMetricRequest() {
		super();
	}

	@Override
	public String toString() {
		return "ArrayMetricRequest [startDate=" + startDate + ", endDate=" + endDate + ", symmetrixId=" + symmetrixId
				+ ", dataFormat=" + dataFormat + ", metrics=" + metrics + "]";
	}
	
}
