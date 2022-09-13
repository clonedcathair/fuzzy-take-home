package xxx.model.product;

import java.util.Arrays;

public enum Family {
    GLASSKOTER_RESIN_ROLLERS__9__1_8 ("P004_123_001-513", "Glasskoter Resin Rollers", "103129", "17", "16.99", "9\" Glasskoter Resin Roller Cover, 1/8\" Nap");

    private final String family;
    private final String name;
    private final String model;
    private final String amount;
    private final String price;
    private final String option;

    Family(String family, String name, String model, String amount, String price, String option) {
        this.family = family;
        this.name = name;
        this.model = model;
        this.amount = amount;
        this.price = price;
        this.option = option;
    }

    public String getFamily() {
        return family;
    }
    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public String getAmount() {
        return amount;
    }
    public String getPrice() {
        return price;
    }
    public String getOption() {
        return option;
    }

    public static Family getAny() {
        return Arrays.stream( Family.values()).skip((int)(Family.values().length * Math.random()) ).findAny().get();
    }
}