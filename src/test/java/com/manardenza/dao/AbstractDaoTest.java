package com.manardenza.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HotelDaoImpl.class)
public class AbstractDaoTest {

    @Mock
    private File databaseFile;
    @InjectMocks
    private ReservationDaoImpl reservationDao;
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
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void saveAll() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

}