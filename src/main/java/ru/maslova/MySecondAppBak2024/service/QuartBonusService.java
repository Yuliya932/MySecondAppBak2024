package ru.maslova.MySecondAppBak2024.service;

import org.springframework.stereotype.Service;
import ru.maslova.MySecondAppBak2024.model.Positions;

@Service
public interface QuartBonusService {
    double calculate (Positions positions, double salary, double bonus, int workDays);
}
