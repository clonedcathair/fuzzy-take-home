package old.proj.ignore.place_order;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.apparel.Apparel;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("apparel")
})
public class PurchaseApparelTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps PlaceOrderSteps ronRetail;

    @Title("Purchase apparel product")
    @Test
    public void should_be_able_to_purchase_apparel_product() {
        final User AS_HIMSELF = User.ronRetail();
        final Apparel APPAREL_PRODUCT = Apparel.getAny();
        LOGGER.info(String.format("Test purchasing an apparel product: %s", APPAREL_PRODUCT));
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                place_order_for(APPAREL_PRODUCT).
                should_see_on_receipt().
                    order_total(109.20);
    }
}