package com.manardenza.dao;

import com.manardenza.entity.AbstractObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends AbstractObject> {

    protected List<T> database = new ArrayList<>();
    protected File databaseFile;
    protected FileOutputStream fos = null;
    protected ObjectOutputStream oos = null;
    protected FileInputStream fis = null;
    protected ObjectInputStream ois = null;

    {
        try {
            fos = new FileOutputStream(databaseFile);
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream(databaseFile);
            ois = new ObjectInputStream(fis);

        } catch (IOException ex) { //FIXME: Either log or rethrow this exception.
            ex.printStackTrace(); //FIXME: Use a logger to log this exception.
        }
    }

    private void saveToFile() {
        try {
            oos.writeObject(database);
            oos.close();
        } catch (IOException ex) { //FIXME: Either log or rethrow this exception.
            ex.printStackTrace(); //FIXME: Use a logger to log this exception.
        }
    }

    private void readFromFile() {
        try {
            database = (List<T>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) { //FIXME: Either log or rethrow this exception.
            ex.printStackTrace(); //FIXME: Use a logger to log this exception.
        }
    }

    public T save(T obj) {
        database.add(obj);
        saveToFile();
        return obj;
    }

    public boolean delete(T obj) {
        boolean result = database.remove(obj);
        if (result) {
            saveToFile();
        }
        return result;
    }

    public boolean saveAll(List<T> list) {
        boolean result = database.addAll(list);
        if (result) {
            saveToFile();
        }
        return result;
    }

    public List<T> getAll() {
        readFromFile();
        return database;
    }
}