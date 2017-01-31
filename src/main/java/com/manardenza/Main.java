package com.manardenza;

import com.manardenza.utils.Injector;
import org.slf4j.LoggerFactory;

public class Main {

    static org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Injector injector = new Injector();
    }

    public int test() {
        return 1;
    }
}
