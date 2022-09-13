package xxx.model.rigging;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Swaging {
    WIRE_SIZE__1_16__3_16 ("145419", "1/16\" - 3/16\" wire size", new BigDecimal(6.29)),
    WIRE_SIZE__7_32__9_32 ("145427", "7/32\" - 9/32\" wire size", new BigDecimal(12.29)),
    WIRE_SIZE__5_16__1_2 ("145435", "5/16\" - 1/2\" wire size", new BigDecimal(18.99));

    private final String sku;
    private final String description;
    private final BigDecimal list;

    Swaging(String sku, String description, BigDecimal list) {
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


    public static Swaging getAny() {
        return Arrays.stream( Swaging.values()).skip((int)(Swaging.values().length * Math.random()) ).findAny().get();
    }

    @Override
    public String toString() {
        return String.format("{sku=%s, description=%s, list=%s}", sku, description, list);
    }
}