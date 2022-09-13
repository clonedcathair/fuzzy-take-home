package old.proj.ignore.account;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.user.GuestUser;
import fuzzy.interview.steps.CreateAccountSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("create-an-account"),
})
public class CreateAnAccountTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps CreateAccountSteps gary;

    @Title("Register for an account as some random user")
    @Test
    public void should_be_able_to_create_an_account() {
        final User AS_SOME_RANDOM_USER = GuestUser.randomUser();
        LOGGER.info("Creating account for random guest user: " + AS_SOME_RANDOM_USER);
        gary.
                starts_on_create_account_page(AS_SOME_RANDOM_USER).
                creates_an_account().
                should_see_welcome_user(AS_SOME_RANDOM_USER.getFirstname());
    }

}