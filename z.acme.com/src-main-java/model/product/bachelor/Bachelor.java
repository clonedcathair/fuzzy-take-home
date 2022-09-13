package xxx.model.product.bachelor;

import xxx.model.common.Shipping;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

@ToString
public enum Bachelor {
    M25_HANDHELD_VHF_RADIO ("16949604", "M25 Handheld VHF Radio", new BigDecimal(119.99), null);

    private final String sku;
    private final String name;
    private final BigDecimal price;
    private Warranty warranty;

    Bachelor(String sku, String name, BigDecimal price, Warranty warranty) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
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
    public Warranty getWarranty() {
        return warranty;
    }

    public BigDecimal getOrderTotal() {
        return new BigDecimal(
                price.add(
                        warranty.getPrice().add(
                                warranty.getTax().add(
                                        Shipping.HAZARDOUS_STANDARD.getPrice())))
                .round(new MathContext(2, RoundingMode.HALF_UP)).doubleValue());
    }

    public Bachelor setWarranty(Warranty warranty) {
        this.warranty = warranty;
        return this;
    }

    public Bachelor withNoWarranty() {
        this.warranty = null;
        return this;
    }

    public static Bachelor getAny() {
        return Arrays.stream(Bachelor.values()).skip((int)(Bachelor.values().length * Math.random())).findAny().get().withNoWarranty();
    }

    public static Bachelor getAnyIncludeWarranty() {
        return getAny().setWarranty(Warranty.getAny());
    }
}