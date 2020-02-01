package com.example.androidarchitecture.viewmodel_retro_api.remote;

import com.example.androidarchitecture.viewmodel_retro_api.model.Ticket;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

 @GET("api/Customer/GetCustomerDetails")
    Call<Ticket> getTicketJSON(@Query("CustomerId") String val);

}
