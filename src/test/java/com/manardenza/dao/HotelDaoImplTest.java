package com.manardenza.dao;

import com.manardenza.TestUtils;
import com.manardenza.entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockito.class)
public class HotelDaoImplTest {
    InputStream inputStreamMock = mock(InputStream.class);
    whenNew(FileInputStream.class).withArguments("inputFile.txt").thenReturn(inputStreamMock);

    private HotelDaoImpl hotelDao = new HotelDaoImpl(databaseFile);

    @Test
    public void getHotelsByName() throws Exception {
        List<Hotel> testHotelsList = new ArrayList<>();
        testHotelsList.add(new Hotel(TestUtils.HOTEL_NAME, TestUtils.CITY, TestUtils.ROOMS_LIST));
        testHotelsList.add(new Hotel(TestUtils.HOTEL_NAME, TestUtils.CITY, TestUtils.ROOMS_LIST));
        testHotelsList.add(new Hotel("Not Correct Name", TestUtils.CITY, TestUtils.ROOMS_LIST));
        testHotelsList.add(new Hotel("Not Correct Name", TestUtils.CITY, TestUtils.ROOMS_LIST));
        List<Hotel> expectedHotels = new ArrayList<>();
        expectedHotels.add(testHotelsList.get(0));
        expectedHotels.add(testHotelsList.get(1));
        when(hotelDao.getAll()).thenReturn(testHotelsList);
        List<Hotel> foundHotels = hotelDao.getHotelsByName(TestUtils.HOTEL_NAME);
        assertEquals(expectedHotels, foundHotels);
    }

    @Test
    public void getHotelsByCity() throws Exception {

    }

}