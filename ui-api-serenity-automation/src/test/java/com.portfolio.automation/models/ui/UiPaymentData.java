package com.portfolio.automation.models.ui;

public class UiPaymentData {

    private final String nameOnCard;
    private final String cardNumber;
    private final String cvc;
    private final String expMonth;
    private final String expYear;

    public UiPaymentData(String nameOnCard, String cardNumber, String cvc, String expMonth, String expYear) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public static UiPaymentData defaultData() {
        return new UiPaymentData(
                "QA User",
                "4111111111111111",
                "123",
                "12",
                "2030"
        );
    }

    public String getNameOnCard() { return nameOnCard; }
    public String getCardNumber() { return cardNumber; }
    public String getCvc() { return cvc; }
    public String getExpMonth() { return expMonth; }
    public String getExpYear() { return expYear; }
}
