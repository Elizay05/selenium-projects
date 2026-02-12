package stepdefinitions;

import io.cucumber.java.ParameterType;
import models.Money;

public class MoneyConverter {

    @ParameterType("\\d+\\.\\d+")
    public Money money(String amount) {
        String[] numbers = amount.split("\\.");
        int pesos = Integer.parseInt(numbers[0]);
        int cents = Integer.parseInt(numbers[1]);
        return new Money(pesos, cents);
    }
}
