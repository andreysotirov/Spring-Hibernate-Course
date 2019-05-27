package com.luv2code.springdemo.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "admin";

        try {

            System.out.println("Connection to data base");

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection successful");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
