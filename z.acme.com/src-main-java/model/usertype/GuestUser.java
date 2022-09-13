package xxx.model.usertype;

import xxx.model.common.Address;
import xxx.model.common.Payment;
import xxx.model.common.User;

public class GuestUser {
    public static User user() {
        User guest = new User();
        guest.setFirstname("GaryGuest");
        guest.setLastname("WM");
        guest.setEmail("garyguestwmqa@gmail.com");
        guest.setPassword(User.DEFAULT_PASSWORD);
        guest.setConfirmPassword(User.DEFAULT_PASSWORD);
        guest.setStayUpdated(false);
        guest.setBillingAddress(Address.CA_WATSONVILLE_WESTRIDGE_DR);
        guest.setShippingAddress(Address.CA_HOLLISTER_BERT_DR);
        guest.setPayment(Payment.MASTERCARD);
        guest.setUserType(UserType.GUEST);
        return guest;
    }

    public static User randomUser() {
        long unique = System.currentTimeMillis();
        User randomUser = new User();
        randomUser.setFirstname("Random" + unique);
        randomUser.setLastname("User" + unique);
        randomUser.setEmail("garyguestwmqa+random" + unique + "@gmail.com");
        randomUser.setPassword(User.DEFAULT_PASSWORD);
        randomUser.setConfirmPassword(User.DEFAULT_PASSWORD);
        randomUser.setStayUpdated(false);
        randomUser.setBillingAddress(Address.CA_WATSONVILLE_WESTRIDGE_DR);
        randomUser.setShippingAddress(Address.CA_HOLLISTER_BERT_DR);
        randomUser.setPayment(Payment.MASTERCARD);
        randomUser.setUserType(UserType.GUEST);
        return randomUser;
    }
}
