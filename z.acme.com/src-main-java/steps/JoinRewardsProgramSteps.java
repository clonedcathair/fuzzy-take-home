package xxx.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.westadvantage.Membership;
import fuzzy.interview.pageobject.product.MyAccountPage;
import fuzzy.interview.pageobject.westadvantage.RewardsPage;

public class JoinRewardsProgramSteps extends AbstractSteps {

    MyAccountPage myAccountPage;
    RewardsPage rewardsPage;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public JoinRewardsProgramSteps joins_west_advantage_rewards_for(Membership membership) {
        Expected.membership = membership;
        myAccountPage.clickJoinRewardsProgram();
        rewardsPage.
                clickJoinWestAdvantage(Expected.membership).
                enterAddressPhone().
                selectIAgree().
                clickPurchaseMembership().
                selectOptionalServices(Expected.membership.getOptionalServices()).
                clickIAgreeToWestAdvantage(Expected.membership).
                clickAddToCart();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS

}
