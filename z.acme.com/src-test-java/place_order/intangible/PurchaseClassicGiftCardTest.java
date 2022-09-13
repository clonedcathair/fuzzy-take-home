package old.proj.ignore.place_order.intangible;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.intangible.GiftCard;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("intangible"),
        @WithTag("classic-gift-card")
})
public class PurchaseClassicGiftCardTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps PlaceOrderSteps ronRetail;

    @Title("Purchase any classic gift card: $10, $25, $50, $100, $150, Custom")
    @Test
    public void should_be_able_to_purchase_classic_physical_gift_card() {
        final User AS_HIMSELF = User.ronRetail();
        final GiftCard CLASSIC_GIFT_CARD = GiftCard.getAny();
        LOG(CLASSIC_GIFT_CARD);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                place_order_for(CLASSIC_GIFT_CARD).
                should_see_on_receipt().
                    order_total(CLASSIC_GIFT_CARD.getPrice());
    }
}
