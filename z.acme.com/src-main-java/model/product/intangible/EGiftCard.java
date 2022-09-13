package xxx.model.product.intangible;

import java.util.Arrays;
import java.util.Random;

public enum EGiftCard {
    DOLLAR_10     ("10115046", "10", "", ""),
    DOLLAR_25     ("10115038", "25", "", ""),
    DOLLAR_50     ("10115004", "50", "", ""),
    DOLLAR_100    ("10115087", "100", "", ""),
    DOLLAR_150    ("10115020", "150", "", ""),
    //DOLLAR_250    ("10115053", "250", "", ""),   // cannot test amount 250, aurus processor declines >$249.99
    DOLLAR_CUSTOM ("1011", DOLLAR_10.getRandomAmount(), "", "");

    private final String sku;
    private final String amount;
    private       String price;
    private final String message;

    EGiftCard(String sku, String amount, String price, String message) {
        this.sku     = sku;
        this.amount  = amount;
        this.price   = price;
        this.message = message;
    }

    public String getSKU() {
        return sku;
    }
    public String getAmount() {
        return amount;
    }
    public String getPrice() {
        this.price = amount + ".00";
        return price;
    }
    public String getMessage() {
        return "Happy Boat Day!!!";
    }

    public boolean isCustom() {
        return (getSKU().equals(EGiftCard.DOLLAR_CUSTOM.getSKU())) ? true : false;
    }


    public static EGiftCard getAny() {
        return Arrays.stream(EGiftCard.values()).skip((int)(EGiftCard.values().length * Math.random())).findAny().get();
    }


    private String getRandomAmount() {
        final int MAX = 250;
        final int MIN = 10;
        return String.valueOf(new Random().nextInt((MAX - MIN) + 1) + MIN);
    }


    public static void main(String... args) {
        EGiftCard egc = EGiftCard.getAny();
        System.out.println(egc.getSKU());
        System.out.println(egc.getAmount());
        System.out.println(egc.getPrice());
        System.out.println(egc.getMessage());
        System.out.println(egc.isCustom());
    }
}
