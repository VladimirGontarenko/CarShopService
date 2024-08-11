package org.example;

import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.RoleUser;
import org.example.in.CarIn;
import org.example.in.OrderIn;
import org.example.in.PersonIn;
import org.example.out.CarOut;
import org.example.out.OrderOut;
import org.example.out.PersonOut;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
