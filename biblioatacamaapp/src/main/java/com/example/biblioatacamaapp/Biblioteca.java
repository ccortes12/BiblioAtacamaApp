package com.example.biblioatacamaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.biblioatacamaapp.interfaces.APIInterface;
import com.example.biblioatacamaapp.models.Libro;
import com.example.biblioatacamaapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class Biblioteca extends AppCompatActivity {

    private List<Libro> listaLibros;
    private User usuarioActivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libreria);

        getSupportActionBar().setTitle("Biblioteca personal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getLibros();

        //Integer userId = getIntent().getIntExtra("userId");

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                new AlertDialog.Builder(Biblioteca.this)
                        .setTitle("Fin de sesión")
                        .setMessage("¿Desea salir de la sesión?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(Biblioteca.this, Login.class);
                                startActivity(intent);
                                finish();

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("Mensaje" , "Se cancelo acción");
                            }
                        })
                        .show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getLibros(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.102:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        Call<List<Libro>> call = apiInterface.getListaLibros();

        call.enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(Biblioteca.this,"ERROR " + response.code(),Toast.LENGTH_LONG);
                    return;
                }

                List<Libro> list2 = response.body();


            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Toast.makeText(Biblioteca.this,t.getMessage() ,Toast.LENGTH_LONG);
                Log.d(TAG, "OnFailure()");
            }
        });



    }
}