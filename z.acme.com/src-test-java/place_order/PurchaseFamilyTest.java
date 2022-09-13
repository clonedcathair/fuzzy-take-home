package old.proj.ignore.place_order;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("place_order"),
        @WithTag("family")
})
public class PurchaseFamilyTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps PlaceOrderSteps ronRetail;

    @Title("Purchase family product")
    @Test
    public void should_be_able_to_purchase_family_product() {
        final User AS_HIMSELF = User.ronRetail();
        final Family FAMILY_PRODUCT = Family.getAny();
        LOGGER.info("Test purchasing a family product: " + FAMILY_PRODUCT.getName());
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                place_order_for(FAMILY_PRODUCT).
                should_see_on_receipt().
                    order_total(103.68);
    }

}