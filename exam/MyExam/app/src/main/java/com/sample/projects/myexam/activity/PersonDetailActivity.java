package com.sample.projects.myexam.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.sample.projects.myexam.R;
import com.sample.projects.myexam.data.MySharedPreferences;
import com.sample.projects.myexam.databinding.ActivityPersonDetailBinding;
import com.sample.projects.myexam.eventhandler.PersonalDetailEventHandler;
import com.sample.projects.myexam.interfaces.MainInterface;
import com.sample.projects.myexam.interfaces.PersonalDetailInterface;
import com.sample.projects.myexam.main.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.sample.projects.myexam.main.MainActivity.ADDRESS;
import static com.sample.projects.myexam.main.MainActivity.BIRTHDAY;
import static com.sample.projects.myexam.main.MainActivity.CONTACT_PERSON;
import static com.sample.projects.myexam.main.MainActivity.CONTACT_PERSON_MOBILE;
import static com.sample.projects.myexam.main.MainActivity.EMAIL;
import static com.sample.projects.myexam.main.MainActivity.FIRST_NAME;
import static com.sample.projects.myexam.main.MainActivity.LAST_NAME;
import static com.sample.projects.myexam.main.MainActivity.MOBILE;

public class PersonDetailActivity extends Activity
    implements PersonalDetailInterface.onClick {

    private ActivityPersonDetailBinding binding;
    private AppCompatTextView mTVFirstName;
    private AppCompatTextView mTVLastName;
    private AppCompatTextView mTVBirthday;
    private AppCompatTextView mTVAge;
    private AppCompatTextView mTVEmailAddress;
    private AppCompatTextView mTVMobile;
    private AppCompatTextView mTVAddress;
    private AppCompatTextView mTVContactPerson;
    private AppCompatTextView mTVContactPersonMobile;
    private PersonalDetailEventHandler eh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutResourceId());

        setupViewBinding();
        setupBundle();
        setupEventHandler();
    }

    private void setupViewBinding() {
        mTVFirstName = binding.mTVFirstName;
        mTVLastName = binding.mTVLastName;
        mTVBirthday = binding.mTVBirthday;
        mTVAge = binding.mTVAge;
        mTVAddress = binding.mTVAddress;
        mTVEmailAddress = binding.mTVEmail;
        mTVMobile = binding.mTVMobile;
        mTVAddress = binding.mTVAddress;
        mTVContactPerson = binding.mTVContactPerson;
        mTVContactPersonMobile = binding.mTVContactPersonNumber;
    }

    private void setupBundle() {
        mTVFirstName.setText(getIntent().getStringExtra(FIRST_NAME));
        mTVLastName.setText(getIntent().getStringExtra(LAST_NAME));
        mTVAge.setText(getAgeFromBirthday(getIntent().getStringExtra(BIRTHDAY)));
        mTVBirthday.setText(getIntent().getStringExtra(BIRTHDAY));
        mTVEmailAddress.setText(getIntent().getStringExtra(EMAIL));
        mTVMobile.setText(getIntent().getStringExtra(MOBILE));
        mTVAddress.setText(getIntent().getStringExtra(ADDRESS));
        mTVContactPerson.setText(getIntent().getStringExtra(CONTACT_PERSON));
        mTVContactPersonMobile.setText(getIntent().getStringExtra(CONTACT_PERSON_MOBILE));
    }

    public String getAgeFromBirthday(String birthday) {
        int age = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        try {
            Date date = sdf.parse(birthday);
            Calendar today = Calendar.getInstance();
            Calendar bday = Calendar.getInstance();
            bday.setTime(date);

            age = today.get(Calendar.YEAR) - bday.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(age);
    }

    private void setupEventHandler() {
        eh = new PersonalDetailEventHandler(this, this);
        binding.setEventHandler(eh);
    }

    @Override
    public void onClickCloseButton() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    private int getLayoutResourceId() {
        return R.layout.activity_person_detail;
    }
}
