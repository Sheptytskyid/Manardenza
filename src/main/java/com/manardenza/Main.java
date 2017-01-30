package com.manardenza;

import com.manardenza.utils.DatabaseSeeder;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        DatabaseSeeder.seedDatabase();
    }

    public int test() {
        return 1;
    }
}
