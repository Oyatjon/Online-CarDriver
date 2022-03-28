package uz.pdp.db;

import uz.pdp.models.Car;
import uz.pdp.models.OilMark;
import uz.pdp.models.PaymenType;
import uz.pdp.models.User;

import java.util.ArrayList;

import static uz.pdp.db.OilDb.oilMarks;
import static uz.pdp.db.PayDb.paymenTypes;

public class CarDb {
   public static ArrayList<Car> cars = new ArrayList<>();

   public static void initCar(){
      Car car =new Car("Nexia","Chevrolet","100",50,5,5,"sa");
      cars.add(car);
      PaymenType paymenType =new PaymenType("Cash");
      paymenTypes.add(paymenType);
      OilMark oilMark =new OilMark("AI-90",9000);
      oilMarks.add(oilMark);
   }
}
