package com.example.AagamShah.myapplication.backend;


import com.example.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    public String getData() {
        return new Joker().getJoke();
    }

}