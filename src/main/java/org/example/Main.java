package org.example;

import org.example.db.DataBase;

public class Main {
    public static void main(String[] args) {
        try {
            DataBase main = new DataBase();
            main.start();
            Authorization authorization = new Authorization();
            authorization.authorization();
        } catch (
                SQLException e) {
            System.out.println("SQL error что-то там" + e.getMessage());
            e.printStackTrace();
        }
    }

}
