package fuzzy.interview.happypath;

import fuzzy.interview.AbstractTest;
import fuzzy.interview.model.product.SortedBy;
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
        @WithTag("sort")
})
public class SortTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps ProductSteps start;


    @Title("Verify a standard_user can sort products are able to be sorted from low to high")
    @Test
    public void should_be_able_to_sort_product_from_low_to_high() {
        trySortingProduct(SortedBy.PRICE_LOW_TO_HIGH, 7.99);
    }

    @Title("Verify a standard_user can sort products are able to be sorted from high to low")
    @Test
    public void should_be_able_to_sort_product_from_high_to_low() {
        trySortingProduct(SortedBy.PRICE_HIGH_TO_LOW, 49.99);
    }

    @Title("Verify a standard_user can sort products are able to be sorted from A to Z")
    @Test
    public void should_be_able_to_sort_product_from_a_to_z() {
        trySortingProduct(SortedBy.NAME_A_TO_Z, 29.99);
    }

    @Title("Verify a standard_user can sort products are able to be sorted from Z to A")
    @Test
    public void should_be_able_to_sort_product_from_z_to_a() {
        trySortingProduct(SortedBy.NAME_Z_TO_A, 15.99);
    }


    private void trySortingProduct(SortedBy sortedBy, double expectedPrice) {
        start.
                on_product_page(User.standardUser()).
                when_product_is(sortedBy).
                should_see_first_product_with_the_price_of(expectedPrice);
    }
}