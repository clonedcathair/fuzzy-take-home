package xxx.model.westadvantage;

import java.util.Arrays;

public enum OptionalServices {
    TRAILER_ASSIST                        (4639324,  15.00),
    UNLIMITED_FRESHWATER_TOWING           (9670381,  65.00),
    UNLIMITED_SALTWATER_FRESHWATER_TOWING (9670399, 140.00),
    UNLIMITED_GOLD_TOWING                 (5548078, 154.00);

    private final int sku;
    private final double price;

    OptionalServices(int sku, double price) {
        this.sku = sku;
        this.price = price;
    }

    public int getSKU() {
        return sku;
    }
    public double getPrice() {
        return price;
    }

    private int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static OptionalServices getAny() {
        return Arrays.stream( OptionalServices.values()).skip((int)(OptionalServices.values().length * Math.random()) ).findAny().get();
    }


    public static void main(String... args) {
        OptionalServices reward = OptionalServices.getAny();
        System.out.println(reward.sku);
        System.out.println(reward.price);
    }
}