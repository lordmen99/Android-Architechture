package com.example.androidarchitecture.viewmodel_retro_api;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.androidarchitecture.R;
import com.example.androidarchitecture.viewmodel_retro_api.viewmodel.TicketViewModel;

public class MainActivityTicket extends AppCompatActivity {

    private TicketViewModel ticketViewModel;
    private TextView ticketid, ticketname, ticketdesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_layout);

        ticketid = findViewById(R.id.ticketId);
        ticketname = findViewById(R.id.ticketname);
        ticketdesc = findViewById(R.id.ticketdesc);

        ticketViewModel = ViewModelProviders.of(this).get(TicketViewModel.class);
        ticketViewModel.getTicketValue();


    }


    public void getTokenView(View view){
        String ticketidval = ticketViewModel.getTicketValue().getTicketid().toString();
        ticketid.setText(ticketidval);

        String ticketnameval = ticketViewModel.getTicketValue().getTicketname().toString();
        ticketname.setText(ticketnameval);

        String ticketdescval = ticketViewModel.getTicketValue().getTicketdesc().toString();
        ticketdesc.setText(ticketdescval);

    }

}
