package uz.pdp;


import uz.pdp.db.CarDb;
import uz.pdp.models.Car;

import static uz.pdp.db.Db.initUsers;
import static uz.pdp.service.UserService.login;
import static uz.pdp.service.UserService.registr;
import static uz.pdp.utils.Color.GREEN;
import static uz.pdp.utils.Color.RED;
import static uz.pdp.utils.Input.*;
import static uz.pdp.utils.Print.println;


public class App {
    public static void main(String[] args) {
        initUsers();
        CarDb.initCar();
        run();
    }

    private static void run() {
        menu();
        String choice = getStr(":? ");
        switch (choice) {
            case "1" -> login();
            case "2" -> registr();
            case "3" -> {
                exit();
                return;
            }
            default -> {
                println(RED, "Wrong choice");
            }
        }
        run();
    }

    private static void menu() {
        println(GREEN, "login -> 1");
        println(GREEN, "registr -> 2");
        println(GREEN, "exit -> 3");
    }


    private static void exit() {
        println(RED, "Ish tugatildi. ");
    }
}
