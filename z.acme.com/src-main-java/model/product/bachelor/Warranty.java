package xxx.model.product.bachelor;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.Arrays;

@ToString
public enum Warranty {
    //NO_WARRANTY   (null, null, new BigDecimal(0.00), new BigDecimal(12.02)),
    ONE_YEAR_PLUS ("8817959", "1 Year PLUS Product Protection Plan", new BigDecimal(12.35), new BigDecimal(12.02));
    //TWO_YEAR_PLUS ("8817967", "2 Year PLUS Product Protection Plan", new BigDecimal(15.73), new BigDecimal(13.47));

    private final String sku;
    private final String name;
    private final BigDecimal price;
    private final BigDecimal tax;

    Warranty(String sku, String name, BigDecimal price, BigDecimal tax) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getSKU() {
        return sku;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public BigDecimal getTax() {
        return tax;
    }

    public static Warranty getAny() {
        return Arrays.stream( Warranty.values()).skip((int)(Warranty.values().length * Math.random()) ).findAny().get();
    }
}