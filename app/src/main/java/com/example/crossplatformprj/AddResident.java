package com.example.crossplatformprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

public class AddResident extends Activity
{
    String strAPI = "";

    EditText txtUnit, txtName, txtSurname, txtEmail, txtCell, txtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resident);

        txtCell = findViewById(R.id.txtCell);
        txtUnit = findViewById(R.id.txtUnit);
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        txtEmail = findViewById(R.id.txtREmail);
        txtYear = findViewById(R.id.txtYear);


    }
    public void Add(View V)
    {
        String strUnitID = txtUnit.getText().toString();
        String strName = txtName.getText().toString();
        String strSurname = txtSurname.getText().toString();
        String strEmail = txtEmail.getText().toString();
        String strCell = txtCell.getText().toString();
        String strYear = txtYear.getText().toString();

        String url = "https://prjapiice20210917090323.azurewebsites.net/api/AddUser?code=0LTvkWz78GUE0oNgF7kIFAg8lVHjPBsnHlU43G/pQ8HTqlXm2gL8BA==&unitID=" + strUnitID +
                "&name=" + strName +"&surname=" + strSurname + "&email=" + strEmail +"&cellnumber=" + strCell + "&year=" + strYear;
        RequestQueue que = Volley.newRequestQueue(this);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley", "error with:" + error.toString());
            }

        });
        que.add(req);
    }
    public void Update(View v)
    {
        String strUnitID = txtUnit.getText().toString();
        String strName = txtName.getText().toString();
        String strSurname = txtSurname.getText().toString();
        String strEmail = txtEmail.getText().toString();
        String strCell = txtCell.getText().toString();
        String strYear = txtYear.getText().toString();

        String url = "https://prjapiice20210917090323.azurewebsites.net/api/UpdateUser?code=cDzkufTIwMdmcMrRYj/LvbFp3K5yOdDgZiZb3AAt2/PVI0jQGebwmg==&unitID=" + strUnitID +
                "&name=" + strName +"&surname=" + strSurname + "&email=" + strEmail +"&cellnumber=" + strCell + "&year=" + strYear;
        RequestQueue que = Volley.newRequestQueue(this);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
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