package uz.pdp;

import uz.pdp.chek.Chek;
import uz.pdp.models.PaymenType;
import uz.pdp.service.AdminService;
import uz.pdp.service.CarService;
import uz.pdp.service.OilMarkService;
import uz.pdp.service.PaymentTypeService;

import java.util.Objects;

import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Input.getStr;
import static uz.pdp.utils.Print.print;
import static uz.pdp.utils.Print.println;

public class MenuApp {

    public static void menu(boolean admin) {
        if (admin) {
            menuAdmin();
            print(GREEN, " :? ");
            String choise = getStr("");
            if (choise.startsWith("q")) {
                return;
            }
            switchMenu(choise);
        } else {
            if (Chek.chekCar()) {
                menuHaydovchi();
                print(GREEN, " :? ");
                String choise = getStr("");
                if (choise.startsWith("q")) {
                    return;
                }
                switchMenu1(choise);
            } else {
                println(RED, "Mashina mavjud emas");
                return;
            }
        }
    }

    private static void switchMenu1(String choise) {
        switch (choise) {
            case "1" -> CarService.carTanlash();
            case "2" -> {
                CarService.carYoqish();
          //      carData();
            }
            case "3" -> CarService.carOff();
            case "4" -> CarService.carDrive();
            case "5" -> PaymentTypeService.addBalanse();
            case "6" -> OilMarkService.oilMenu();
            default -> {
                println(RED, "Wrong choice");
            }
        }
        carData();
        menu(false);
    }

    private static void carData() {
        if (Chek.returnCar() != null && Chek.returnCar().isYoniq()) {
            Chek.chekTanlanganMashina();
        }
    }

    private static void menuHaydovchi() {
        println(YELLOW, "Car tanlash -> 1");
        println(YELLOW, "Car yoqish -> 2");
        println(YELLOW, "Car O'chirish -> 3");
        println(YELLOW, "Car Drive -> 4");
        println(YELLOW, "Add balance -> 5");
        println(YELLOW, "Benzin quyish -> 6");

    }


    private static void menuAdmin() {
        println(YELLOW, "CreatCar -> 1");
        println(YELLOW, "CarRead -> 2");
        println(YELLOW, "CarUbdate -> 3");
        println(YELLOW, "CarDelete -> 4");
        println(YELLOW, "CreatOilMark -> 5");
        println(YELLOW, "OilMarRead -> 6");
        println(YELLOW, "OilMarkUpdet -> 7");
        println(YELLOW, "OilMarkDelete -> 8");
        println(YELLOW, "CreatPaymentType -> 9");
        println(YELLOW, "PaymentType Read -> 10");
        println(YELLOW, "PaymentType Udate -> 11");
        println(YELLOW, "PaymentType Delete -> 12");
        println(GREEN, "quit -> q");
    }

    private static void switchMenu(String choise) {
        switch (choise) {
            case "1" -> AdminService.creatCar();
            case "2" -> AdminService.readCar();
            case "3" -> AdminService.carUbdate();
            case "4" -> AdminService.carDelete();
            //case "5" -> OilMarkService.creatOil();
            case "6" -> OilMarkService.oilread();
            case "7" -> OilMarkService.oilDelet();
            case "9" -> PaymentTypeService.creatPaymentType();
            case "10" -> PaymentTypeService.readPaymentType();
            //case "11" -> PaymentTypeService.ReadPaymentType();
            case "12" -> PaymentTypeService.deletPaymentType();
            default -> {
                println(RED, "Wrong choice");
            }
        }
        menu(true);
    }
}
