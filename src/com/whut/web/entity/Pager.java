package com.whut.web.entity;

import java.util.List;

public class Pager<T> {
	
	private List<T> list;
	
	private int totalRows;
	private int page; // current page
	private int count; // page size
	
	public Pager() {
		super();
	}

	public Pager(List<T> list, int totalRows, int page, int count) {
		super();
		this.list = list;
		this.totalRows = totalRows;
		this.setPage(page);
		this.setCount(count);
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


}
