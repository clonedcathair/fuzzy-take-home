package xxx.model.common;

import java.util.Arrays;

public enum Payment {
    VISA             ("4011361100000012", "WMQA Visa", "08", "2024", "111"),
    MASTERCARD       ("5454545454545454", "WMQA Mastercard", "08", "2024", "111"),
    AMEX             ("371449635398431", "WMQA AmericanExpress", "08", "2024", "2222"),
    DISCOVER         ("6011000995500000", "WMQA Discover", "08", "2024", "111"),
    DINERS           ("3059990000000022", "WMQA Diners", "08", "2024", "111"),
    JCB              ("3566002020140006", "WMQA JCB", "08", "2024", "111"),
    CUP              ("6221261111113245", "WMQA ChinaUnionpay", "08", "2024", "111"),
    EMPTY            ("", "", "", "", ""),
    NULL             (null, null, null, null, null),
    EXPIRED          ("5454545454545454", "WMQA ExpiredMC", "08", "2019", "111"),
    INVALID_CVV      ("5454545454545454", "WMQA InvalidMCCVV", "08", "2024", "123"),
    INVALID_EXPMONTH ("5454545454545454", "WMQA InvalidMCExpMonth", "13", "2024", "111"),
    INVALID_EXPYEAR  ("5454545454545454", "WMQA InvalidMCExpYear", "08", "9999", "111");

    private final String cardNumber;
    private final String cardholderName;
    private final String expMonth;
    private final String expYear;
    private final String cvv;

    Payment(String cardNumber, String cardholderName, String expMonth, String expYear, String cvv) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public String getCardholderName() {
        return cardholderName;
    }
    public String getExpMonth() {
        return expMonth;
    }
    public String getExpYear() {
        return expYear;
    }
    public String getCVV() {
        return cvv;
    }

    public static State getAny() {
        return Arrays.stream( State.values()).skip((int)(State.values().length * Math.random()) ).findAny().get();
    }
}