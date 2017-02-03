package com.manardenza.console;

import com.manardenza.controller.HotelController;
import com.manardenza.controller.ReservationController;
import com.manardenza.controller.UserController;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.manardenza.console.ListMenu.getAuthorizationHeader;
import static com.manardenza.console.ListMenu.getAuthorizationMenu;
import static com.manardenza.console.ListMenu.getBookingHeader;
import static com.manardenza.console.ListMenu.getBookingMenu;
import static com.manardenza.console.ListMenu.getServiceHeader;
import static com.manardenza.console.ListMenu.getServiceMenu;
import static com.manardenza.console.ListMenu.getSiteHeader;
import static com.manardenza.console.VisualUserMenu.outputSplitLine;
import static com.manardenza.console.VisualUserMenu.printListInConsole;
import static com.manardenza.console.VisualUserMenu.printMapInConsole;


public class ContentsUserMenu {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(ContentsUserMenu.class);


    private HotelController hotelController;
    private ReservationController reservationController;
    private UserController userController;
    private VisualUserMenu visualUserMenu;

    public ContentsUserMenu(HotelController hotelController,
                            ReservationController reservationController, UserController userController,
                            VisualUserMenu visualUserMenu) {
        this.hotelController = hotelController;
        this.reservationController = reservationController;
        this.userController = userController;
        this.visualUserMenu = visualUserMenu;
    }

    public void mainMenu() {
        printListInConsole(getSiteHeader(), null);
        printListInConsole(getAuthorizationHeader(), getAuthorizationMenu());
        Integer action;
        do {
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case (1):
                    registrationUserMenu();
                    break;
                case (2):
                    System.out.println("\tBye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect menu item selected!\n");
                    break;
            }
        } while (!visualUserMenu.validateIntegerSize(getAuthorizationMenu().size(), action));
    }

    private void registrationUserMenu() {
        String firstName = visualUserMenu.getValidInputFromUser("Enter your first name: ", InputType.STRING);
        String lastName = visualUserMenu.getValidInputFromUser("Enter your last name: ", InputType.STRING);
        userController.loginUser(firstName, lastName);
        System.out.println(firstName + ", You have successfully logged in!\n\n\t Welcome to our site!\n");
    }

    public void serviceMenu() {
        while (true) {
            printListInConsole(getServiceHeader(), getServiceMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case (1):
                    outputSplitLine();
                    findHotelByNameMenu();
                    break;
                case (2):
                    outputSplitLine();
                    printListInConsole(null, findHotelByCityMenu());
                    break;
                case (3):
                    outputSplitLine();
                    findRoomMenu();
                    break;
                case (4):
                    outputSplitLine();
                    getAllUserReservationsMenu();
                    break;
                case (5):
                    outputSplitLine();
                    break;
                case (6):
                    outputSplitLine();
                    userController.logoutUser();
                    return;
                case (7):
                    outputSplitLine();
                    System.out.println("\tThank you for using our service.");
                    System.exit(0);
                default:
                    outputSplitLine();
                    System.out.println("Incorrect menu item selected");

            }
        }
    }

    private List<Hotel> findHotelByNameMenu() {
        while (true) {
            String hotelName = visualUserMenu.getValidInputFromUser("Enter hotel name (enter \"0\" to return back to " +
                "menu): ", InputType
                .STRING);
            if (hotelName.equals("0")) {
                return null;
            }
            outputSplitLine();
            List<Hotel> hotelList = hotelController.findHotelByName(hotelName);
            if (hotelList.isEmpty()) {
                System.out.println("Hotel " + hotelName + " not found.");
            } else {
                System.out.println("The list of found hotels by name: " + hotelName);
                printListInConsole(null, hotelList);
            }
            return hotelList;
        }
    }

    private List<Hotel> findHotelByCityMenu() {
        while (true) {
            String city = visualUserMenu.getValidInputFromUser("Enter city (enter \"0\" to return back to menu): ",
                InputType
                    .STRING);
            if (city.equals("0")) {
                return null;
            }
            outputSplitLine();
            List<Hotel> hotelList = hotelController.findHotelByCity(city);
            if (hotelList.isEmpty()) {
                System.out.println("Hotel in " + city + " not found.");
            } else {
                System.out.println("The list of found hotels in: " + city);
                printListInConsole(null, hotelList);
            }
            return hotelList;
        }
    }

    private Map<String, List<Room>> findRoomMenu() {
        String city = visualUserMenu.getValidInputFromUser("Enter city: ", InputType.STRING);
        Integer persons = Integer.parseInt(visualUserMenu.getValidInputFromUser("Enter the number of persons: ",
            InputType.INTEGER));
        Integer price = Integer.parseInt(visualUserMenu.getValidInputFromUser("Enter maximum price rate: ", InputType
            .INTEGER));
        String reservedFrom = visualUserMenu.getValidInputFromUser("Enter arrival date in the format dd.mm.yyyy: ",
            InputType.DATE);
        String reservedTo = visualUserMenu.getValidInputFromUser("Enter the departure date in the format dd.mm.yyyy: " +
            "", InputType.DATE);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date arrival = new Date(0, 0, 0);
        Date departure = new Date(0, 0, 1);
        try {
            arrival = df.parse(reservedFrom);
            departure = df.parse(reservedTo);
        } catch (ParseException e) {
            log.error("Error parsing input date to Date format", e);
        }
        Map<String, List<Room>> foundRooms = hotelController.getAvailableRooms(city, persons, price, arrival,
            departure);
        if (foundRooms.values().isEmpty()) {
            System.out.println("Room with such parameters not found");
        } else {
            System.out.println("The list of found rooms:\n ");
            printMapInConsole(foundRooms);
            outputSplitLine();
            bookRoomMenu(arrival, departure, foundRooms);
        }
        return foundRooms;
    }

    private void bookRoomMenu(Date reservedFrom, Date reservedTo, Map<String, List<Room>> foundRooms) {
        List<String> foundHotelNames = new ArrayList<>();
        foundRooms.forEach((key, value) -> foundHotelNames.add(key));
        long reserveId = 0L;
        System.out.println("Do you want to make a reservation?");
        printListInConsole(getBookingHeader(), getBookingMenu());
        Integer action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Enter number: ", InputType
            .INTEGER));
        switch (action) {
            case (1):
                Integer hotelIndex = Integer.parseInt(visualUserMenu.getValidInputFromUser("Enter number: ",
                    InputType.INTEGER)) - 1;

                Integer roomIndex = Integer.parseInt(visualUserMenu.getValidInputFromUser("Enter number: ",
                    InputType.INTEGER)) - 1;
                String selectedHotelName = foundHotelNames.get(hotelIndex);
                Hotel selectedHotel = hotelController.findHotelByName(selectedHotelName).get(0);
                Room selectedRoom = foundRooms.get(selectedHotelName).get(roomIndex);
                reserveId = reservationController.bookRoom(reservedFrom,
                    reservedTo, selectedRoom, selectedHotel);

                System.out.println("Room reserved successfully!\n You reservation ID: " + reserveId);
                outputSplitLine();
                break;
            default:
                return;
        }
    }

    private void getAllUserReservationsMenu() {
        outputSplitLine();
        List<Reservation> reservations = reservationController.getAllUserReservations();
        printListInConsole(null, reservations);
        cancelReservationMenu(reservations);
    }

    private void cancelReservationMenu(List<Reservation> reservations) {
        Integer reservationIndex;
        do {
            reservationIndex = Integer.parseInt(visualUserMenu.getValidInputFromUser("Enter your reservation number " +
                "(enter " +
                "\"0\" to return back to menu): ", InputType
                .INTEGER));
            if (reservationIndex.equals("0")) {
                return;
            }
        } while (!visualUserMenu.validateIntegerSize(reservations.size(), reservationIndex));
        reservationController.cancelReservation(reservations.get(reservationIndex - 1).getId());
        System.out.println("Reservation successfully cancelled");
    }
}
