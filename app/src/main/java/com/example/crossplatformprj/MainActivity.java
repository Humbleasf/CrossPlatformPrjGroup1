package com.example.crossplatformprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText txtEmail, txtUnit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        txtEmail = findViewById(R.id.txtEmailL);
        txtUnit = findViewById(R.id.txtLUnit);
    }

    public void Login(View v)
    {
        Intent pro = new Intent(MainActivity.this,LogComplain.class);
        pro.putExtra("Unit", txtUnit.getText().toString());
        startActivity(pro);
    }

    public void Reg(View v)
    {
        startActivity(new Intent(MainActivity.this, AddResident.class));
    }

    public void Trust(View v)
    {
        startActivity(new Intent(MainActivity.this, complaints.class));
    }

    @Override
    public void setTitle(CharSequence title)
    {
        super.setTitle(title);

        TextView tv = new TextView(this);
        tv.setText(title);
    }

}