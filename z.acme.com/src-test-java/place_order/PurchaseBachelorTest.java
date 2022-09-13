package old.proj.ignore.place_order;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.bachelor.Bachelor;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("bachelor")
})
public class PurchaseBachelorTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps PlaceOrderSteps ronRetail;

    @Title("Purchase bachelor product")
    @Test
    public void should_be_able_to_purchase_bachelor_product() {
        final User AS_HIMSELF = User.ronRetail();
        final Bachelor BACHELOR_PRODUCT = Bachelor.getAny();
        LOGGER.info("As " + AS_HIMSELF + "\nTry purchasing a bachelor product: " + BACHELOR_PRODUCT);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                place_order_for(BACHELOR_PRODUCT).
                should_see_on_receipt().
                    order_total(141.96);
    }

    @Title("Purchase bachelor product with added warranty")
    @Test
    public void should_be_able_to_purchase_bachelor_product_with_protection_plan() {
        final User AS_HIMSELF = User.ronRetail();
        final Bachelor BACHELOR_PRODUCT = Bachelor.getAnyIncludeWarranty();
        LOGGER.info("As " + AS_HIMSELF + "\nTry purchasing a bachelor product: " + BACHELOR_PRODUCT);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                place_order_for(BACHELOR_PRODUCT).
                should_see_on_receipt().
                    order_total(162.11);
    }
}