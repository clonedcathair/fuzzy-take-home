package xxx.model.common;

import xxx.model.product.Family;
import xxx.model.product.apparel.Apparel;
import xxx.model.product.intangible.GiftCard;
import xxx.model.product.bachelor.Bachelor;
import xxx.model.product.intangible.EGiftCard;
import xxx.model.westadvantage.Membership;
import lombok.Data;

@Data
public class Expected {
    public static String baseUrl;
    public static String checkoutUrl;
    public static User user;
    public static GiftCard giftCard;
    public static EGiftCard eGiftCard;
    public static Membership membership;
    public static Bachelor bachelor;
    public static Family family;
    public static Apparel apparel;
}