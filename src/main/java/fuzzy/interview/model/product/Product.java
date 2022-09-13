package fuzzy.interview.model.product;

import fuzzy.interview.model.product.Manuf;

import java.util.Arrays;

public enum Product {
    HANDHELD_ORANGE_SMOKE_FLARE ("956", "Handheld Orange Smoke Flare, Single Flare", Manuf.ORION, 37.99);

    private final String sku;
    private final String name;
    private final Manuf manuf;
    private final double price;

    Product(String sku, String name, Manuf manuf, double price) {
        this.sku = sku;
        this.name = name;
        this.manuf = manuf;
        this.price = price;
    }

    public String getSKU() {
        return sku;
    }
    public String getName() {
        return name;
    }
    public Manuf getManuf() {
        return manuf;
    }
    public double getPrice() {
        return price;
    }

    public static Product getAny() {
        return Arrays.stream( Product.values()).skip((int)(Product.values().length * Math.random()) ).findAny().get();
    }
}