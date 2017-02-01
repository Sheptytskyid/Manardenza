package com.manardenza.controller;

import com.manardenza.entity.User;
import com.manardenza.login.CurrentUser;
import com.manardenza.service.HotelService;
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
public class HotelControllerTest {
    @Mock
    private HotelService hotelService;
    @Mock
    private CurrentUser currentUser;
    @InjectMocks
    private HotelController hotelController;

    @Before
    public void setUp() {
        when(currentUser.getUser()).thenReturn(new User("Test", "User"));
    }

    @Test
    public void FindHotelByNameCallsServiceMethod() throws Exception {
        hotelController.findHotelByName(null);
        verify(hotelService, times(1)).findHotelByName(null);
    }

    @Test
    public void FindHotelByCityCallsServiceMethod() throws Exception {
        hotelController.findHotelByCity(null);
        verify(hotelService, times(1)).findHotelByCity(null);
    }

    @Test
    public void GetAvailableRoomsCallsServiceMethod() throws Exception {
        int persons = 2;
        int price = 300;
        hotelController.getAvailableRooms(null, persons, price, null, null);
        verify(hotelService, times(1)).getAvailableRooms(null, persons, price, null, null);
    }

}