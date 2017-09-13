package com.example.fydel.javadevelopersinlagos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by FYDEL on 13-Sep-17.
 */

public class ItemResponse {
    @SerializedName("items")
    @Expose
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item>items){
        this.items = items;
    }

}
