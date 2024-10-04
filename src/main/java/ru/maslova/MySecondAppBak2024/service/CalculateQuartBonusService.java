package ru.maslova.MySecondAppBak2024.service;

import org.springframework.stereotype.Service;
import ru.maslova.MySecondAppBak2024.model.Positions;

@Service
public class CalculateQuartBonusService implements QuartBonusService {

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDaysQuartIII) {

        if (positions.isManager()) {

            return salary * bonus * 92 * positions.getPositionCoefficient() / workDaysQuartIII;

        } else {
            return 0;
        }
    }
}
