package com.addressbooks;

public class Contact {
    private String NAME;

    private String COMPANY;

    private String EMAIL;

    private String PHONE_NUMBER;

    public Contact(String NAME, String COMPANY, String EMAIL, String PHONE_NUMBER) {
        this.NAME = NAME;
        this.COMPANY = COMPANY;
        this.EMAIL = EMAIL;
        this.PHONE_NUMBER = PHONE_NUMBER;
    }


    public String getNAME() {
        return NAME;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

}
