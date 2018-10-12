package com.sample.projects.myexam.interfaces;

import com.sample.projects.myexam.model.PersonModel;

/**
 * Created by Chyron-MACBOOK on 10/10/18.
 */

public interface MainInterface {

    interface onClick {
        void onItemClick(PersonModel personModel);
        String onClickGetData();
        void onClickClearCache();
    }
}
