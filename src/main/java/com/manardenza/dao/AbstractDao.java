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

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(databaseFile))) {
            oos.writeObject(database);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFile))) {
            database = (List<T>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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