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
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTest {
    @Mock
    private ReservationService reservationService;
    @Mock
    private CurrentUser currentUser;
    @Mock
    private Hotel hotel;
    @InjectMocks
    private ReservationController reservationController;

    @Before
    public void setUp() {
        when(currentUser.getUser()).thenReturn(new User("Test", "User"));

    }

    @Test
    public void BookRoomCallsServiceMethod() throws Exception {
        Room room = new Room(null, 2, 2);
        Hotel hotel = new Hotel("Mariott", null, null);
        reservationController.bookRoom(null, null, room, hotel);
        verify(reservationService, times(1)).bookRoom(null, null, room, hotel);
    }

    @Test
    public void CancelReservationCallsServiceMethod() throws Exception {
        long id = 0;
        reservationController.cancelReservation(id);
        verify(reservationService, times(1)).cancelReservation(id);
    }

    @Test
    public void CheckRoomReservationCallsServiceMethod() throws Exception {
        reservationController.checkRoomReservation(null, null, null);
        verify(reservationService, times(1)).checkRoomReservation(null, null, null);
    }

    @Test
    public void GetAllUserReservationsCallsServiceMethod() throws Exception {

    }

}