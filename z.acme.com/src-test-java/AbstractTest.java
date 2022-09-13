package old.proj.ignore;

import fuzzy.interview.model.product.intangible.EGiftCard;
import fuzzy.interview.model.product.intangible.GiftCard;

import java.util.logging.Logger;

public class AbstractTest {
    protected final Logger LOGGER = Logger.getLogger(String.valueOf(this));

    protected void LOG(Object ob) {
        String message = "";
        if (ob instanceof GiftCard) {
            GiftCard gc = (GiftCard)ob;
            message += "Testing Gift Card amount: $" + gc.getPrice();
            if (gc.isCustom()) message += " CUSTOM";
        }
        else if (ob instanceof EGiftCard) {
            EGiftCard egc = (EGiftCard)ob;
            message += "Testing EGift Card amount: $" + egc.getPrice();
            if (egc.isCustom()) message += " CUSTOM";
        }
        LOGGER.info(message);
    }
}
