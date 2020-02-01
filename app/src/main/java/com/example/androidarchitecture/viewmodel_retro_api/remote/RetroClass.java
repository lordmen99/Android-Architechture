package com.example.androidarchitecture.viewmodel_retro_api.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidarchitecture.viewmodel_retro_api.model.Ticket;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    public static final String rootUrl="http://admin.parkmyway.com/";

    public static Retrofit getRetroInstance(){
        return new Retrofit.Builder()
                .baseUrl(rootUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APIService getApiService(){
        return getRetroInstance().create(APIService.class);
    }


    public MutableLiveData<Ticket> getTicket(){
        final MutableLiveData<Ticket> ticket = new MutableLiveData<>();
        APIService apiService = RetroClass.getApiService();

        apiService.getTicketJSON("CUST_0000219").enqueue(new Callback<Ticket>() {
            @Override
            public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                Log.e("response ",": resonse"+response.body());
                ticket.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {

            }
        });
        return ticket;
    }



}
