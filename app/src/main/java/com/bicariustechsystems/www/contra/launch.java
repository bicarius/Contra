package com.bicariustechsystems.www.contra;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class launch extends AppCompatActivity {
    //Get variables
    private Button SignIn;
    private EditText Password, cID;
    private TextView Register;
    RequestQueue requestQueue;
    private static String api="";
    private static String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        //Find views by Id
        SignIn=findViewById(R.id.signin);
        Password=findViewById(R.id.password);
        cID=findViewById(R.id.contraid);
        Register=findViewById(R.id.registertext);
        // Volley REQUEST QUEUE
        requestQueue = Volley.newRequestQueue(launch.this);
        //On text Click
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch intent
            }
        });
        // On ButtonClick
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Convert the text to string
               final String Spassword=Password.getText().toString();
               final String Scid=cID.getText().toString();
               //MAKE THE POST REQUEST
                final ProgressDialog pDialog = new ProgressDialog(launch.this);
                pDialog.setMessage("Loading...");
                pDialog.show();
                //JSON REQUEST
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, api, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(launch.this, "Welcome!", Toast.LENGTH_SHORT).show();
                        pDialog.hide();
                        //Transition to the next activity
                        Intent intent= new Intent(launch.this, transition.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        Toast.makeText(launch.this, "Unable to connect.Check Internet", Toast.LENGTH_SHORT).show();
                        pDialog.hide();
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() {
                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<>();
                        // Adding All values to Params.
                        params.put("contraid", Scid);
                        params.put("password", Spassword);
                        return params;
                    }
                };
                //Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(launch.this);
                // Adding the StringRequest object into requestQueue.
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}
