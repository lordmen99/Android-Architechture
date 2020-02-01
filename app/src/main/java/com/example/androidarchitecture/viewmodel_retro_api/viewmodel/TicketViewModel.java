package com.example.androidarchitecture.viewmodel_retro_api.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidarchitecture.viewmodel_retro_api.model.Ticket;
import com.example.androidarchitecture.viewmodel_retro_api.remote.RetroClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class TicketViewModel extends ViewModel {
    Activity activity;

    //this is the data that we will fetch asynchronously
    private MutableLiveData<Ticket> ticket;

    private RetroClass retroClass = new RetroClass();

    public LiveData<Ticket> getTicketValue(Activity activity){
        this.activity = activity;
        if(ticket==null){
            Log.e("inside null object","");
            ticket = new MutableLiveData<Ticket>();
//            ticket.setValue(retroClass.getTicket());
            getRating();

        }else {
            Log.e("inside object exist","");
        }
        return ticket;
    }

    public void getRating() {
        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";

        String url = "http://admin.parkmyway.com/api/Customer/GetCustomerDetails?CustomerId=CUST_0000219";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response --- ", "Response ---" + response.toString());

                        Gson gson;
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                        gson = gsonBuilder.create();

                        Ticket ticketo = new Ticket();
                        ticketo = gson.fromJson(response.toString(), Ticket.class);
                        ticket.setValue(ticketo);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(final VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.add(jsonObjReq);


    }


}
