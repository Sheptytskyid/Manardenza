package com.manardenza.service;

import com.manardenza.dao.HotelDaoImpl;
import com.manardenza.entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTest {

    @Mock
    private HotelDaoImpl hotelDao;

    @Mock
    private Hotel hotel;

    @InjectMocks
    private HotelService hotelService;

    @Test
    public void findHotelByName() throws Exception {
        hotelService.findHotelByName("Marriott");

    }

    @Test
    public void findHotelByCity() throws Exception {

    }

    @Test
    public void getAvailableRooms() throws Exception {

    }

    @Test
    public void findPreliminaryRoom() throws Exception {

    }

}