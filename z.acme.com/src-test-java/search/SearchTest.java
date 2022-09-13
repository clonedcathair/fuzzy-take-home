package old.proj.ignore.search;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.Product;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("search")
})
public class SearchTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps SearchSteps browser;

    final Product FLARE = Product.HANDHELD_ORANGE_SMOKE_FLARE;

    @Title("Gary Guest searches product by Name")
    @Test
    public void should_be_able_to_search_product_by_name_as_guest() {
        User asExpectedUser = User.garyGuest();
        LOGGER.info(String.format("As a %s user, try searching by name for %s", asExpectedUser.getUserType(), FLARE.getName()));
        browser.
                starts_on_my_account_page(asExpectedUser).
                searches_for_product(FLARE.getName()).
                should_see_product_in_results(FLARE);
    }

    @Title("Gary Guest searches product by SKU")
    @Test
    public void should_be_able_to_search_product_by_sku_as_guest() {
        search_product_by_sku_as(User.garyGuest());
    }

    @Title("Ron Retail searches product by SKU")
    @Test
    public void should_be_able_to_search_product_by_sku_as_retail() {
        search_product_by_sku_as(User.ronRetail());
    }

    @Title("Peter Pro searches product by SKU")
    @Test
    public void should_be_able_to_search_product_by_sku_as_pro() {
        search_product_by_sku_as(User.peterPro());
    }


    private void search_product_by_sku_as(User asExpectedUser) {
        LOGGER.info(String.format("As a %s user, try searching by sku for %s", asExpectedUser.getUserType(), FLARE.getSKU()));
        browser.
                starts_on_my_account_page(asExpectedUser).
                searches_for_product(FLARE.getSKU()).
                should_see_product_in_results(FLARE);
    }
}