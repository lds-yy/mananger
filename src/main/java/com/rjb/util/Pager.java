package com.rjb.util;

public class Pager {
    //当前页
    private int pageIndex ;
    //每页条数
    private int pageSize = 10;
    //当前条件下总的数据量
    private int totalCount;
    //总共能分多少页
    private int totalPages;

    @Override
    public String toString() {
        return "Pager{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                '}';
    }

    public Pager() {
    }

    public int getPageIndex() {
        //小于等于0，则是第一页
        pageIndex = pageIndex<=0 ? 1:pageIndex;
        //防止越界
        pageIndex = pageIndex>=getTotalPages()?getTotalPages():pageIndex;
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

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        //总数据量/每页条数=总共多少页
        //10条数据3 -->3 该情况就能得到解决
        //9条数据3 -->3
        return (this.getTotalCount() - 1)/this.getPageSize()+1;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getFirstParam(){
        return (this.getPageIndex() - 1)*this.getPageSize();
    }
}
