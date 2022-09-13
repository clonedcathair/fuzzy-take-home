package xxx.model.common;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Shipping {
    STANDARD_DELIVERY  ("Standard Delivery (3 - 7 days)",           new BigDecimal( 9.95)),
    TWO_DAY            ("2 Day (2 Business Days)",                  new BigDecimal(21.95)),
    ONE_DAY            ("1 Day (1 Business Day)",                   new BigDecimal(32.95)),
    ONE_DAY_PRIORITY   ("1 Day Priority (1 Business Day)",          new BigDecimal(39.95)),
    SATURDAY_DELIVERY  ("Saturday Delivery (1 Day)",                new BigDecimal(49.95)),
    HAZARDOUS_STANDARD ("Hazardous Standard (3 - 7 Business Days)", new BigDecimal( 9.95)),
    TRUCK_FREIGHT      ("Truck Freight LTL (3 - 7 Business Days)",  new BigDecimal(99.95)),
    FREE_SHIPPING      ("Free Shipping",                            new BigDecimal( 0.00));

    private final String method;
    private final BigDecimal price;

    Shipping(String method, BigDecimal price) {
        this.method = method;
        this.price = price;
    }

    public String getMethod() {
        return method;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public static Shipping getAny() {
        return Arrays.stream( Shipping.values()).skip((int)(Shipping.values().length * Math.random()) ).findAny().get();
    }
}