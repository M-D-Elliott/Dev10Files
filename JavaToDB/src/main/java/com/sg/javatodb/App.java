package com.sg.javatodb;

import DBConnection.DbConnector;

public class App {
    public static void main(String[] args) {
        new DbConnector().run();
    }
}
