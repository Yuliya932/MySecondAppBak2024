package ru.maslova.MySecondAppBak2024.service;

import org.junit.jupiter.api.Test;
import ru.maslova.MySecondAppBak2024.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculateAnnualBonusServiceTest {

    @Test
    void calculate() {

        //given
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
        double result = new CalculateAnnualBonusService().calculate(positions, salary, bonus, workDays);

        //then
        double expected = 361481.48148148146;
        assertThat(result).isEqualTo(expected);
    }
}