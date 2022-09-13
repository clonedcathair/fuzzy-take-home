package xxx.model.usertype;

import xxx.model.common.Address;
import xxx.model.common.Payment;
import xxx.model.common.User;
import xxx.model.westadvantage.Membership;

public class GoldUser {
    public static User user() {
        User gold = new User();
        gold.setFirstname("GoldieGold");
        gold.setLastname("WMQA");
        gold.setEmail("goldiegoldwmqa@gmail.com");
        gold.setPassword(User.DEFAULT_PASSWORD);
        gold.setConfirmPassword(User.DEFAULT_PASSWORD);
        gold.setStayUpdated(false);
        gold.setMembership(Membership.GOLD);
        gold.setBillingAddress(Address.CA_WATSONVILLE_WESTRIDGE_DR);
        gold.setShippingAddress(Address.CA_HOLLISTER_BERT_DR);
        gold.setPayment(Payment.MASTERCARD);
        gold.setUserType(UserType.RETAIL);
        return gold;
    }
}
