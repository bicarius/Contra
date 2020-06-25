package com.bicariustechsystems.www.contra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.security.SecureRandom;

public class register extends AppCompatActivity {
    // Define variables
    private EditText business, industry,country,county, town, contactname, phone,peoplenumber,time,numplate,route, sacconumber;
    private Button finish;
    private RequestQueue requestQueue;
    public static String api= "";
    public static  String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Find view by id
        business=findViewById(R.id.bname);
        industry=findViewById(R.id.industry);
        country=findViewById(R.id.country);
        county=findViewById(R.id.county);
        town=findViewById(R.id.town);
        contactname=findViewById(R.id.contactname);
        phone=findViewById(R.id.phonenumber);
        peoplenumber=findViewById(R.id.numpeople);
        time=findViewById(R.id.timein);
        numplate=findViewById(R.id.numplate);
        route=findViewById(R.id.route);
        sacconumber=findViewById(R.id.sacconumber);
        finish=findViewById(R.id.finish);
        requestQueue=Volley.newRequestQueue(register.this);


        //On button click;
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Convert Edittext to strings
                 String Sbusiness,Sindustry, Scountry, Scounty,Stown, Scontactnam, Sphone,Speoplenum,Stime,Snumplate, Sroute,Ssacconumber;
                 Sbusiness=business.getText().toString();
                 Sindustry=industry.getText().toString();
                 Scountry=country.getText().toString();
                 Scounty=county.getText().toString();
                 Stown=town.getText().toString();
                 Scontactnam=contactname.getText().toString();
                 Sphone=phone.getText().toString();
                 Speoplenum=peoplenumber.getText().toString();
                 Stime=time.getText().toString();
                 Snumplate=numplate.getText().toString();
                 Sroute=route.getText().toString();
                 Ssacconumber=sacconumber.getText().toString();
                 //create a unique identifier
                 String public_id;
                SecureRandom random= new SecureRandom();
                


                 //Parse the data as Json object and send to the API, if successful create a QRcode, save it

            }
        });

    }
}
