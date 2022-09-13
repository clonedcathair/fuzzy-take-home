package fuzzy.interview.model.product;

import java.util.Arrays;

public enum SortedBy {
    NAME_A_TO_Z ("Name (A to Z)", "az"),
    NAME_Z_TO_A ("Name (Z to A)", "za"),
    PRICE_LOW_TO_HIGH ("Price (low to high)", "lohi"),
    PRICE_HIGH_TO_LOW ("Price (high to low)", "hilo");

    private final String text;
    private final String value;

    SortedBy(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }
    public String getValue() {
        return value;
    }

    public static SortedBy getAny() {
        return Arrays.stream( SortedBy.values()).skip((int)(SortedBy.values().length * Math.random()) ).findAny().get();
    }
}