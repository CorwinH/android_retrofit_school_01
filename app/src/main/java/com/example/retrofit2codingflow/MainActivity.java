package com.example.retrofit2codingflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit2codingflow.users.users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);



/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://l3dev.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.getPost();

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d("","OnResponse: Server response: " + response.code());
                Toast.makeText(MainActivity.this,"OnResponse: Server response: " + response.code(), Toast.LENGTH_SHORT).show();


                ArrayList<users> userslist = response.body().getUsers();
                for (int i = 0; i<userslist.size(); i++){ // loop each one..
                    String content = "";
                    Toast.makeText(MainActivity.this, userslist.get(i).getFirst_name() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("TAG","Something went wronmg: " + t.getMessage());
                Toast.makeText(MainActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

*/


        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> openNewActivity());






    }
    public void openNewActivity(){
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

}