package com.example.crossplatformprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogComplain extends AppCompatActivity
{
    EditText txtComplaint;
    String UnitID;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_complain);

        txtComplaint = findViewById(R.id.txtComplaint);
    }

    public void Post(View v)
    {
        //https://prjapiice20210917090323.azurewebsites.net/api/AddComplaint?code=pJUmn6aeaBRzVhihtI2vaIiUMkrKE4pA149H7cjtPp/tACH29hHENQ==
        Intent getID = getIntent();
        UnitID = getID.getExtras().getString("Unit");
        String resolve = "Unresolved";
        String Complaint = txtComplaint.getText().toString();
        String url = "https://prjapiice20210917090323.azurewebsites.net/api/AddComplaint?code=pJUmn6aeaBRzVhihtI2vaIiUMkrKE4pA149H7cjtPp/tACH29hHENQ==&UnitID=" + UnitID + "&complaint=" + Complaint + "&Resolved=" + resolve;
        url=url.replaceAll(" ", "%20");
        Log.d("Test", "Test" + url);
        RequestQueue que = Volley.newRequestQueue(this);
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley", "error with:" + error.toString());
            }

        });
        que.add(req);
    }

    public void MyComplaints(View v)
    {
        Intent getID = getIntent();
        UnitID = getID.getExtras().getString("Unit");
        Intent pro = new Intent(this,ViewMyComplaints.class);
        pro.putExtra("Unit", UnitID);
        startActivity(pro);
    }
}