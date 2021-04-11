package com.krisa.utils;

import javax.validation.constraints.Positive;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PageRequest {
    @QueryParam("page")
    @DefaultValue("0")
    @Positive
    private int page;

    @QueryParam("size")
    @DefaultValue("3")
    @Positive
    private int size;

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
}
