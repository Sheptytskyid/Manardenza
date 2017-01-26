package com.manardenza.console;

public class ConsoleMain {

    private static ConsoleMain instance;

    private ConsoleMain() {
    }

    public static ConsoleMain getInstance() {
        if (instance == null) {
            instance = new ConsoleMain();
        }
        return instance;
    }
}
