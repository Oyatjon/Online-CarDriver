package uz.pdp.chek;

import uz.pdp.db.CarDb;
import uz.pdp.db.Db;
import uz.pdp.models.Car;
import uz.pdp.models.OilMark;
import uz.pdp.models.User;

import java.util.Objects;

import static uz.pdp.db.CarDb.cars;
import static uz.pdp.db.Db.users;
import static uz.pdp.db.OilDb.oilMarks;
import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Print.println;

public class Chek {
    public static boolean chekUser(String userName, String password) {
        for (User user : users) {
            if (Objects.nonNull(user) && user.getUserName().equals(userName) && user.getPassword().equals(password)) ;
            return true;
        }
        return false;
    }

    public static boolean chekCar() {
        for (Car car : cars) {
            if (Objects.nonNull(car))
                return true;
        }
        return false;
    }

    public static boolean chekCars(String modeli, String brand, String carNumber) {
        for (Car car : cars) {
            if (car.getBrand().equals(brand) && car.getModeli().equals(modeli) && car.getCarNomer().equals(carNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cheOil(String marka, int narx) {
        for (OilMark oilMark : oilMarks) {
            if (oilMark.getMarka().equals(marka) && oilMark.getNarxi() == narx) {
                return true;
            }

        }
        return false;
    }

    public static boolean chekOilMark() {
        for (OilMark oilMark : oilMarks) {
            if (Objects.nonNull(oilMark)) {
                return true;
            }

        }
        return false;
    }


    public static void chekTanlanganMashina() {
        boolean a=false;
        for (Car car : cars) {
            if (Db.getSessionUser().getId().equals(car.getId())) {
                println(BLUE, "Brandi : " + car.getBrand() + " ||  Modeli : " + car.getModeli() + " \n" +
                       "Yurgan masofasi : " + car.getYurganMasofasi()+" km"+" ||  Benzin Miqdori : "+ car.getBakdaBenzinMiqdori() + " l || " +
                        " Bak sig'imi : "+ car.getBakSigimi() + " l"+ "  || Benzin sarfi 100km uchun : "+car.getYoqilgiSarfi()+" l");
             a=true;
            }
        }
        if (!a){
            println(RED,"Hali mashina tanlangani yo'q");
        }
    }
    public static boolean chekCarDrive(){
        for (Car car : cars) {
            if (Db.getSessionUser().getId().equals(car.getId())){
                return true;
            }
        }
        return false;
    }
    public static Car returnCar(){
        for (Car car : cars) {
            if (Db.getSessionUser().getId().equals(car.getId())){
                return car;
            }
        }
        return null;
    }
}

