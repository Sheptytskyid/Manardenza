package com.manardenza.entity;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractObject implements Serializable{

    private long id;

    protected AbstractObject() {
        id = generatePositiveRandId();
    }

    private static long generatePositiveRandId() {
        long id = UUID.randomUUID().getMostSignificantBits();
        if (id < 0) {
            id = generatePositiveRandId();
        }
        return id;
    }

    public long getId() {
        return id;
    }
}