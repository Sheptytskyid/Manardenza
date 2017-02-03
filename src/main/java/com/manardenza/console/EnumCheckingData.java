package com.manardenza.console;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.Predicate;

public enum EnumCheckingData {
    INTEGER(input -> StringUtils.isNumeric(input), "You need to enter a number");

    private String message;
    private final Predicate<String> predicate;

    EnumCheckingData(Predicate<String> predicate, String message) {
        this.predicate = predicate;
        this.message = message;
    }

    private boolean checkInt(EnumCheckingData...checkingDatas) {
        return Arrays.asList(checkingDatas).stream().anyMatch(checkingData -> checkingData == this);
    }
}