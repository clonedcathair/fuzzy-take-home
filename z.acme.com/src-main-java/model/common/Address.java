package xxx.model.common;

import java.util.Arrays;

public enum Address {
    CA_WATSONVILLE_WESTRIDGE_DR ("WMQAFirst", "WMQALast", "500 Westridge Dr", "Unit #101", "Watsonville", State.CA, "95076", "4085551212"),
    CA_HOLLISTER_BERT_DR ("WMQAFirst", "WMQALast", "2395 Bert Dr", "", "Hollister", State.CA, "95023", "4085551212"),
    NH_NASHUA_LAKE_ST ("WMQAFirst", "WMQALast", "55 Fort Eddy Rd", "", "Concord", State.NH, "03301", "40855553321"),
    OR_PORTLAND_SW_CALDEW_ST ("WMQAFirst", "WMQALast", "3914 SW Caldew St", "", "Portland", State.OR, "97219", "4085559999"),
    EMPTY ("", "", "", "", "",   State.EMPTY, "", ""),
    NULL (null, null, null, null, null,   State.NULL, null, null);

    private final String firstname;
    private final String lastname;
    private final String address1;
    private final String address2;
    private final String city;
    private final State state;
    private final String zip;
    private final String phone;

    Address(String firstname, String lastname, String address1, String address2, String city, State state, String zip, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getAddress1() {
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
    public String getCity() {
        return city;
    }
    public State getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getPhone() {
        return phone;
    }

    public static State getAny() {
        return Arrays.stream( State.values()).skip((int)(State.values().length * Math.random()) ).findAny().get();
    }
}