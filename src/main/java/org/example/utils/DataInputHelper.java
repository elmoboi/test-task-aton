package org.example.utils;

import org.example.model.Data;

import java.util.Scanner;

public class DataInputHelper {
    public Data inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter account[long] : ");
        long account = scanner.nextLong();
        System.out.println("Enter name[String] : ");
        String name = scanner.next();
        System.out.println("Enter value[double] : ");
        double value = scanner.nextDouble();
        return new Data(account,name,value);
    }

    public Data updateData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter new account[long] : ");
        long account = scanner.nextLong();
        System.out.println("Enter new name[String] : ");
        String name = scanner.next();
        System.out.println("Enter new value[double] : ");
        double value = scanner.nextDouble();
        return new Data(account,name,value);
    }
}
