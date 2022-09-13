package old.proj.ignore.tax;

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
        @WithTag("tax")
})
public class TaxNonExemptTest extends AbstractTest {
    @Managed WebDriver driver;
    @Steps PlaceOrderSteps ronRetail;

    @Title("Retail should be taxed")
    @Test
    public void should_be_taxed_if_retail() {
        final User AS_HIMSELF = User.ronRetail();
        final Bachelor BACHELOR_PRODUCT = Bachelor.getAny();
        LOGGER.info("As " + AS_HIMSELF + "\nTry purchasing a product to see if taxed: " + BACHELOR_PRODUCT);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                checkout_to_payment_summary_with(BACHELOR_PRODUCT).
                should_see_payment_summary_with_tax();
    }
}