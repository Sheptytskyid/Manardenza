package com.manardenza.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisualUserMenu {

    public static void outputSplitLine() {
        String line = "****************************************";
        System.out.println(line);
    }

    public static void outputDataInConsole(String message) {
        System.out.println(message);
    }

    static void showUserMenu(String massage) {
        String[] mainMenu = new String[2];
        mainMenu[0] = "Login";
        mainMenu[1] = "Exit";

        String[] serviceMenu = new String[6];
        serviceMenu[0] = "Search hotel by name city";
        serviceMenu[1] = "Search by hotel name";
        serviceMenu[2] = "Search room";
        serviceMenu[3] = "Reservation order";
        serviceMenu[4] = "Cancel reservation";
        serviceMenu[5] = "Exit";

        String[] bookingMenu = new String[2];
        bookingMenu[0] = "Make a reservation";
        bookingMenu[1] = "No reserve";

        if (massage.equals("Main menu")) {
            sortMenuItems(mainMenu);
        }
        if (massage.equals("Service menu")) {
            sortMenuItems(serviceMenu);
        }
        if (massage.equals("Booking menu")) {
            sortMenuItems(bookingMenu);
        }

        System.out.println();
    }

    private static void sortMenuItems(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("%d. %s", i + 1, array[i]));
        }
    }

    static Integer readerMenuFromConsole(String action) throws IOException {
        boolean flag = true;
        int number = 0;
        outputDataInConsole(action);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            try {
                number = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException ex) {
                outputDataInConsole("Enter number: ");
                continue;
            }
            flag = false;
        }
        return number;
    }

    static Object inputDataFromUser(String message, boolean flagInt, boolean flagLong, boolean flagStr,
                             boolean flagDate) throws IOException {
        Integer number = 0;
        Long numLong = 0L;
        String answer = null;
        String date = null;
        Object data = null;
        outputDataInConsole(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flagI = flagInt;
        while (flagI) {
            try {
                number = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException ex) {
                outputDataInConsole("Enter number: ");
                continue;
            }
            data = number;
            flagI = false;
        }
        boolean flagL = flagLong;
        while (flagL) {
            try {
                numLong = Long.parseLong(reader.readLine());
            } catch (NumberFormatException ex) {
                outputDataInConsole("Enter number: ");
                continue;
            }
            data = numLong;
            flagL = false;
        }
        boolean flagS = flagStr;
        while (flagS) {
            answer = reader.readLine();
            if (answer == null) {
                continue;
            }
            data = answer;
            flagS = false;
        }
        boolean flagD = flagDate;
        while (flagD) {
            Date docDate = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            date = reader.readLine();
            if (isValidDate(date)) {
                try {
                    docDate = dateFormat.parse(date);
                } catch (ParseException e) {
                    outputDataInConsole("Is invalid date: ");
                }
                data = docDate;
            } else {
                outputDataInConsole("Incorrect date: ");
                continue;
            }
            flagD = false;
        }
        return data;
    }

    private static boolean isValidDate(String date) {
        int compDate;
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            if (dateFormat.format(dateFormat.parse(date)).equals(date)) {
                compDate = currentDate.compareTo(dateFormat.parse(date));
                return (compDate <= 0);
            }
        } catch (ParseException ex) {
            outputDataInConsole("Incorrect date: " + date + "\nEnter arrival date in the format dd.mm.yyyy:");
        }
        return false;
    }
}
