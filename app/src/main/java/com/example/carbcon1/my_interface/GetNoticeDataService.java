package com.example.carbcon1.my_interface;

import retrofit2.Call;
import retrofit2.http.GET;
import com.example.carbcon1.model.NoticeList;

import java.util.List;

public interface GetNoticeDataService
{
    @GET("api/food_Carbon_Emission")
    Call<NoticeList> getNoticeData();
}