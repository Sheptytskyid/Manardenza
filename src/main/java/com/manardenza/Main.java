package com.manardenza;

import com.manardenza.utils.DatabaseSeeder;
import com.manardenza.utils.Injector;
import org.slf4j.LoggerFactory;

public class Main {

    static org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DatabaseSeeder.seedDatabase();
        Injector.getUserController().loginUser("Denys", "Sheptytskyi");
        System.out.println("Hello world!");
    }

    public int test() {
        return 1;
    }
}
