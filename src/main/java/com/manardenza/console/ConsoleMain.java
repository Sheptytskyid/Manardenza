package com.manardenza.console;

public class ConsoleMain {

    private static ConsoleMain instance;

    public static ConsoleMain getInstance() {
        if (instance == null) {
            instance = new ConsoleMain();
        }
        return instance;
    }
}
