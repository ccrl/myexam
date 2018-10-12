package com.sample.projects.myexam.eventhandler;

import android.content.Context;

import com.sample.projects.myexam.interfaces.PersonalDetailInterface;

/**
 * Created by Chyron-MACBOOK on 10/10/18.
 */

public class PersonalDetailEventHandler {

    private Context context;
    private PersonalDetailInterface.onClick onClickInterface;

    public PersonalDetailEventHandler(Context context,
                                      PersonalDetailInterface.onClick onClickInterface) {
        this.context = context;
        this.onClickInterface = onClickInterface;
    }

    public void ehOnClickCloseButton() {
        onClickInterface.onClickCloseButton();
    }
}
