package com.krisa.utils;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

public class PagedResponse<T> {

    private List<T> data;

    private int page;
    private int size;
    private long totalRecords;
    private long totalPages;

    public PagedResponse() {
    }

    public PagedResponse(PanacheQuery<T> entity) {
        this.data = entity.list();
        this.page = entity.page().index;
        this.size = entity.page().size;
        this.totalPages = entity.pageCount();
        this.totalRecords = entity.count();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
