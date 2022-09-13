package old.proj.ignore.tax;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.bachelor.Bachelor;
import fuzzy.interview.model.product.intangible.EGiftCard;
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
public class TaxExemptTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps PlaceOrderSteps peterPro, ronRetail;

    @WithTag("pro-not-taxed")
    @Title("Pro should NOT be taxed")
    @Test
    public void should_not_be_taxed_if_pro() {
        final User AS_HIMSELF = User.peterPro();
        final Bachelor BACHELOR_PRODUCT = Bachelor.getAny();
        LOGGER.info("As " + AS_HIMSELF + "\nTry purchasing a product, should NOT be taxed: " + BACHELOR_PRODUCT);
        peterPro.
                starts_on_my_account_page(AS_HIMSELF).
                checkout_to_payment_summary_with(BACHELOR_PRODUCT).
                should_see_payment_summary_with_no_tax();
    }

    @WithTag("intangible-not-taxed")
    @Title("Intangibles should NOT be taxed")
    @Test
    public void should_not_be_taxed_with_intangibles() {
        final User AS_HIMSELF = User.ronRetail();
        final EGiftCard EGIFT_CARD = EGiftCard.getAny();
        LOGGER.info("As " + AS_HIMSELF + "\nTry purchasing intangible product, should NOT be taxed: ");
        LOG(EGIFT_CARD);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                checkout_to_payment_summary_with(EGIFT_CARD).
                should_see_payment_summary_with_no_tax();
    }

    @WithTag("tax-free-state-not-taxed")
    @Title("Tax free states should NOT be taxed")
    @Test
    public void should_not_be_taxed_in_tax_free_states() {
        final User AS_HIMSELF = User.ronRetail();
        final Bachelor BACHELOR_PRODUCT = Bachelor.getAny();

        LOGGER.info("As " + AS_HIMSELF + "\nTry purchasing a product, should NOT be taxed if in tax-tree state: OH");
        AS_HIMSELF.setShippingAddress(Address.NH_NASHUA_LAKE_ST);
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                checkout_to_payment_summary_with(BACHELOR_PRODUCT).
                should_see_payment_summary_with_no_tax();
    }
}