package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Family {
    @JacksonXmlProperty(localName = "name")
    private String familyName;
    @JacksonXmlProperty(localName = "born")
    private String born;
    @JacksonXmlProperty(localName = "address")
    private Address address;
    @JacksonXmlProperty(localName = "phone")
    private Phone phone;

    public Family(String familyName, String born) {
        this.familyName = familyName;
        this.born = born;
        this.address = new Address();
        this.phone = new Phone("", "");
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", born='" + born + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                '}';
    }
}
