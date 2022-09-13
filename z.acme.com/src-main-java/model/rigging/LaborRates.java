package xxx.model.rigging;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LaborRates {
    LABOR_15_MINS_IN_SHOP ("165250","15 minutes labor (in shop)", new BigDecimal(20.00)),
    LABOR_RIGGING_GENERIC ("8144156","Rigging Labor (generic & order marker)", new BigDecimal(0.00)),  // add price
    LABOR_RIGGING_ONSITE ("7940182","Rigging Labor Hourly (on site)", new BigDecimal(85.00));

    private final String sku;
    private final String description;
    private final BigDecimal list;

    LaborRates(String sku, String description, BigDecimal list) {
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


    public static LaborRates getAny() {
        return Arrays.stream( LaborRates.values()).skip((int)(LaborRates.values().length * Math.random()) ).findAny().get();
    }

    @Override
    public String toString() {
        return String.format("{sku=%s, description=%s, list=%s}", sku, description, list);
    }
}