package com.manardenza.dao;

import com.manardenza.TestUtils;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

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
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HotelDaoImpl.class)
public class AbstractDaoTest {

    @Mock
    private File databaseFile;
    @InjectMocks
    private ReservationDaoImpl reservationDao;
    private ObjectInputStream oisMock = PowerMockito.mock(ObjectInputStream.class);
    private ObjectOutputStream oosMock = PowerMockito.mock(ObjectOutputStream.class);
    private FileInputStream inputStreamMock = PowerMockito.mock(FileInputStream.class);
    private FileOutputStream outputStreamMock = PowerMockito.mock(FileOutputStream.class);
    private List<Reservation> testReservationsList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        whenNew(ObjectOutputStream.class).withArguments(Matchers.any()).thenReturn(oosMock);
        whenNew(ObjectInputStream.class).withArguments(Matchers.any()).thenReturn(oisMock);
        whenNew(FileInputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(inputStreamMock);
        whenNew(FileOutputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(outputStreamMock);
    }

    @Test
    public void save() throws Exception {
        Reservation testReservation = new Reservation(TestUtils.RESERVED_FROM, TestUtils.RESERVED_TO,
                TestUtils.USER, TestUtils.ROOM, TestUtils.HOTEL);
        assertEquals(testReservation, reservationDao.save(testReservation));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void saveAll() throws Exception {
        ArrayList<Reservation> listToSaveReservations = new ArrayList<>();
        when(reservationDao.database.addAll(testReservationsList)).thenReturn(true);
        reservationDao.saveAll(testReservationsList);
        assertEquals(true, reservationDao.database.addAll(testReservationsList));
    }

    @Test
    public void getAll() throws Exception {
        testReservationsList.add(new Reservation(TestUtils.RESERVED_FROM, TestUtils.RESERVED_TO,
                new User(TestUtils.FIRST_NAME, TestUtils.LAST_NAME), TestUtils.ROOM, TestUtils.HOTEL));
        testReservationsList.add(new Reservation(TestUtils.RESERVED_FROM, TestUtils.RESERVED_TO,
                new User(TestUtils.FIRST_NAME, TestUtils.LAST_NAME), TestUtils.ROOM, TestUtils.HOTEL));
        testReservationsList.add(new Reservation(TestUtils.RESERVED_FROM, TestUtils.RESERVED_TO,
                new User("Test1", "User1"), TestUtils.ROOM, TestUtils.HOTEL));
        when(oisMock.readObject()).thenReturn(testReservationsList);
        reservationDao.getAll();
        assertEquals(testReservationsList, reservationDao.getAll());
    }
}