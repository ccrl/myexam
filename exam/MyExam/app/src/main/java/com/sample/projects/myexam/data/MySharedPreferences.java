package com.sample.projects.myexam.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.sample.projects.myexam.model.PersonModel;

/**
 * Created by Chyron-MACBOOK on 10/10/18.
 */

public class MySharedPreferences {

    private Context context;
    private String MAIN_LIST_JSON = "MAIN_LIST_JSON";
    private String KEY_PERSON_JSON = "KEY_PERSON_JSON";

    public MySharedPreferences(Context context) {
        this.context = context;
    }

    public void writeSharedPreferences(String json) {
        SharedPreferences sharedPref = context.getSharedPreferences(MAIN_LIST_JSON, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_PERSON_JSON, json).apply();
    }

    public String readSharedPreferences() {
        String json = null;
        SharedPreferences sharedPref = context.getSharedPreferences(MAIN_LIST_JSON, Context.MODE_PRIVATE);
        return sharedPref.getString(KEY_PERSON_JSON, json);
    }

    public void clearSharedPreferences() {
        SharedPreferences sharedPref = context.getSharedPreferences(MAIN_LIST_JSON, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear().apply();
    }
}
