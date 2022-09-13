package old.proj.ignore.account;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.steps.HomeSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("smoke"),
        @WithTag("sign-in")
})
public class SignInTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps HomeSteps theUser;

    @Title("Sign-in as Gary Guest user")
    @Test
    public void should_be_able_to_signin_as_guest_user() {
        try_signing_in_as( User.garyGuest() );
    }

    @Title("Sign-in as Ron Retail user")
    @Test
    public void should_be_able_to_signin_as_retail_user() {
        try_signing_in_as( User.ronRetail() );
    }

    @Title("Sign-in as Peter Pro user")
    @Test
    public void should_be_able_to_signin_as_pro_user() {
        try_signing_in_as( User.peterPro() );
    }

    @Title("Sign-in as Silvia Silver user")
    @Test
    public void should_be_able_to_signin_as_silver_member() {
        try_signing_in_as( User.silviaSilver() );
    }

    @Title("Sign-in as Goldie Gold user")
    @Test
    public void should_be_able_to_signin_as_gold_member() {
        try_signing_in_as( User.goldieGold() );
    }

    private void try_signing_in_as(User asThemself) {
        LOGGER.info("Try signing in as: " + asThemself.getEmail());
        theUser.
                starts_on_home_page(asThemself).
                signin_from_dropdown_as(asThemself).
                should_see_hi_user(asThemself.getFirstname());
    }
}