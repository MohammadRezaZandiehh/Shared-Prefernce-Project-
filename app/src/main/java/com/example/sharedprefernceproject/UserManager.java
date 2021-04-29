package com.example.sharedprefernceproject;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);
    }

    public void savedUserInformation (String fullName,
                                      String email,
                                      String gender){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("full_name", fullName);
        editor.putString("email", email);
        editor.putString("gender", gender);

        editor.apply();
    }


    public String getFullName(){
        return sharedPreferences.getString("full_name", "");
    }

    public String getEmail(){
        return sharedPreferences.getString("email", "");
    }

    public String getGender(){
        return sharedPreferences.getString("gender", "");
    }
}
