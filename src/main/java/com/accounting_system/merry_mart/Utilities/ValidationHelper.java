package com.accounting_system.merry_mart.Utilities;

public class ValidationHelper {

    // Check if string is not null or empty
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Check if number is positive
    public static boolean isPositive(double value) {
        return value > 0;
    }

    // Check if integer is positive
    public static boolean isPositive(int value) {
        return value > 0;
    }
}