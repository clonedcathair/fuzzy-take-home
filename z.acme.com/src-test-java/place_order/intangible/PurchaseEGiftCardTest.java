package old.proj.ignore.place_order.intangible;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.intangible.EGiftCard;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("intangible"),
        @WithTag("egift-card")
})
public class PurchaseEGiftCardTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps PlaceOrderSteps ronRetail;

    @Title("Purchase any egift card: $10, $25, $50, $100, $150, Custom")
    @Test
    public void should_be_able_to_purchase_egift_card() {
        final User AS_HIMSELF = User.ronRetail();
        final EGiftCard EGIFT_CARD = EGiftCard.getAny();
        LOG(EGIFT_CARD);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                place_order_for(EGIFT_CARD).
                should_see_on_receipt().
                    order_total(EGIFT_CARD.getPrice());
    }

}