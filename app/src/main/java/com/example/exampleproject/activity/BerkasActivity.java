package com.example.exampleproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.exampleproject.R;

public class BerkasActivity extends AppCompatActivity {

    AppCompatButton simpan;
    EditText nama, nik, alamat, no_hp, jenis_kelamin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas);

        simpan = findViewById(R.id.simpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent simpan = new Intent(BerkasActivity.this,BerkasActivity1.class);
            }
        });
    }
}