package com.example.androidarchitecture;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.androidarchitecture.notification_channel.NotificationMainActivity;
import com.example.androidarchitecture.room_dao_recyclerview.MainActivity;
import com.example.androidarchitecture.utility.CustomPopUp;
import com.example.androidarchitecture.viewmodel_retro_api.MainActivityTicket;

public class NavigatingActivityMain extends AppCompatActivity {

    public TextView tv_room_dao, tv_viewmodel_api, tv_notification, tv_custom_popup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigating_activity);

        tv_room_dao = findViewById(R.id.tv_room_dao);
        tv_viewmodel_api = findViewById(R.id.tv_viewmodel_api);
        tv_notification = findViewById(R.id.tv_notification);
        tv_custom_popup = findViewById(R.id.tv_custom_popup);

        tv_room_dao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigatingActivityMain.this, MainActivity.class));
            }
        });

        tv_viewmodel_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigatingActivityMain.this, MainActivityTicket.class));
            }
        });

        tv_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigatingActivityMain.this, NotificationMainActivity.class));
            }
        });

        tv_custom_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigatingActivityMain.this, CustomPopUp.class));
            }
        });

    }
}
