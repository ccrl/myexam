package com.sample.projects.myexam.eventhandler;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.sample.projects.myexam.data.MySharedPreferences;
import com.sample.projects.myexam.interfaces.MainInterface;
import com.sample.projects.myexam.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Chyron-MACBOOK on 10/11/18.
 */

public class MainEventHandler {

    private Context context;
    private MainInterface.onClick onClickInterface;

    public MainEventHandler(Context context,
                            MainInterface.onClick onClickInterface) {
        this.context = context;
        this.onClickInterface = onClickInterface;
    }

    public String convertListToJSON(List<PersonModel> personModelList) {
        return new Gson().toJson(personModelList);
    }

    public List<PersonModel> convertListToModel(String json) {
        List<PersonModel> personModelList = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; jsonArray.length() > i; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                personModelList.add(gson.fromJson(jsonObject.toString(), PersonModel.class));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personModelList;
    }

    public void getData() {
        onClickInterface.onClickGetData();
    }

    public void clearCache() {
        onClickInterface.onClickClearCache();
    }
}
