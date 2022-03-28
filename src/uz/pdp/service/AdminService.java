package uz.pdp.service;

import uz.pdp.chek.Chek;
import uz.pdp.models.Car;

import static uz.pdp.db.CarDb.cars;
import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Input.getNum;
import static uz.pdp.utils.Input.getStr;
import static uz.pdp.utils.Print.print;
import static uz.pdp.utils.Print.println;

public class AdminService {

    public static void creatCar() {
        print(GREEN, "Car modeli");
        String modeli = getStr(" : ");
        print(GREEN, "Car brand");
        String brand = getStr(" : ");
        print(GREEN, "Car yurgan Masofasi");
        String yurganMasofasi = getStr(" : ");
        print(GREEN, "Bakda benzin miqdori :");
        int bakdaBenzinMiqdori = getNum(" : ");
        print(GREEN, "Car  bak sig'imi");
        int bakSigimi = getNum(" : ");
        print(GREEN, "Car yoqilg'i Sarfi har 100km ga ");
        int yoqilgiSarfi = getNum(" : ");
        print(GREEN, "Car nomeri ");
        String carNumber = getStr(" : ");
       if (!Chek.chekCars(modeli,brand,carNumber)){
        Car car = new Car(modeli,brand,yurganMasofasi,bakSigimi,yoqilgiSarfi,yoqilgiSarfi,carNumber);
        cars.add(car);
        }else {
           println(RED,"Bunday car bor ");
       }
        }

    public static void readCar() {
        if (Chek.chekCar()){
        for (Car car : cars) {
            println(YELLOW,"|----------------------------------------------------------------------|");
            println(BLUE,car.getBrand()+ " " + car.getModeli() + " \n" + " Yurgan masofasi -> "+car.getYurganMasofasi() +" : km  \n"+ "Bakda Benzin Miqdori "+car.getBakdaBenzinMiqdori()+"l  \n car bak sig'imi "+car.getBakSigimi() + " : l \n" + "yoqilg'i sarfi -> " + car.getYoqilgiSarfi() + " l \n" + " Nomeri -> " + car.getCarNomer() );
            println(YELLOW,"|----------------------------------------------------------------------|");
        }
        }else {
            println(RED,"Xali mashinalar yoq");
        }

    }

    public static void carUbdate() {
        readCar();
        if (Chek.chekCar()) {
            print(GREEN, "car model");
            String name = getStr();
            print(GREEN,"car Numer");
            String carNumber = getStr();
           chekcarUbdate(name,carNumber);
        }

    }

    private static void chekcarUbdate(String name, String carNumber) {
        boolean a=false;
        for (Car car : cars) {
            if (car.getCarNomer().equals(carNumber) && car.getModeli().equals(name));
            a=true;
            ubdate(car);
        }
        if (!a){
            println(RED,"Bunday mashina yo'q");
        }
    }

    private static void ubdate(Car car) {
        print(GREEN, "Car modeli");
        String modeli = getStr("");
        cars.remove(car.getModeli());
        car.setModeli(modeli);
        print(GREEN, "Car brand");
        String brand = getStr("");
        cars.remove(car.getBrand());
        car.setBrand(brand);
        print(GREEN, "Car yurgan Masofasi");
        String yurganMasofasi = getStr("");
        cars.remove(car.getYurganMasofasi());
        car.setYurganMasofasi(yurganMasofasi);
        print(GREEN, "Car  bak sig'imi");
        int bakSigimi = getNum("");
        cars.remove(car.getBakSigimi());
        car.setBakSigimi(bakSigimi);
        print(GREEN, "Car yoqilg'i Sarfi har 100km ga ");
        int yoqilgiSarfi = getNum("");
        cars.remove(car.getYoqilgiSarfi());
        car.setYoqilgiSarfi(yoqilgiSarfi);
        print(GREEN, "Car nomeri ");
        String carNumber = getStr("");
        cars.remove(car.getCarNomer());
        car.setCarNomer(carNumber);
    }

    public static void carDelete() {
        readCar();
        if (Chek.chekCar()) {
            print(GREEN, "car model");
            String name = getStr();
            print(GREEN,"car Numer");
            String carNumber = getStr();
            cars.removeIf(car -> car.getModeli().equals(name) && car.getCarNomer().equals(carNumber));
            println(YELLOW,"car uchirildi");
        }

    }
}
