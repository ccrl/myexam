package com.sample.projects.myexam.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Chyron-MACBOOK on 10/10/18.
 */

public class PersonModel {

    @Expose()
    private String firstName;
    @Expose()
    private String lastName;
    @Expose()
    private String birthday;
    @Expose()
    private String age;
    @Expose()
    private String emailAddress;
    @Expose()
    private String mobile;
    @Expose()
    private String address;
    @Expose()
    private String contactPerson;
    @Expose()
    private String contactPersonMobile;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPersonMobile() {
        return contactPersonMobile;
    }

    public void setContactPersonMobile(String contactPersonMobile) {
        this.contactPersonMobile = contactPersonMobile;
    }
}
