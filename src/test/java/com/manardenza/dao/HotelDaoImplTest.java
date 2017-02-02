package com.manardenza.dao;

import com.manardenza.TestUtils;
import com.manardenza.entity.Hotel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HotelDaoImpl.class)
public class HotelDaoImplTest {
    @Mock
    private File databaseFile;
    @InjectMocks
    private HotelDaoImpl hotelDao;
    private ObjectInputStream oisMock;
    private ObjectOutputStream oosMock;
    private FileInputStream inputStreamMock;
    private FileOutputStream outputStreamMock;
    @Before
    public void setUp() throws Exception {
        oisMock = mock(ObjectInputStream.class);
        oosMock = mock(ObjectOutputStream.class);
        inputStreamMock = mock(FileInputStream.class);
        outputStreamMock = mock(FileOutputStream.class);
        MockitoAnnotations.initMocks(this);
        whenNew(ObjectOutputStream.class).withArguments(Matchers.any()).thenReturn(oosMock);
        whenNew(ObjectInputStream.class).withArguments(Matchers.any()).thenReturn(oisMock);
        whenNew(FileInputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(inputStreamMock);
        whenNew(FileOutputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(outputStreamMock);
    }
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
        PowerMockito.when(oisMock.readObject()).thenReturn(testHotelsList);
        List<Hotel> foundHotels = hotelDao.getHotelsByName(TestUtils.HOTEL_NAME);
        assertEquals(expectedHotels, foundHotels);
    }

    @Test
    public void getHotelsByCity() throws Exception {

    }
}