package org.example;

import org.example.model.Data;
import org.example.service.DataService;
import org.example.utils.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        DataService dataService = new DataService();

        int option = 1;
        while (option != 7) {
            menu.printMainMenu();
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 : dataService.addData(); break;
                    case 2 : dataService.getDataByAccount(); break;
                    case 3 : dataService.getDataByName(); break;
                    case 4 : dataService.getDataByValue(); break;
                    case 5 : dataService.deleteDataByAccount(); break;
                    case 6 : dataService.updateData(); break;
                    case 7 : exit(0);
                }
            } catch (InputMismatchException ex){
                System.out.println("Please enter value between 1 and 7");
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }
}