package ru.maslova.MySecondAppBak2024.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV (2.2, false),
    HR (1.2, true),
    TL (2.6, false),
    PM(2.5, true),
    CEO (1.0, true),
    CFO(1.1, true);

    private final double positionCoefficient;
    private final boolean isManager;

    Positions (double positionCoefficient, boolean isManager){
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
