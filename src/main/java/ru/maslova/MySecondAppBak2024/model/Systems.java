package ru.maslova.MySecondAppBak2024.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {

    ERP ("Enterprise Resource Planning"),
    CRM ("Customer Relationship Management"),
    WMS ("Warehouse Management System"),
    SRVC("Service 1");

    private final String name;

    Systems (String name){
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

}
