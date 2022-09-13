package old.proj.ignore.account;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("smoke"),
        @WithTag("sign-out")
})
public class SignOutTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps MyAccountSteps ronRetail;

    @Title("Sign-out as Ron Retail user")
    @Test
    public void should_be_able_to_signout_as_retail_user() {
        final User AS_HIMSELF = User.ronRetail();
        LOGGER.info("Try signing out as: " + AS_HIMSELF.getEmail());
        ronRetail.
                starts_on_my_account_page(AS_HIMSELF).
                signs_out().
                should_see_sign_in();
    }
}