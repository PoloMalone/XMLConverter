package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Phone {

    @JacksonXmlProperty(localName = "mobile")
    private String mobile;
    @JacksonXmlProperty(localName = "homenumber")
    private String homeNumber;

    public Phone(String mobile, String homeNumber) {
        this.mobile = mobile;
        this.homeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "mobile='" + mobile + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                '}';
    }
}
