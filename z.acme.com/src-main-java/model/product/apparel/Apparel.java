package xxx.model.product.apparel;

import xxx.model.product.Manuf;

import java.util.Arrays;

public enum Apparel {
    MENS_PFG_BAHAMA_II_SHIRT ("1011651-623-L", "Men's PFG Bahama II Shirt", Manuf.COLUMBIA, Color.VIVID_BLUE, Size.M,"45", "45.00");

    private final String sku;
    private final String name;
    private final Manuf manuf;
    private final Color color;
    private final Size size;
    private final String amount;
    private final String price;

    Apparel(String sku, String name, Manuf manuf, Color color, Size size, String amount, String price) {
        this.sku = sku;
        this.name = name;
        this.manuf = manuf;
        this.color = color;
        this.size = size;
        this.amount = amount;
        this.price = price;
    }

    public String getSKU() {
        return sku;
    }
    public String getName() {
        return name;
    }
    public Manuf getManuf() {
        return manuf;
    }
    public Color getColor() {
        return color;
    }
    public Size getSize() {
        return size;
    }
    public String getAmount() {
        return amount;
    }
    public String getPrice() {
        return price;
    }

    public static Apparel getAny() {
        return Arrays.stream( Apparel.values()).skip((int)(Apparel.values().length * Math.random()) ).findAny().get();
    }

    @Override
    public String toString() {
        return String.format("{name=%s, sku=%s, manuf=%s, color=%s, size=%s, amount=%s, price=%s}", name, sku, manuf, color, size, amount, price);
    }
}