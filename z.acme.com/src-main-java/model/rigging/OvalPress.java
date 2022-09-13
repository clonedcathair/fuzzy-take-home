package xxx.model.rigging;

import java.math.BigDecimal;
import java.util.Arrays;

public enum OvalPress {
    WIRE_SIZE__1_16__3_8 ("158198","1/16\" - 3/8\" wire size", new BigDecimal(5.29));

    private final String sku;
    private final String description;
    private final BigDecimal list;

    OvalPress(String sku, String description, BigDecimal list) {
        this.sku = sku;
        this.description = description;
        this.list = list;
    }

    public String getSKU() {
        return sku;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getList() {
        return list;
    }


    public static OvalPress getAny() {
        return Arrays.stream( OvalPress.values()).skip((int)(OvalPress.values().length * Math.random()) ).findAny().get();
    }

    @Override
    public String toString() {
        return String.format("{sku=%s, description=%s, list=%s}", sku, description, list);
    }
}