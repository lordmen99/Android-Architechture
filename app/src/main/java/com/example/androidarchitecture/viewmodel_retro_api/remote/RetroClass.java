package com.example.androidarchitecture.viewmodel_retro_api.remote;

import android.util.Log;
import com.example.androidarchitecture.viewmodel_retro_api.model.Ticket;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    public static final String rootUrl="http://webapi.risingpole.com";

    public static Retrofit getRetroInstance(){

        return new Retrofit.Builder().baseUrl(rootUrl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APIService getApiService(){

        return getRetroInstance().create(APIService.class);
    }

    public Ticket getTicket(){
        final Ticket ticket = new Ticket();
        APIService apiService = RetroClass.getApiService();

        apiService.getTicketJSON().enqueue(new Callback<Ticket>() {
            @Override
            public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                Log.e("response ",": resonse"+response.body());
                Ticket tik = response.body();
                ticket.setTicketid(tik.ticketid);
                ticket.setTicketname(tik.ticketname);
                ticket.setTicketdesc(tik.ticketdesc);

            }

            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {

            }
        });
        return ticket;
    }

}
