package xxx.model.product.intangible;

import java.util.Arrays;
import java.util.Random;

public enum GiftCard {
    DOLLAR_10     ("9520222", "10", "", ""),
    DOLLAR_25     ("3847373", "25", "", ""),
    DOLLAR_50     ("3851656", "50", "", ""),
    DOLLAR_100    ("3853579", "100", "", ""),
    DOLLAR_150    ("9520271", "150", "", ""),
    DOLLAR_CUSTOM ("3853595", DOLLAR_10.getRandomAmount(), "", "");

    private final String sku;
    private final String amount;
    private       String price;
    private final String message;

    GiftCard(String sku, String amount, String price, String message) {
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
        return "Happy Birthday to You\nHappy Birthday to You\nHaaaaaaappyyyy Biiiiiiiirthday " +
                "Deeeeeeear West Maaaaariii-iiine\nHappy Birthday to You!";
    }


    public boolean isCustom() {
        return (getSKU().equals(GiftCard.DOLLAR_CUSTOM.getSKU())) ? true : false;
    }

    public static GiftCard getAny() {
        return Arrays.stream( GiftCard.values()).skip((int)(GiftCard.values().length * Math.random()) ).findAny().get();
    }

    private String getRandomAmount() {
        final int MAX = 250;
        final int MIN = 10;
        return String.valueOf(new Random().nextInt((MAX - MIN) + 1) + MIN);
    }


    public static void main(String... args) {
        GiftCard gc = GiftCard.getAny();
        System.out.println(gc.getSKU());
        System.out.println(gc.getAmount());
        System.out.println(gc.getPrice());
        System.out.println(gc.getMessage());
        System.out.println(gc.isCustom());
    }
}