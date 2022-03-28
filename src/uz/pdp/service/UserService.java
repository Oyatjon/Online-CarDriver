package uz.pdp.service;

import uz.pdp.MenuApp;
import uz.pdp.chek.Chek;
import uz.pdp.db.Db;
import uz.pdp.models.User;

import static uz.pdp.db.Db.*;
import static uz.pdp.utils.Color.*;
import static uz.pdp.utils.Input.getStr;
import static uz.pdp.utils.Print.*;

public class UserService {


    public static void login() {
        print(GREEN, "UserName : ");
        String userName = getStr("");
        print(GREEN, "Password : ");
        String password = getStr("");
        boolean a = false;
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                a= true;
                Db.setSessionUser(user);
                MenuApp.menu(user.isAdmin());
            }
        }
        if (!a) {
            println(RED, "Bunday foydalanuvchi topilmadi ");
        }

    }

    public static void registr() {
        print(GREEN, "Name");
        String userName = getStr(" : ");
        print(GREEN, "Password");
        String password = getStr(" : ");
        if (Chek.chekUser(userName, password)) {
            User user = new User(userName, password);
            users.add(user);
            println(YELLOW," bajarildi ");
        } else {
            println(RED, "Bunday foydalanuvchi bor ");
        }


    }
}
