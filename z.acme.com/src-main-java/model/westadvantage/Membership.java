package xxx.model.westadvantage;

import java.util.Arrays;

public enum Membership {
    GOLD   (-1, 25.00, OptionalServices.getAny()),
    SILVER (-2,  0.00, OptionalServices.getAny());

    private final int sku;
    private final double price;
    private OptionalServices services;

    Membership(int sku, double price, OptionalServices services) {
        this.sku = sku;
        this.price = price;
        this.services = services;
    }

    public int getSKU() {
        return sku;
    }
    public double getPrice() {
        return price;
    }
    public OptionalServices getOptionalServices() {
        return services;
    }

    public double getOrderTotal() {
        return price + services.getPrice();
    }

    public void setOptionalServices(OptionalServices services) {
        this.services = services;
    }

    public static Membership getAny() {
        return Arrays.stream( Membership.values()).skip((int)(Membership.values().length * Math.random()) ).findAny().get();
    }
}