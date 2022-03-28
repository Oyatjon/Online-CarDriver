package uz.pdp.db;

import uz.pdp.models.User;

import java.util.ArrayList;

public class Db {
   public static ArrayList<User> users =new ArrayList<>();
    private static  User sessionUser = null;

    public static User getSessionUser() {
        return sessionUser;
    }

    public static void setSessionUser(User sessionUser) {
        Db.sessionUser = sessionUser;
    }

    public static void initUsers() {
        User user = new User();
        user.setUserName("tillo");
        user.setPassword("123");
        user.setAdmin(true);
        users.add(user);
    }
}
