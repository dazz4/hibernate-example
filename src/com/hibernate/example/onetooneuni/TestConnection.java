package com.hibernate.example.onetooneuni;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestConnection {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "admin";
        String password = "admin";

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println(myConn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
