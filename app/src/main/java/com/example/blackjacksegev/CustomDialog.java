package com.example.blackjacksegev;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private Button btnyes;
    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_custom_dialog);

        btnyes = findViewById(R.id.btnunderstood);
        btnyes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
