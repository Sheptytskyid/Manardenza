package com.manardenza;

import com.manardenza.utils.DatabaseSeeder;
import com.manardenza.utils.Injector;
import lombok.Getter;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);
    @Getter
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        DatabaseSeeder.seedDatabase();
        Injector.getConsoleMain().consoleMain();
        reader.close();
    }
}
