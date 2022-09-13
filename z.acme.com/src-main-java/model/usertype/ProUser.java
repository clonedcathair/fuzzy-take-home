package xxx.model.usertype;

import xxx.model.common.Address;
import xxx.model.common.Payment;
import xxx.model.common.User;

public class ProUser {
    public static User user() {
        User pro = new User();
        // TODO: Peter Pro user account is just a Retail
        //pro.setFirstname("PeterPro");
        //pro.setEmail("peterprowmqa@gmail.com");
        //pro.setPassword(User.DEFAULT_PASSWORD);
        //pro.setConfirmPassword(User.DEFAULT_PASSWORD);

        pro.setFirstname("ABB4676552");
        pro.setEmail("PRO4676552@nonprod.westmarine.com");
        pro.setPassword("Westmarine2@");
        pro.setConfirmPassword("Westmarine2@");

        pro.setLastname("WMQA");
        pro.setStayUpdated(true);
        pro.setBillingAddress(Address.CA_WATSONVILLE_WESTRIDGE_DR);
        pro.setShippingAddress(Address.CA_HOLLISTER_BERT_DR);
        pro.setPayment(Payment.MASTERCARD);
        pro.setUserType(UserType.PRO);
        return pro;
    }
}
