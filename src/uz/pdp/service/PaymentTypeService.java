package uz.pdp.service;

import uz.pdp.models.PaymenType;

import java.util.Objects;

import static uz.pdp.db.OilDb.oilMarks;
import static uz.pdp.db.PayDb.paymenTypes;
import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Input.getNum;
import static uz.pdp.utils.Input.getStr;
import static uz.pdp.utils.Print.print;
import static uz.pdp.utils.Print.println;

public class PaymentTypeService {
    static boolean a=false;
    public static void creatPaymentType() {
        print(GREEN,"Payment type");
        String type = getStr();
        PaymenType paymenType = new PaymenType(type);
        paymenTypes.add(paymenType);

    }

    public static void readPaymentType() {
        for (PaymenType paymenType : paymenTypes) {
            if (Objects.nonNull(paymenType)){
                println(BLUE,paymenType.getName() + " summa : "+paymenType.getMiqdori() + " so'm");
                a=true;
            }
        }
        if (!a){
            println(RED,"tayplar mavjud emas ");
        }
    }

    public static void deletPaymentType() {
        readPaymentType();
        if (a) {
            print(GREEN, "Payment type");
            String type = getStr();
            oilMarks.removeIf(oilMark -> oilMark.getMarka().equals(type));
            println(YELLOW, "vazifa bajarildi ");
        }
    }

    public static void addBalanse() {
        readPaymentType();
        String name = getStr("To'lov turini tanlang ");
        for (PaymenType paymenType : paymenTypes) {
            if (paymenType.getName().equalsIgnoreCase(name)){
                int summa =getNum("Summani kiriting : ");
                paymenType.setMiqdori(summa);

            }
        }
    }
}
