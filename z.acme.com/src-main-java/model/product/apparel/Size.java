package xxx.model.product.apparel;

import java.util.Arrays;

public enum Size {
    XS  ("S", "Extra-Small"),
    S   ("S", "Small"),
    M   ("M", "Medium"),
    L   ("L", "Large"),
    XL  ("XL", "Extra-Large"),
    XXL ("2XL", "2-Extra-Large");

    private final String label;
    private final String name;

    Size(String label, String name) {
        this.label = label;
        this.name = name;
    }

    public String getLabel() {
        return label;
    }
    public String getName() {
        return name;
    }

    public static Size getAny() {
        return Arrays.stream( Size.values()).skip((int)(Size.values().length * Math.random()) ).findAny().get();
    }
}