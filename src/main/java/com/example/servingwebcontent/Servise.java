package com.example.servingwebcontent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Servise {
    List<String> cities = new ArrayList<String>();

    public void readFile() {
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\Yura\\game_cities\\src\\main\\resources\\cities.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            String mycity = scan.nextLine();
            System.out.println(mycity);
            cities.add(mycity);
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String comperCityEnd(String customerCity) {
        Iterator iterator = cities.iterator();
        while (iterator.hasNext()) {
            String newCiti = iterator.next().toString().toLowerCase();
            if (customerCity.charAt(customerCity.length() - 1) == newCiti.charAt(0))
                return newCiti;
        }
        return "I do not know any city";
    }

    public boolean checkCustomerResponse(String customerCity, String lastCity) {
        customerCity.toLowerCase();
        return lastCity.charAt(lastCity.length() - 1) == customerCity.charAt(0);
    }
}
