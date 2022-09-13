package xxx.model.product.apparel;

import java.util.Arrays;

public enum Color {
    BEET            ("Beet"),
    BLUE_HERON      ("Blue Heron"),
    BRIGHT_PEACH    ("Bright Peach"),
    COLLEGIATE_NAVY ("Collegiate Navy"),
    COMMANDO        ("Commando"),
    COOL_GREY       ("Cool Grey"),
    CRESCENT        ("Crescent"),
    CYPRESS         ("Cypress"),
    EMERALD_CITY    ("Emerald City"),
    FOSSIL          ("Fossil"),
    GEYSER          ("Geyser"),
    GULF_STREAM     ("Gulf Stream"),
    HYDRANGEA       ("Hydrangea"),
    JADE_LIME       ("Jade Lime"),
    JUPITER         ("Jupiter"),
    KEY_WEST        ("Key West"),
    KOI             ("Koi"),
    MARINE_BLUE     ("Marine Blue"),
    MOXIE_GREEN     ("Moxie Green"),
    NECTAR          ("Nectar"),
    NIGHT_TIDE      ("Night Tide"),
    OPAL_BLUE       ("Opal Blue"),
    PACIFIC_BLUE    ("Pacific Blue"),
    SAIL            ("Sail"),
    SKYLER          ("Skyler"),
    STORM           ("Storm"),
    SUNLIT          ("Sunlit"),
    SUNSET_RED      ("Sunset Red"),
    VIVID_BLUE      ("Vivid Blue"),
    WHITE           ("White"),
    WHITENED_VIOLET ("Whitened Violet"),
    SAGE_PLAID      ("Sage Plaid");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Color getAny() {
        return Arrays.stream( Color.values()).skip((int)(Color.values().length * Math.random()) ).findAny().get();
    }
}