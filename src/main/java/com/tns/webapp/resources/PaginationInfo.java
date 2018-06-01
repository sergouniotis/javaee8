package com.tns.webapp.resources;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

public class PaginationInfo implements Serializable {

	@QueryParam("pageSize")
	private int pageSize;

	@QueryParam("pageNumber")
	private int pageNumber;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
