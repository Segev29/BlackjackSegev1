package com.example.blackjacksegev;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private Button btnyes, btnno;
    private Context context;
    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_custom_dialog);

        btnyes = findViewById(R.id.btnyes);
        btnno = findViewById(R.id.btnno);
        btnno.setOnClickListener(this);
        btnyes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnyes)
        {
            //לעשות את הyes
        }
        if(btnno == v)
        {
            ((GameActivity) context).finish();
        }
    }
}
