package com.sample.projects.myexam.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sample.projects.myexam.R;
import com.sample.projects.myexam.activity.PersonDetailActivity;
import com.sample.projects.myexam.adapter.MainAdapter;
import com.sample.projects.myexam.data.DataProvider;
import com.sample.projects.myexam.data.MySharedPreferences;
import com.sample.projects.myexam.databinding.ActivityMainBinding;
import com.sample.projects.myexam.eventhandler.MainEventHandler;
import com.sample.projects.myexam.interfaces.MainInterface;
import com.sample.projects.myexam.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MainInterface.onClick {

    private ActivityMainBinding binding;
    private MainEventHandler eh;
    private List<PersonModel> personModelList;

    private DataProvider dataProvider;
    private MySharedPreferences mySharedPreferences;
    private RecyclerView mRecyclerView;
    private LinearLayout mLayoutMainContainer;
    private RelativeLayout mLayoutEmptyContainer;

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String BIRTHDAY = "birthday";
    public static final String EMAIL = "emailAddress";
    public static final String MOBILE = "mobile";
    public static final String ADDRESS = "address";
    public static final String CONTACT_PERSON = "contactPerson";
    public static final String CONTACT_PERSON_MOBILE = "contactPersonMobile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutResourceId());
        personModelList = new ArrayList<>();

        setupViewBinding();
        setupMySharedPreferences();
        setupRecyclerViewAdapter();
    }

    private void setupViewBinding() {
        dataProvider = new DataProvider();
        mRecyclerView = binding.mRecyclerView;
        mLayoutMainContainer = binding.mLayoutMainContainer;
        mLayoutEmptyContainer = binding.mLayoutEmptyContainer;
    }

    private void setupMySharedPreferences() {
        mySharedPreferences = new MySharedPreferences(this);
    }

    private void setupRecyclerViewAdapter() {
        eh = new MainEventHandler(this, this);
        binding.setMainEh(eh);

        if (mySharedPreferences.readSharedPreferences() == null) {
            mLayoutMainContainer.setVisibility(View.GONE);
            mLayoutEmptyContainer.setVisibility(View.VISIBLE);
        } else {
            mLayoutMainContainer.setVisibility(View.VISIBLE);
            mLayoutEmptyContainer.setVisibility(View.GONE);

            personModelList = eh.convertListToModel(mySharedPreferences.readSharedPreferences());

            MainAdapter adapter = new MainAdapter(this, personModelList,  this);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(PersonModel personModel) {
        Intent intent = new Intent(this, PersonDetailActivity.class);
        intent.putExtra(FIRST_NAME, personModel.getFirstName());
        intent.putExtra(LAST_NAME, personModel.getLastName());
        intent.putExtra(BIRTHDAY, personModel.getBirthday());
        intent.putExtra(EMAIL, personModel.getEmailAddress());
        intent.putExtra(MOBILE, personModel.getMobile());
        intent.putExtra(ADDRESS, personModel.getAddress());
        intent.putExtra(CONTACT_PERSON, personModel.getContactPerson());
        intent.putExtra(CONTACT_PERSON_MOBILE, personModel.getContactPersonMobile());
        startActivity(intent);
    }

    @Override
    public String onClickGetData() {
        mySharedPreferences.writeSharedPreferences(eh.convertListToJSON(dataProvider.getPersonListData()));

        mLayoutEmptyContainer.setVisibility(View.GONE);
        mLayoutMainContainer.setVisibility(View.VISIBLE);

        setupRecyclerViewAdapter();

        return mySharedPreferences.readSharedPreferences();
    }

    @Override
    public void onClickClearCache() {
        mySharedPreferences.clearSharedPreferences();

        mLayoutEmptyContainer.setVisibility(View.VISIBLE);
        mLayoutMainContainer.setVisibility(View.GONE);

    }

    private int getLayoutResourceId() {
        return R.layout.activity_main;
    }
}
