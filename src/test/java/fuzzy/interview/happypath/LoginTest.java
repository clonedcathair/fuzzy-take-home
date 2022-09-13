package fuzzy.interview.happypath;

import com.tngtech.java.junit.dataprovider.DataProvider;
import fuzzy.interview.AbstractTest;
import fuzzy.interview.model.user.User;
import fuzzy.interview.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("smoke"),
        @WithTag("login")
})
public class LoginTest extends AbstractTest {

    @Managed WebDriver driver;
    @Steps LoginSteps start;

    @DataProvider
    public static Object[][] provideStringAndExpectedLength() {
        return new Object[][] {
                { User.standardUser(), null },
                { User.lockedOutUser(), "Epic sadface: Sorry, this user has been locked out." },
                { User.standardUser(), null },
        };
    }

    @Title("Verify a locked_out user is unable to login and can’t see the Products page")
    @Test
    public void should_be_able_to_login_as_standard_user() {
        User standardUser = User.standardUser();
        LOGGER.info("Try logging in as: " + standardUser.getUsername());
        start.
                on_the_login_page().
                login_as(standardUser).
                should_see_the_product_page();
    }

    @Title("Verify a locked_out user is unable to login and can’t see the Products page")
    @Test
    public void should_not_be_able_to_login_as_locked_out_user() {
        User lockedoutUser = User.lockedOutUser();
        LOGGER.info("Try logging in as: " + lockedoutUser.getUsername());
        start.
                on_the_login_page().
                login_as(lockedoutUser).
                should_not_see_the_product_page().
                and_error_message_displayed_as("Epic sadface: Sorry, this user has been locked out.");
    }

    @Title("Verify a performance_glitch_user is able to login and view the Products page")
    @Test
    public void should_be_able_to_login_as_performance_glitch_user() {
        User performanceGlitchUser = User.performanceGlitchUser();
        LOGGER.info("Try logging in as: " + performanceGlitchUser.getUsername());
        start.
                on_the_login_page().
                login_as(performanceGlitchUser).
                should_see_the_product_page();
    }

    @Title("Verify a problem_user is able to login and validate the difference between a problem_user and a standard_user")
    @Test
    public void should_have_same_image_src_for_all_users() {
        start.
                check_image_src_for(User.problemUser(), User.standardUser());
    }
}