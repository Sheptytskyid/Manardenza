package com.manardenza.console;

import com.manardenza.controller.HotelController;
import com.manardenza.controller.ReservationController;
import com.manardenza.controller.UserController;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.manardenza.console.VisualUserMenu.inputDataFromUser;
import static com.manardenza.console.VisualUserMenu.outputDataInConsole;
import static com.manardenza.console.VisualUserMenu.outputSplitLine;
import static com.manardenza.console.VisualUserMenu.readerMenuFromConsole;
import static com.manardenza.console.VisualUserMenu.showUserMenu;

public class ContentsUserMenu {

    private HotelController hotelController;
    private ReservationController reservationController;
    private UserController userController;

    public ContentsUserMenu(HotelController hotelController,
                            ReservationController reservationController, UserController userController) {
        this.hotelController = hotelController;
        this.reservationController = reservationController;
        this.userController = userController;
    }

    public void mainMenu() throws IOException {
        outputSplitLine();
        outputDataInConsole("\t\tWelcome to manardenza.com");
        outputSplitLine();
        outputDataInConsole("\n\tAuthorization");
        showUserMenu("Main menu");
        int actionMain = readerMenuFromConsole("Choose action: ");
        switch (actionMain) {
            case (1):
                registrationUserMenu();
                break;
            case (2):
                outputDataInConsole("\tBuy!");
                System.exit(0);
                break;
            default:
                outputDataInConsole("Incorrect menu item");
                mainMenu();
                break;
        }
    }

    public void serviceMenu() throws IOException {
        boolean flagMenu = true;
        while (flagMenu) {
            outputSplitLine();
            outputDataInConsole("\n\tService menu");
            showUserMenu("Service menu");
            int actionService = readerMenuFromConsole("Choose action: ");
            switch (actionService) {
                case (1):
                    outputSplitLine();
                    outputDataInConsole("For find hotel by name complete the following form");
                    findHotelByNameMenu();
                    outputSplitLine();
                    break;
                case (2):
                    outputSplitLine();
                    outputDataInConsole("For find hotel by city complete the following form");
                    outputDataInConsole(findHotelByCityMenu().toString());
                    outputSplitLine();
                    break;
                case (3):
                    outputSplitLine();
                    outputDataInConsole("To find the room fill in the following form");
                    findRoomMenu();
                    outputSplitLine();
                    break;
                case (4):
                    outputSplitLine();
                    outputDataInConsole("Your reserved rooms: ");
                    getAllUserReservationsMenu();
                    break;
                case (5):
                    outputSplitLine();
                    outputDataInConsole("To cancel a reservation of the room, fill in the following form");
                    cancelReservationMenu();
                    outputSplitLine();
                    break;
                case (6):
                    outputSplitLine();
                    outputDataInConsole("\tThank you for using our service.");
                    outputSplitLine();
                    flagMenu = false;
                    logoutUserMenu();
                    continue;
                default:
                    outputDataInConsole("Incorrect menu item");
                    serviceMenu();
                    continue;
            }
        }
    }

    private void registrationUserMenu() {
        String firstName = null;
        String lastName = null;
        outputSplitLine();
        try {
            firstName = String.valueOf(inputDataFromUser("Enter name: ", false,
                    false, true, false));
            lastName = String.valueOf(inputDataFromUser("Enter last name: ", false,
                    false, true, false));
            userController.loginUser(firstName, lastName);
        } catch (IOException e) {
            outputDataInConsole("Is invalid user data");
        }
        outputDataInConsole(firstName + ", You have successfully logged in!\n\n\t Welcome to our site!\n");
    }

    private void logoutUserMenu() throws IOException {
        userController.logoutUser();
        mainMenu();
    }

    private List<Hotel> findHotelByNameMenu() {
        String hotelName = null;
        try {
            hotelName = String.valueOf(inputDataFromUser("Enter hotel name: ", false,
                    false, true, false));
        } catch (IOException e) {
            outputDataInConsole("Entered incorrect name of the hotel");
        }
        outputDataInConsole("The list of found hotels by name: " + hotelName);
        outputSplitLine();
        List<Hotel> hotelList = hotelController.findHotelByName(hotelName);
        hotelList.forEach(item -> outputDataInConsole(item.toString()));
        return hotelList;
    }

    private List<Hotel> findHotelByCityMenu() {
        String cityName = null;
        try {
            cityName = String.valueOf(inputDataFromUser("Enter city name: ", false,
                    false, true, false));
        } catch (IOException e) {
            outputDataInConsole("Entered incorrect name of the city");
        }
        outputDataInConsole("List of hotels in the city found : " + cityName);
        List<Hotel> hotelList = hotelController.findHotelByCity(cityName);
        hotelList.forEach(item -> outputDataInConsole(item.toString()));
        return hotelList;
    }

    private Map<String, List<Room>> findRoomMenu() throws IOException {
        String city = null;
        Integer person = null;
        Integer price = null;
        Date reservedFrom = null;
        Date reservedTo = null;
        try {
            city = String.valueOf(inputDataFromUser("Enter city name: ", false,
                    false, true, false));
            person = (Integer) inputDataFromUser("Enter the number of persons: ", true,
                    false, false, false);
            price = (Integer) inputDataFromUser("Enter maximum price rate: ", true,
                    false, false, false);
            reservedFrom = (Date) (inputDataFromUser("Enter arrival date in the format dd.mm.yyyy: ",
                    false, false, false, true));
            reservedTo = (Date) (inputDataFromUser("Enter the departure date in the format dd.mm.yyyy: ",
                    false, false, false, true));
            compareDate(reservedFrom, reservedTo);
        } catch (IOException e) {
            outputDataInConsole("Enter arrival date in the format");
        }
        Map<String, List<Room>> foundRooms = hotelController.getAvailableRooms(city, person, price,
                reservedFrom, reservedTo);
        if (foundRooms.values().isEmpty()) {
            outputDataInConsole("Room with such parameters not found");
        } else {
            outputDataInConsole("The list of found rooms:\n ");
            foundRooms.forEach((hotel, rooms) -> rooms.forEach(room -> outputDataInConsole(hotel + room.toString())));
        }
        outputDataInConsole("For room reservation please fill out the following form");
        bookRoomMenu();
        outputSplitLine();
        return foundRooms;
    }

    private Long bookRoomMenu() throws IOException {
        Long reserveId = 0L;
        boolean bookFlaf = true;
        while (bookFlaf) {
            outputDataInConsole("Do you have booking room?");
            showUserMenu("Booking menu");
            Integer bookRoom = (Integer) inputDataFromUser("Enter number: ", true,
                    false, false, false);
            Integer numberRoom = null;
            switch (bookRoom) {
                case (1):
                    try {
                        numberRoom = (Integer) inputDataFromUser("Enter the room number: ", true,
                                false, false, false);
                    } catch (IOException e) {
                        outputDataInConsole("Entered incorrect number room");
                    }
                    /*reserveId = reservationController.bookRoom(numberRoom);*/
                    outputDataInConsole("Guest room " + reserveId.intValue() + " reserved!");
                    outputSplitLine();
                    break;
                case (2):
                    serviceMenu();
                    bookFlaf = false;
                    break;
                default:
                    bookFlaf = false;
            }
        }
        return reserveId;
    }

    private List<Reservation> getAllUserReservationsMenu() {
        outputSplitLine();
        List<Reservation> reservList = reservationController.getAllUserReservations();
        reservList.forEach(item -> outputDataInConsole(item.toString()));
        return reservList;
    }

    private void cancelReservationMenu() {
        Long idReservation = 0L;

        try {
            idReservation = (Long) inputDataFromUser("Enter your reservation number: ", false,
                    true, false, false);
            boolean reservId = reservationController.cancelReservation(idReservation);
            if (reservId) {
                outputDataInConsole("Reserve a room removed!");
                outputSplitLine();
            } else {
                outputDataInConsole("Entered incorrect number reservation!");
                cancelReservationMenu();
            }
        } catch (IOException e) {
            outputDataInConsole("Room reservations missing");
        }
    }

    private void compareDate(Date dateFrom, Date dateTo) throws IOException {
        boolean compareDate = true;
        while (compareDate) {
            if (dateFrom.compareTo(dateTo) <= 0) {
                compareDate = false;
            } else {
                outputDataInConsole("Room reserved at least a day!");
                dateTo = (Date) (inputDataFromUser("Enter arrival date in the format dd.mm.yyyy: ",
                        false, false, false, true));
            }
        }
    }
}
