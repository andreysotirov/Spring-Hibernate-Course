package com.andrewsotirov.daodemo;

import org.springframework.stereotype.Component;

@Component
public class MemebershipDAO {


    public void addMemeber() {
        System.out.println(getClass() + " addMember()");
    }

    public void goToSleep() {
        System.out.println(getClass() + " goToSleep()");
    }

}