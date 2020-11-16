package com.example.retrofit2codingflow;

import com.example.retrofit2codingflow.users.users;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {
    /*
    id
    first_name
    last_name
    email
    last_login
    user_type
    created_date
     */

    private ArrayList<users> users;

    public ArrayList<com.example.retrofit2codingflow.users.users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<com.example.retrofit2codingflow.users.users> users) {
        this.users = users;
    }




    /*

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

     */
}
