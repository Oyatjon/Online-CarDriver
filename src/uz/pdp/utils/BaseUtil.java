package uz.pdp.utils;

import java.util.UUID;

public class BaseUtil {
    public static String generateUniqueID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String processMessage(String format, Object... args) {
        return String.format(format, args);
    }

    public static String getLetter(int i) {
        return Character.toString('A' + i);
    }
}
