package com.example.retrofit2codingflow;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit2codingflow.users.users;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecyclerViewActivity extends AppCompatActivity {

    private TextView textViewResult;


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ExampleItem> exampleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_workers);






        //exampleList.add(new ExampleItem(R.drawable.ic_face_smile, "Line 1", "Line 2"));
        //exampleList.add(new ExampleItem(R.drawable.ic_face_smile, "Line 1", "Line 2"));






        textViewResult = findViewById(R.id.text_view_result);

        // Retrofit
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
                Toast.makeText(RecyclerViewActivity.this,"OnResponse: Server response: " + response.code(), Toast.LENGTH_SHORT).show();


                ArrayList<users> userslist = response.body().getUsers();
                for (int i = 0; i<userslist.size(); i++){ // loop each one..
                    String content = "";
                    //Toast.makeText(RecyclerViewActivity.this, userslist.get(i).getFirst_name() , Toast.LENGTH_SHORT).show();

                    exampleList.add(new ExampleItem(R.drawable.ic_face_smile, userslist.get(i).getFirst_name(), "Line 2"));

                    //exampleList.add(new ExampleItem(R.drawable.ic_face_smile, "Line 1", "Line 2"));
                    loadlist();


                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("TAG","Something went wronmg: " + t.getMessage());
                Toast.makeText(RecyclerViewActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        // Retrofit








    }
    public void  loadlist() {
        // Recycler View
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //
    }


}