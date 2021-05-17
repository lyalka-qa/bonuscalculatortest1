package ru.netology.bonus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'registered user, bonus under limit',100060,true,30",
            "'registered user, bonus over limit',100000060,true,500",
            "'unregistered user, bonus under limit',100060,false,10",
            "'unregistered user, bonus under limit',100000060,false,500"
    }, delimiter = ',')
    void shouldCalculate(String testName, long amount, boolean registered, long expected) {
        System.out.println(testName);
        BonusService service = new BonusService();

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}