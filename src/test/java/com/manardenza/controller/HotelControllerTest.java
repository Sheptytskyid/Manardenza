package com.manardenza.controller;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HotelControllerTest {

    private static HotelController hotelController;

    @BeforeClass
    public static void setUp() throws Exception {
        hotelController = HotelController.getInstance();
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(HotelController.getInstance());
    }

    @Test
    public void findHotelByName() throws Exception {

    }

    @Test
    public void findHotelByCity() throws Exception {

    }

    @Test
    public void bookRoom() throws Exception {

    }

    @Test
    public void cancelReservation() throws Exception {

    }

    @Test
    public void findRoom() throws Exception {

    }

}