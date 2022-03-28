package uz.pdp.service;

import uz.pdp.chek.Chek;
import uz.pdp.db.Db;
import uz.pdp.models.Car;
import uz.pdp.models.OilMark;
import uz.pdp.models.PaymenType;

import static uz.pdp.db.CarDb.cars;
import static uz.pdp.db.OilDb.oilMarks;
import static uz.pdp.db.PayDb.paymenTypes;
import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Input.getNum;
import static uz.pdp.utils.Input.getStr;
import static uz.pdp.utils.Print.print;
import static uz.pdp.utils.Print.println;

public class OilMarkService {

    public static void creatOil() {
        println(BLUE, "Benzin");
        print(GREEN, "Benzin marka : ");
        String marka = getStr();
        print(GREEN, "Benzin narxi : ");
        int narx = getNum();
        if (!Chek.cheOil(marka, narx)) {
            OilMark oilMark = new OilMark(marka, narx);
            oilMarks.add(oilMark);
        } else {
            println(RED, "Bunday benzin bor ");
        }
    }

    public static void oilread() {
        if (Chek.chekOilMark()) {
            for (OilMark oilMark : oilMarks) {
                println(YELLOW, "|----------------------------------------------------------------------|");
                println(GREEN, " markasi " + oilMark.getMarka() + "  narxi -> " + oilMark.getNarxi());
                println(YELLOW, "|----------------------------------------------------------------------|");
            }

        } else {
            println(RED, "Benzin yo'q");
        }
    }


    public static void oilDelet() {
        oilread();
        if (Chek.chekOilMark()){
            print(GREEN, "Benzin marka : ");
            String marka = getStr();
            oilMarks.removeIf(oilMark -> oilMark.getMarka().equals(marka));
            println(YELLOW,"vazifa bajarildi");
        }
    }

    public static void oilMenu() {
     oilread();
     String marka = getStr("Marka : ");
        for (OilMark oilMark : oilMarks) {
            if (oilMark.getMarka().equalsIgnoreCase(marka)){
                payOil(oilMark);
            }

        }

    }

    private static void payOil(OilMark oilMark) {
    PaymentTypeService.readPaymentType();
    String payName= getStr("To'lov turi : ");
        for (PaymenType paymenType : paymenTypes) {
            if (paymenType.getName().equalsIgnoreCase(payName)){
                payTypes(oilMark,paymenType);
            }
        }
    }

    private static void payTypes(OilMark oilMark, PaymenType paymenType) {
        payMenu();
        String choice = getStr("");
        switch (choice){
            case "1"-> polniBak(oilMark,paymenType);
            case "2"-> pulgaYarasha(oilMark,paymenType);

            case "4"->{return;}
            default -> println(RED,"Bunday tanlov yo'q");
        }
    }

    private static void pulgaYarasha(OilMark oilMark, PaymenType paymenType) {
        for (Car car : cars) {
            if (Db.getSessionUser().getId().equalsIgnoreCase(car.getId())){
                int res=(car.getBakSigimi()- car.getBakdaBenzinMiqdori());
                int sum=(oilMark.getNarxi()*res);
                if (sum>paymenType.getMiqdori()){
                    car.setBakdaBenzinMiqdori(res);
                    paymenType.setMiqdori((sum-paymenType.getMiqdori()));
                    println(YELLOW,"Bak to'ldirildi ");
                }else if ( oilMark.getNarxi() > paymenType.getMiqdori()){
                    println(RED,"Pulingiz yetarli mas");
                }
                else {
                    int res1 = (paymenType.getMiqdori()/oilMark.getNarxi());
                    int sum1 = (paymenType.getMiqdori()%oilMark.getNarxi());
                    car.setBakdaBenzinMiqdori(res1);
                    paymenType.setMiqdori(sum1);
                    println(YELLOW,"Bakga pulingizga yarasha  : " + res1 + " l benzin quyildi");
                }
            }
        }
    }

    private static void polniBak(OilMark oilMark, PaymenType paymenType) {
        for (Car car : cars) {
            if (Db.getSessionUser().getId().equalsIgnoreCase(car.getId())){
                int res=(car.getBakSigimi()- car.getBakdaBenzinMiqdori());
                int sum=(oilMark.getNarxi()*res);
                if (sum>paymenType.getMiqdori()){
                    car.setBakdaBenzinMiqdori(res);
                    paymenType.setMiqdori((sum-paymenType.getMiqdori()));
                    println(YELLOW,"Bak to'ldirildi ");
                }else if ( oilMark.getNarxi() > paymenType.getMiqdori()){
                    println(RED,"Pulingiz yetarli mas");
                }

            }
        }
    }

    private static void payMenu() {
        println(YELLOW,"Polni bak -> 1");
        println(YELLOW,"Pulga yarasha -> 2");
        println(YELLOW,"necha litr -> 3");
        println(YELLOW,"quit -> 4");

    }
}
