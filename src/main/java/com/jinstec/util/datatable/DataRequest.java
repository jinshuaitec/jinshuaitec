package com.jinstec.util.datatable;


import java.util.HashMap;
import java.util.Map;

public class DataRequest {
	//当前页码  
    private int pageIndex;
    //页面可显示行数  
    private int pageSize;
    //用于排序的列名  
    private String order;
    //排序的方式desc/asc  
    private String sort;
//    //搜索条件关键字
//    private String search;
	private Map<String,Object> params = new HashMap<>();
//    //额外查询条件
//	private String conditions;
//	//额外查询条件参数
//	private List<Object> params;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
