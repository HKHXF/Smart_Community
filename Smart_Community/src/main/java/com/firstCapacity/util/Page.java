package com.firstCapacity.util;
import java.util.ArrayList;  
import java.util.List;  
  
  
public class Page {
	
    private int pageSize=10;            //页大小  
    private int pageIndex=1;           //当前页号  
    private int totalPageCount=0;      //总页数  
    private int record=0;              //记录总数  
    private Integer nextPage;          //下一页  
    private Integer prePage;           //上一页  
    private List<Object> contents=new ArrayList<Object>();     //实体集合
    
    
    
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public List<Object> getContents() {
		return contents;
	}
	public void setContents(List<Object> contents) {
		this.contents = contents;
	}
      
      
      
  
   
      
  
}  