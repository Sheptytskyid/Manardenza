package com.manardenza.controller;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;
import com.manardenza.login.CurrentUser;
import com.manardenza.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTest {
    @Mock
    private ReservationService reservationService;
    @Mock
    private CurrentUser currentUser;
    @InjectMocks
    private ReservationController reservationController;

    @Before
    public void setUp() {
        Mockito.when(currentUser.getUser()).thenReturn(new User("Test", "User"));
    }

    @Test
    public void checkIfControllerMethodBookRoomCorrectlyCallsTheCorrespondingServiceMethod() throws Exception {
        Date reservedFrom = new Date(117, 1, 1);
        Date reservedTo = new Date(117, 1, 5);
        Room room = new Room("Test", 2, 300);
        Hotel hotel = new Hotel("Test", "Kiev", new ArrayList<Room>());
        reservationController.bookRoom(reservedFrom,reservedTo, room, hotel);
        Mockito.verify(reservationService, Mockito.times(1)).bookRoom(reservedFrom,reservedTo, room, hotel);
    }

    @Test
    public void checkIfControllerMethodCancelReservationCorrectlyCallsTheCorrespondingServiceMethod() throws Exception {
        long id = 0;
        reservationController.cancelReservation(id);
        Mockito.verify(reservationService, Mockito.times(1)).cancelReservation(id);
    }

    @Test
    public void checkIfControllerMethodCheckRoomReservationCorrectlyCallsTheCorrespondingServiceMethod() throws Exception {
        Date reservedFrom = new Date(117, 1, 1);
        Date reservedTo = new Date(117, 1, 5);
        Map<String, List<Room>> map = new HashMap<String, List<Room>>();
        reservationController.checkRoomReservation(reservedFrom, reservedTo, map );
        Mockito.verify(reservationService, Mockito.times(1)).checkRoomReservation(reservedFrom, reservedTo, map);
    }

    @Test
    public void checkIfControllerMethodGetAllUserReservationsCorrectlyCallsTheCorrespondingServiceMethod() throws Exception {

    }

}