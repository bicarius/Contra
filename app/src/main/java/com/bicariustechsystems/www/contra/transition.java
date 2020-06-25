package com.bicariustechsystems.www.contra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class transition extends AppCompatActivity {
    private ImageButton personal,business;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        //Find view by ID
        personal=findViewById(R.id.personal);
        business=findViewById(R.id.business);
        //On button click
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(transition.this,register2.class);
                startActivity(intent);

            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(transition.this, register.class);
                startActivity(intent2);

            }
        });
    }
}
