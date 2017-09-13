package com.example.fydel.javadevelopersinlagos.api;

import com.example.fydel.javadevelopersinlagos.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by FYDEL on 13-Sep-17.
 */

public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
