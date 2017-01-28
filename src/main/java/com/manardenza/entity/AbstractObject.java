package com.manardenza.entity;

import java.util.UUID;

public abstract class AbstractObject {

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
}