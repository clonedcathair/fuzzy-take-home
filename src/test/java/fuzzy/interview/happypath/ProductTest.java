package fuzzy.interview.happypath;

import fuzzy.interview.AbstractTest;
import fuzzy.interview.model.user.User;
import fuzzy.interview.steps.ProductSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("cart")
})
public class ProductTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps ProductSteps start;

    User asStandardUser = User.standardUser();

    @Title("Verify a standard_user is able to add products to the cart")
    @Test
    public void should_be_able_to_add_product_to_the_cart() {
        start.
                on_product_page(asStandardUser).
                add_any_product_to_cart().
                should_see_cart_count_of(1);
    }

    @Title("Verify a standard_user is able to remove products from the cart")
    @Test
    public void should_be_able_to_remove_product_from_the_cart() {
        start.
                on_product_page(asStandardUser).
                add_any_product_to_cart().
                remove_any_from_the_cart().
                should_see_cart_count_of(0);
    }

    @Title("Verify the cart count gets updated")
    @Test
    public void should_be_able_see_the_cart_count_getting_updated() {
        start.
                on_product_page(asStandardUser).
                should_see_cart_count_of(0).
                add_any_product_to_cart().
                add_any_product_to_cart().
                should_see_cart_count_of(2).
                remove_any_from_the_cart().
                should_see_cart_count_of(1);
    }
}