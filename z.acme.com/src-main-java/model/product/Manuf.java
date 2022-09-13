package xxx.model.product;

import java.util.Arrays;

public enum Manuf {
    COLUMBIA ("Columbia"),
    GILL     ("Gill"),
    BLACKTIP ("Black Tip"),
    GRUNDENS ("Grundens"),
    ORION    ("Orion");

    private final String company;

    Manuf(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public static Manuf getAny() {
        return Arrays.stream( Manuf.values()).skip((int)(Manuf.values().length * Math.random()) ).findAny().get();
    }
}