package com.abdullahteke.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "SymmetrixMetrics")
public class SymmetrixMetrics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8330684173452889151L;

	@JacksonXmlProperty(localName = "SymmetrixMetric")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Map<String, Object>> symmetrixMetricList;

	public List<Map<String, Object>> getSymmetrixMetricList() {
		return symmetrixMetricList;
	}

	public void setSymmetrixMetricList(List<Map<String, Object>> symmetrixMetricList) {
		this.symmetrixMetricList = symmetrixMetricList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
