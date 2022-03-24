package com.abdullahteke.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Response {

	private ResultList resultList;
	private String id;
	private Long count;
	private Long expirationTime;
	private Long maxPageSize;

	public ResultList getResultList() {
		return resultList;
	}

	public void setResultList(ResultList resultList) {
		this.resultList = resultList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Long getMaxPageSize() {
		return maxPageSize;
	}

	public void setMaxPageSize(Long maxPageSize) {
		this.maxPageSize = maxPageSize;
	}

	public Response() {
		super();
	}

	public Response(String string) {
		if (string.equalsIgnoreCase("Default")) {
			this.count=-1L;
			this.expirationTime=-1L;
			this.id=UUID.randomUUID().toString();
			this.maxPageSize=100L;
			this.resultList= new ResultList("Default");
		}
	}

	@Override
	public String toString() {
		return "Response [resultList=" + resultList + ", id=" + id + ", count=" + count + ", expirationTime="
				+ expirationTime + ", maxPageSize=" + maxPageSize + "]";
	}

}
