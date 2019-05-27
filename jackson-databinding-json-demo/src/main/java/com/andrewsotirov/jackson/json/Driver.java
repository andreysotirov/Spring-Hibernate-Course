package com.andrewsotirov.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Student student = objectMapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());

            Address address = student.getAddress();

            System.out.println("Street: " + address.getStreet());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
