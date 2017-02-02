package com.manardenza;

import com.manardenza.utils.DatabaseSeeder;
import com.manardenza.utils.Injector;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    static org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {
        DatabaseSeeder.seedDatabase();
        //test
        System.out.println("Hello world!");
        Injector.getConsoleMain().consoleMain();
    }

    public int test() {
        return 1;
    }
}
