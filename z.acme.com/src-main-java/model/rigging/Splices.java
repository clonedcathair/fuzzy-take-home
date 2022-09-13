package xxx.model.rigging;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Splices {
    BRAID_EYE_SPLICE_GT_1 ("165456", "Braid eye splice (<1\")", new BigDecimal(15.99)),
    BRAID_EYE_SPLICE__1__1_3_4 ("13170477", "Braid Eye Splice (1\" – 1 ¾\")", new BigDecimal(24.99)),
    BRAID_EYE_SPLICE_2_PLUS ("17657917", "Braid Eye Splice (2\" +)", new BigDecimal(55.99)),
    DOUBLE_COVER_SPLICE ("158156", "Double cover splice", new BigDecimal(35.99)),
    END_TO_END_SPLICE ("189599", "End to End splice", new BigDecimal(15.99)),
    FLEMISH_EYE ("158164", "Flemish eye (reeving eye)", new BigDecimal(5.99)),
    HI_TECH_COMPOSITE_EYE_SPICE_WITH_LEATHER ("158170", "Hi-tech (composite) eye splice with leather", new BigDecimal(35.99)),
    HI_TECH_COMPOSITE_EYE_SPICE_NO_LEATHER ("165431", "Hi-tech (composite) eye splice with out leather", new BigDecimal(24.99)),
    MEGA_BRAID_EYE_SPLICE ("499665", "Mega Braid eye splice up to and including 3/4\"", new BigDecimal(30.99)),
    REGATTA_BRAID_EYE_SPLICE ("499657", "Regatta Braid eye splice", new BigDecimal(13.99)),
    ROPE_TO_CHAIN_SPLICE ("189466", "Rope to Chain splice", new BigDecimal(20.99)),
    STRAND_12_EYE_SPLICE ("317703", "12 Strand eye splice", new BigDecimal(13.99)),
    STA_SET_X_EYE_SPLICE ("165423", "Sta-Set \"X\" (unidirectional dacron) eye splice", new BigDecimal(20.99)),
    STRIPPED_COVERS ("158149", "Stripped covers (cover removal)", new BigDecimal(20.99)),
    TAIL_SEIZING ("579649", "Tail seizing (whipping)", new BigDecimal(3.99)),
    TAPER_SPLICE ("158180", "Taper splice", new BigDecimal(24.99)),
    TWIST_3_STRAND_EYE_SPLICE_LT__5_8 ("165415", "Twist (3-strand) eye splice less than 5/8\"", new BigDecimal(13.99)),
    TWIST_3_STRAND_EYE_SPLICE__5_8_AND_OVER ("499673", "Twist (3-strand) eye splice 5/8\" and over", new BigDecimal(20.99)),
    WIRE_ROPE_ALL ("469577", "Wire/Rope (All)", new BigDecimal(65.99)),
    PLAIT_TO_CHAIN ("8298655", "Plait to Chain", new BigDecimal(25.99)),
    LEATHER_INSTALLATION_PER_FT ("13170469", "Leather Installation (per ft)", new BigDecimal(24.99));

    private final String sku;
    private final String description;
    private final BigDecimal list;

    Splices(String sku, String description, BigDecimal list) {
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


    public static Splices getAny() {
        return Arrays.stream( Splices.values()).skip((int)(Splices.values().length * Math.random()) ).findAny().get();
    }

    @Override
    public String toString() {
        return String.format("{sku=%s, description=%s, list=%s}", sku, description, list);
    }
}