package com.flowerdeskconsole.utils;

public class Validation {

    public static boolean checkPasswordLength(String password) {
        return password.length()<8;
    }
    public static boolean checkPhoneNumberLength(String phoneNo) {
        return phoneNo.matches("\\d{10}");
    }

}
