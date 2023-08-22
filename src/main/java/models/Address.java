package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Address {
    @JacksonXmlProperty(localName = "street")
    private String street;
    @JacksonXmlProperty(localName = "city")
    private String city;
    @JacksonXmlProperty(localName = "postalcode")
    private String postalCode;

    public Address() {
        this.street = "";
        this.city = "";
        this.postalCode = "";
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }


}


