package com.example.androidarchitecture.utility;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import com.example.androidarchitecture.R;

public class CustomPopUp extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {
    EditText et_pop1, et_pop2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_popup);
        et_pop1 = findViewById(R.id.et_pop1);
        et_pop2 = findViewById(R.id.et_pop2);


        et_pop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(CustomPopUp.this, v);
                popup.setOnMenuItemClickListener(CustomPopUp.this);
                popup.inflate(R.menu.popup_menu);
                popup.show();
            }
        });

        et_pop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(CustomPopUp.this, v);
                popup.setOnMenuItemClickListener(CustomPopUp.this);
                popup.inflate(R.menu.popup_menu);
                popup.show();
            }
        });


    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
//        case R.id.archive:
//            archive(item);
            return true;
//        case R.id.delete:
//            delete(item);
//            return true;
//        default:
//            return false;
    }
}
