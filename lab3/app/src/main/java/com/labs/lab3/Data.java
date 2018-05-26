package com.labs.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private static final List<String> firms;
    private static final List<String> telephoneTypes;
    private static final Map<String, String> mobileNumbers;
    private static final Map<String, String> landLineNumbers;

    public static String getFirmTelephoneNumber(String firmName, String telephoneType) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Фірма: ").append(firmName).append("\n");
        switch (telephoneType) {
            case "Мобільний":
                stringBuffer.append("Мобільний телефон: ").append(mobileNumbers.get(firmName));
                break;
            case "Стаціонарний":
                stringBuffer.append("Стаціонарний телефон: ").append(landLineNumbers.get(firmName));
                break;
        }
        return String.valueOf(stringBuffer);
    }

    static {
        firms = new ArrayList<>();
        firms.add("Google");
        firms.add("Amazon");
        firms.add("Facebook");
        firms.add("Pied Piper");
        firms.add("eBay");

        telephoneTypes = new ArrayList<>();
        telephoneTypes.add("Мобільний");
        telephoneTypes.add("Стаціонарний");

        mobileNumbers = new HashMap<>();
        mobileNumbers.put(firms.get(0), "+30754673456");
        mobileNumbers.put(firms.get(1), "+30984562355");
        mobileNumbers.put(firms.get(2), "+30938764511");
        mobileNumbers.put(firms.get(3), "+30341234567");
        mobileNumbers.put(firms.get(4), "+30145670089");

        landLineNumbers = new HashMap<>();
        landLineNumbers.put(firms.get(0), "04-1234-6228");
        landLineNumbers.put(firms.get(1), "04-4247-7210");
        landLineNumbers.put(firms.get(2), "04-6578-1276");
        landLineNumbers.put(firms.get(3), "04-9999-9988");
        landLineNumbers.put(firms.get(4), "04-4536-3400");
    }

    public static List<String> getFirms() {
        return firms;
    }

    public static List<String> getTelephoneTypes() {
        return telephoneTypes;
    }
}
