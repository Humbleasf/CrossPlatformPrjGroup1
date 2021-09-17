package com.example.crossplatformprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViewMyComplaints extends AppCompatActivity
{
    String UnitID;
    TextView txtComplaints;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_complaints);

        Intent getID = getIntent();
        UnitID = getID.getExtras().getString("Unit");

        String url = "https://prjapiice20210917090323.azurewebsites.net/api/UserComplaint?code=TZL1HS7fh5G2OBq03t61GJEkGkrB33xXOg1bp41UUfAomTPu8VR2Kg==&unitID=" + UnitID;
        RequestQueue que = Volley.newRequestQueue(this);
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    String strDisplay = "";
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject JOUser = response.getJSONObject(i);
                        JSONObject JOUser2 = JOUser.getJSONObject("User");

                        String strCID = JOUser2.getString("CID");
                        String strUnitID = JOUser2.getString("unitID");
                        String strComplaint = JOUser2.getString("Complain");
                        strDisplay += strCID + ": " + strComplaint + ".\n";
                        strDisplay += "***************************\n";
                        txtComplaints.setText(strDisplay);
                    }
                }
                catch (Exception e)
                {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley", "error with:" + error.toString());
            }

        });
        que.add(req);

        txtComplaints = findViewById(R.id.txtComplaintR);
    }

    public void BackR(View v)
    {
        startActivity(new Intent(ViewMyComplaints.this, LogComplain.class));

    }

}