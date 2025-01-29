package com.example.loginapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPrefs {
    Context context;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String KEY_NAME="name";
    public static final String KEY_MOBILE="mobile";
    public static final String KEY_IS_LOGGED_IN="isLoggedIn";
    public static final String KEY_PASSWORD="password";
    public MyPrefs(Context context) {
        this.context = context;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
    }

    public void setName(String name)
    {
        editor.putString(KEY_NAME,name);
        editor.commit();
    }
    public String getName(){
        return sharedPreferences.getString(KEY_NAME,"NULL");
    }

    public void setMobile(String mobile)
    {
        editor.putString(KEY_MOBILE,mobile);
        editor.commit();
    }
    public String getMobile(){
        return sharedPreferences.getString(KEY_MOBILE,"NULL");
    }

    public void setPassword(String password)
    {
        editor.putString(KEY_PASSWORD,password);
        editor.commit();
    }
    public String getPassword(){
        return sharedPreferences.getString(KEY_PASSWORD,"NULL");
    }

    public void setIsLoggedIn(boolean b)
    {
        editor.putBoolean(KEY_IS_LOGGED_IN,b);
        editor.commit();
    }
    public boolean getIsLoggedIn(){
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN,false);
    }

    public void clearAll(){
        editor.clear();
        editor.commit();
        editor.apply();
    }
}
