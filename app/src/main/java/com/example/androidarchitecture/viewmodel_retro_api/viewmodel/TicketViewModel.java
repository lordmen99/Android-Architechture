package com.example.androidarchitecture.viewmodel_retro_api.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.example.androidarchitecture.viewmodel_retro_api.model.Ticket;
import com.example.androidarchitecture.viewmodel_retro_api.remote.RetroClass;

public class TicketViewModel extends ViewModel {

    private Ticket ticket;
    private RetroClass retroClass = new RetroClass();

    public Ticket getTicketValue(){
        if(ticket==null){
            ticket = retroClass.getTicket();
        }

        return ticket;
    }


}
