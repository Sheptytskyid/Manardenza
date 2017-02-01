package com.manardenza.service;

import com.manardenza.dao.ReservationDaoImpl;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.manardenza.TestUtils.HOTEL;
import static com.manardenza.TestUtils.RESERVED_FROM;
import static com.manardenza.TestUtils.RESERVED_TO;
import static com.manardenza.TestUtils.ROOM;
import static com.manardenza.TestUtils.USER;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationDaoImpl reservationDao;

    @Captor
    ArgumentCaptor<Reservation> reservationCaptor;

    @Captor
    ArgumentCaptor<String> stringCaptor;

    @Captor
    ArgumentCaptor<Map<String, List<Room>>> mapCaptor;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    public void bookRoomCreatedReservation() throws Exception {
        Reservation testReservation = new Reservation(RESERVED_FROM, RESERVED_TO, USER, ROOM, HOTEL);
        reservationService.bookRoom(RESERVED_FROM, RESERVED_TO, ROOM, HOTEL);

        Mockito.verify(reservationDao, Mockito.times(1)).save(reservationCaptor.capture());
        Reservation savedReservation = reservationCaptor.getValue();
        assertEquals(savedReservation.getReservedFrom(), testReservation.getReservedFrom());
        assertEquals(savedReservation.getReservedTo(), testReservation.getReservedTo());
        assertEquals(savedReservation.getReservedRoom(), testReservation.getReservedRoom());
        assertEquals(savedReservation.getReservedHotel(), testReservation.getReservedHotel());
    }

    @Test
    public void cancelReservationDeletesreservation() throws Exception {
        Reservation testReservation = new Reservation(RESERVED_FROM, RESERVED_TO, USER, ROOM, HOTEL);
        List<Reservation> testReservationList = new ArrayList<>();
        testReservationList.add(testReservation);
        when(reservationDao.getAll()).thenReturn(testReservationList);

        reservationService.cancelReservation(testReservation.getId());
        Mockito.verify(reservationDao, Mockito.times(1)).delete(testReservation);
    }

    @Test
    public void checkRoomReservation() throws Exception {
        //FIXME; test logic
    }

    @Test
    public void getAllUserReservationsFtomReservationDao() throws Exception {
        reservationService.getAllUserReservations();
        Mockito.verify(reservationDao, Mockito.times(1)).getAll();
    }

}