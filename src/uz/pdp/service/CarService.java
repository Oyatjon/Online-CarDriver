package uz.pdp.service;

import uz.pdp.chek.Chek;
import uz.pdp.db.CarDb;
import uz.pdp.db.Db;
import uz.pdp.models.Car;
import uz.pdp.models.User;

import java.util.Objects;

import static uz.pdp.db.CarDb.cars;
import static uz.pdp.service.AdminService.readCar;
import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Input.getStr;
import static uz.pdp.utils.Print.print;
import static uz.pdp.utils.Print.println;

public class CarService {
    public static void carTanlash() {
        readCar();
        if (Chek.chekCar()) {
            if (Db.getSessionUser().getMashinalari() == 0) {
                print(BLUE, "Mashinani tanlang :");
                String model = getStr();
                print(BLUE, "Mashinani nomerini tanlang :");
                String nomer = getStr();
                cartanlash1(model, nomer);


            } else {
                println(RED, "Sizda mashina bor ");
            }
        }
    }

    private static void cartanlash1(String model, String nomer) {
        boolean a = false;
        for (Car car : cars) {
            if (car.getModeli().equals(model) && car.getCarNomer().equals(nomer)) {
                car.setId(Db.getSessionUser().getId());
                Db.getSessionUser().setMashinalari(1);
                println(YELLOW, "Tanlov bajarildi ");
                a = true;
            }
        }
        if (!a) {
            println(RED, "Bunday Mashina topilmadi ");
        }
    }


    public static void carYoqish() {
        if (Chek.chekCarDrive()) {
            if (!Objects.requireNonNull(Chek.returnCar()).isYoniq()) {
                (Objects.requireNonNull(Chek.returnCar())).setYoniq(true);
                println(PURPLE, "Mashinangiz yondi ");
            }

        }else {
            println(RED," Mashina tanlanmagan");
        }

    }

    public static void carOff() {
        if (Chek.chekCarDrive()) {
            if (Objects.requireNonNull(Chek.returnCar()).isYoniq()) {
                (Chek.returnCar()).setYoniq(false);
                println(PURPLE, "Mashinangiz uchirildi ");
            }else {
                println(RED,"Mashinangiz uzi uchiq ");
            }

        }else {
            println(RED," Mashina tanlanmagan");
        }
    }

    public static void carDrive() {

    }
}
