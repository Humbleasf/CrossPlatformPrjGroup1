package com.example.crossplatformprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class complaints extends AppCompatActivity
{
    EditText txtComp;
    TextView txtComplaint;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);
        txtComp = findViewById(R.id.txtCComp);
        txtComplaint = findViewById(R.id.txtComplaintsT);
    }

    public void Resolve(View v)
    {
        String resolved = "Resolved";
        String strCID = txtComp.getText().toString();
        String url ="https://prjapiice20210917090323.azurewebsites.net/api/UpdateComplaint?code=qRbVVIR4dNhN/J0Eh1yB7olPd0QqBtVlFxU45M2mXC1CexQP3qTSEg==&CID=" + strCID + "&Resolved=" + resolved;
        RequestQueue que2 = Volley.newRequestQueue(this);
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
        que2.add(req);
    }

    public void Search(View v)
    {

        String strCID = txtComp.getText().toString();

        String url = "https://prjapiice20210917090323.azurewebsites.net/api/SingleComplaint?code=Zz6KwbvFTU3EM2mZlizhHgXeRNtcBXZaGOov5i0tr6K66JGvajvfdA==&CID=" + strCID;
        RequestQueue que = Volley.newRequestQueue(this);
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{

                    JSONObject JOUser = response.getJSONObject(0);
                    JSONObject JOUser2 = JOUser.getJSONObject("User");

                    String strCID = JOUser2.getString("CID");
                    String strUnitID = JOUser2.getString("unitID");
                    String strComplaint = JOUser2.getString("Complain");
                    String strDisplay = strCID + ": " + strComplaint + ".\n";
                    txtComplaint.setText(strDisplay);
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
    }
}