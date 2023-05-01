package org.example.utils;

import org.example.model.Data;
import org.example.service.DataService;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    private final String[] optionsMainMenu = {
            "------------------",
            "1 - Put data(account[long], name[String], value[double])",
            "2 - Find data by account",
            "3 - Find data's by name",
            "4 - Find data's by value",
            "5 - Delete data by account",
            "6 - Update data by account",
            "7 - Exit",
    };
    public void printMainMenu() {
        for(String option : optionsMainMenu) {
            System.out.println(option);
        }
        System.out.println("Choose your option : ");
    }
}
