package old.proj.ignore.place_order.intangible;

import old.proj.ignore.AbstractTest;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.user.GuestUser;
import fuzzy.interview.model.westadvantage.Membership;
import fuzzy.interview.steps.CreateAccountSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("acceptance"),
        @WithTag("intangible"),
        @WithTag("join-rewards-program")
})
public class JoinRewardsProgramTest extends AbstractTest {

    @Managed WebDriver driver;

    @Steps CreateAccountSteps setUp;
    @Steps JoinRewardsProgramSteps gary;
    @Steps PlaceOrderSteps verify;

    @Title("Joining West Advantage Gold Membership with Rewards")
    @Test
    public void should_be_able_to_join_gold_rewards_program() {
        final User AS_SOME_RANDOM_USER = GuestUser.randomUser();
        LOGGER.info("Create Random User: " + AS_SOME_RANDOM_USER);
        setUp.
                starts_on_create_account_page(AS_SOME_RANDOM_USER).
                creates_an_account();

        final Membership GOLD_MEMBERSHIP = Membership.GOLD;
        LOGGER.info("To Join Rewards Program: " + GOLD_MEMBERSHIP + "\nOptional Services: " + GOLD_MEMBERSHIP.getOptionalServices());
        gary.
                joins_west_advantage_rewards_for(GOLD_MEMBERSHIP);
        verify.
                place_order_for(GOLD_MEMBERSHIP).
                should_see_on_receipt().
                    order_total(GOLD_MEMBERSHIP.getOrderTotal());
    }
}