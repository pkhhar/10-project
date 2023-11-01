package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity
{
private Button btn;
private  Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.btnOtherPage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             intent = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
            }
        });
}

}