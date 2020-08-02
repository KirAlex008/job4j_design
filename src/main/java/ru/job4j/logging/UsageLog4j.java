package ru.job4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        //String name = "Petr Arsentev";
        int age = 33;
        float wide = 22.22f;
        double speed = 22.22;
        byte bit = 1;
        char ch = 'a';
        short sh = 2;
        long lon = 333333;
        boolean b = true;

        LOG.debug("User info age : {}, wide {}, speed {}, bit {}, ch {}," +
                " sh {}, lon : {}, b: {}", age, wide, speed, bit, ch, sh, lon, b);
    }
}
