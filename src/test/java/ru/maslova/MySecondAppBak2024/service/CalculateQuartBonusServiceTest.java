package ru.maslova.MySecondAppBak2024.service;

import org.junit.jupiter.api.Test;
import ru.maslova.MySecondAppBak2024.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateQuartBonusServiceTest {

    @Test
    void calculate() {
        //given
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDaysQuartIII = 78;
        double salary = 100000.00;

        //when
        double result = new CalculateQuartBonusService().calculate(positions, salary, bonus, workDaysQuartIII);

        //then
        double expected = 283076.92307692306;
        assertThat(result).isEqualTo(expected);
    }
}