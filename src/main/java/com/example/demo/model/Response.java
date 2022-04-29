package com.example.demo.model;

import java.util.List;

public class Response {
    private List<String> item_ids ;
    private Integer total;

    public Response(List<String> item_ids, Integer total) {
        this.item_ids = item_ids;
        this.total = total;
    }

    public Response() {
        this.total = new Integer(0);
    }

    
    public List<String> getItem_ids() {
        return item_ids;
    }
    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }  


}
