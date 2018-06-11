package com.jinstec.util.datatable;

import java.io.Serializable;
import java.util.List;

/**
 * datatable返回结果
 * 
 * @author 
 * 
 */
public class DataResult implements Serializable {
	private String sEcho;
	private Long iTotalRecords;
	private Long iTotalDisplayRecords;
	private List aaData;

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List getAaData() {
		return aaData;
	}

	public void setAaData(List aaData) {
		this.aaData = aaData;
	}
}
