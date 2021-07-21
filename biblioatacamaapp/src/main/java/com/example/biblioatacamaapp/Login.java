package com.example.biblioatacamaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PostProcessor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.biblioatacamaapp.interfaces.APIInterface;
import com.example.biblioatacamaapp.models.App;
import com.example.biblioatacamaapp.models.User;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class Login extends AppCompatActivity implements Serializable {

    private User usuarioActual;
    private boolean pass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        EditText editTextPw = (EditText) findViewById(R.id.editTextTextPassword);
        Button buttonLogin = (Button) findViewById(R.id.button);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editTextUsername.getText().toString();
                String password = editTextPw.getText().toString();

                if(validarCredenciales(editTextUsername.getText().toString(),editTextPw.getText().toString())){

                    Intent next = new Intent(v.getContext(), Biblioteca.class);
                    next.putExtra("userId",usuarioActual.getId());
                    next.putExtra("username",usuarioActual.getUsername());
                    next.putExtra("password",usuarioActual.getPassword());
                    next.putExtra("nombre",usuarioActual.getNombre());
                    startActivity(next);
                    finish();
                }else{
                    Toast.makeText(Login.this, "Error, credenciales incorrectas ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validarCredenciales(String username, String password){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.102:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        Call<User> call = apiInterface.validarCredenciales(username,password);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!response.isSuccessful()) {
                    Toast.makeText(Login.this,"Error en la solicitud " + response.message(),Toast.LENGTH_LONG);
                    Log.d(TAG, "onResponse()");
                    return;
                }
                usuarioActual = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG);
                Log.d(TAG, "OnFailure()");
            }
        });

        try{
            if(usuarioActual.getId()>0){
                return true;
            }

        }catch (Exception ex){
            Log.d(TAG,ex.getMessage());
        }
        return false;
    }

}