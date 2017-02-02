package com.manardenza.controller;

import com.manardenza.TestUtils;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.User;
import com.manardenza.login.CurrentUser;
import com.manardenza.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.manardenza.TestUtils.HOTEL;
import static com.manardenza.TestUtils.RESERVED_FROM;
import static com.manardenza.TestUtils.RESERVED_TO;
import static com.manardenza.TestUtils.ROOM;
import static com.manardenza.TestUtils.ROOMS_MAP;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
public class ReservationControllerTest {

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;
    private CurrentUser currentUser = PowerMockito.mock(CurrentUser.class);
    private ObjectInputStream oisMock = PowerMockito.mock(ObjectInputStream.class);
    private ObjectOutputStream oosMock = PowerMockito.mock(ObjectOutputStream.class);
    private FileInputStream inputStreamMock = PowerMockito.mock(FileInputStream.class);
    private FileOutputStream outputStreamMock = PowerMockito.mock(FileOutputStream.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        whenNew(ObjectOutputStream.class).withArguments(Matchers.any()).thenReturn(oosMock);
        whenNew(ObjectInputStream.class).withArguments(Matchers.any()).thenReturn(oisMock);
        whenNew(FileInputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(inputStreamMock);
        whenNew(FileOutputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(outputStreamMock);
    }

    @Test
    public void bookRoomCallsServiceMethod() throws Exception {
        reservationController.bookRoom(RESERVED_FROM, RESERVED_TO, ROOM, HOTEL);
        verify(reservationService, times(1)).bookRoom(RESERVED_FROM, RESERVED_TO, ROOM, HOTEL);
    }

    @Test
    public void cancelReservationCallsServiceMethod() throws Exception {
        long id = 0;
        reservationController.cancelReservation(id);
        verify(reservationService, times(1)).cancelReservation(id);
    }

    @Test
    public void checkRoomReservationCallsServiceMethod() throws Exception {
        reservationController.checkRoomReservation(RESERVED_FROM, RESERVED_TO, ROOMS_MAP);
        verify(reservationService, times(1)).checkRoomReservation(RESERVED_FROM, RESERVED_TO, ROOMS_MAP);
    }

    @Test
    public void getAllUserReservationsCallsServiceMethod() throws Exception {
        User testCurrentUser = new User("Test", "User");
        Reservation testReservation = new Reservation(RESERVED_FROM, RESERVED_TO, testCurrentUser, ROOM, HOTEL);
        List<Reservation> testReservationsList = new ArrayList<>();
        testReservationsList.addAll(TestUtils.getTestReservationList());
        testReservationsList.add(testReservation);
        List<Reservation> expectedReservationsList = new ArrayList<>();
        expectedReservationsList.add(testReservation);
        PowerMockito.when(currentUser.getUser()).thenReturn(testCurrentUser);
        PowerMockito.when(oisMock.readObject()).thenReturn(testReservationsList);

        assertEquals(expectedReservationsList, reservationService.getAllUserReservations());
        verify(reservationService, times(1)).getAllUserReservations();
    }
}