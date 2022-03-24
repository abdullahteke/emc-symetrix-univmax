package com.abdullahteke.model;

import java.util.ArrayList;
import java.util.List;

public class ResultList {

	private Long from;
	private Long to;
	List<Result> result;

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public ResultList() {
		super();
	}

	public ResultList(String string) {
		if (string.equalsIgnoreCase("Default")) {
			this.from=-1L;
			this.to=-1L;
			this.result= new ArrayList<Result>();
			this.result.add(new Result("Default"));
		}
	}

	@Override
	public String toString() {
		return "ResultList [from=" + from + ", to=" + to + ", result=" + result + "]";
	}
	
}
