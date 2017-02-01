package com.manardenza.controller;

import com.manardenza.login.CurrentUser;
import com.manardenza.service.HotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class HotelControllerTest {
    @Mock
    private HotelService hotelService;
    @Mock
    private CurrentUser currentUser;
    @InjectMocks
    private HotelController hotelController;

    @Test
    public void findHotelByName() throws Exception {
        String hotelName = "Mariott";
        hotelController.findHotelByName(hotelName);
        Mockito.verify(hotelService, Mockito.times(1)).findHotelByName(hotelName);
    }

    @Test
    public void findHotelByCity() throws Exception {
        String city = "Kiev";
        hotelController.findHotelByCity(city);
        Mockito.verify(hotelService, Mockito.times(1)).findHotelByCity(city);
    }

    @Test
    public void getAvailableRooms() throws Exception {
        String city = "Kiev";
        int persons = 2;
        int price = 2;
        Date fromDate = new Date(117, 1, 1);
        Date toDate = new Date(117, 1, 5);
        hotelController.getAvailableRooms(city, persons, price, fromDate, toDate);
        Mockito.verify(hotelService, Mockito.times(1)).getAvailableRooms(city, persons, price, fromDate, toDate);
    }

}