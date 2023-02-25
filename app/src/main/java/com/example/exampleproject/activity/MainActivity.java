package com.example.exampleproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exampleproject.R;
import com.example.exampleproject.api.ApiInterfaces;
import com.example.exampleproject.api.ApiServer;
import com.example.exampleproject.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnRegister;
    EditText name, email, password;
    String sName, sEmail, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

//        Log.d("TAG", "onClick: "+Name+" "+Email+" "+Password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName = name.getText().toString();
                sEmail = email.getText().toString();
                sPassword = password.getText().toString();
                Log.d("TAG", "onClick: "+sName);
                register(sName, sEmail, sPassword);
            }
        });
    }

    private void register(String name, String email, String password) {
        ApiInterfaces interfaces = ApiServer.konekRetrofit().create(ApiInterfaces.class);
        Call<ResponseLogin> call = interfaces.dataRegister(name, email, password, password);
        Log.d("TAG", "register: "+name);

        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Silahkan cek email", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Gagal melakukan registarsi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}