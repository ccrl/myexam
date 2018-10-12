package com.sample.projects.myexam.data;

import com.sample.projects.myexam.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/10/18.
 */

public class DataProvider {

    private List<PersonModel> personModelList;

    public List<PersonModel> getPersonListData() {
        personModelList = new ArrayList<>();

        PersonModel personModel = new PersonModel();
        personModel.setFirstName("Bill");
        personModel.setLastName("Gates");
        personModel.setBirthday("January 1, 1985");
        personModel.setEmailAddress("bg@gmail.com");
        personModel.setMobile("09911223344");
        personModel.setAddress("Makati City");
        personModel.setContactPerson("Steve Jobs");
        personModel.setContactPersonMobile("09988776655");
        personModelList.add(personModel);

        personModel = new PersonModel();
        personModel.setFirstName("Steve");
        personModel.setLastName("Jobs");
        personModel.setBirthday("December 30, 1975");
        personModel.setEmailAddress("sj@gmail.com");
        personModel.setMobile("09988776655");
        personModel.setAddress("Quezon City");
        personModel.setContactPerson("Bill Gates");
        personModel.setContactPersonMobile("09911223344");
        personModelList.add(personModel);

        personModel = new PersonModel();
        personModel.setFirstName("Elton");
        personModel.setLastName("John");
        personModel.setBirthday("March 15, 1964");
        personModel.setEmailAddress("sj@gmail.com");
        personModel.setMobile("09988776655");
        personModel.setAddress("QuezonCity");
        personModel.setContactPerson("Bill Gates");
        personModel.setContactPersonMobile("09911223344");
        personModelList.add(personModel);

        personModel = new PersonModel();
        personModel.setFirstName("Manny");
        personModel.setLastName("Pacquio");
        personModel.setBirthday("February 20, 1865");
        personModel.setEmailAddress("mp@gmail.com");
        personModel.setMobile("09911223344");
        personModel.setAddress("Makati City");
        personModel.setContactPerson("Steve Jobs");
        personModel.setContactPersonMobile("09988776655");
        personModelList.add(personModel);

        personModel = new PersonModel();
        personModel.setFirstName("Jose");
        personModel.setLastName("Rizal");
        personModel.setBirthday("May 20, 1895");
        personModel.setEmailAddress("jr@gmail.com");
        personModel.setMobile("09911223344");
        personModel.setAddress("Makati City");
        personModel.setContactPerson("Steve Jobs");
        personModel.setContactPersonMobile("09988776655");
        personModelList.add(personModel);

        return personModelList;
    }
}
