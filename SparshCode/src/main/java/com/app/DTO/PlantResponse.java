package com.app.DTO;

import java.util.List;

public class PlantResponse {
     private List<PlantDto> content;
     private int pageNumber;
     private int pageSize;
     private int totalPage;
     private boolean lastPage;
	public List<PlantDto> getContent() {
		return content;
	}
	public void setContent(List<PlantDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
       
}
