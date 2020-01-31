package com.example.androidarchitecture.viewmodel_retro_api.remote;

import com.example.androidarchitecture.viewmodel_retro_api.model.Ticket;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

 @GET("/api/CustomerAccount/GetDeliveryAddress?CustomerCode=CMP_000003")
    Call<Ticket> getTicketJSON();

}
