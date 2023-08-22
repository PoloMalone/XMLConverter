package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    @JacksonXmlProperty(localName = "firstname")
    private String firstName;
    @JacksonXmlProperty(localName = "lastname")
    private String lastName;
    @JacksonXmlProperty(localName = "phone")
    private Phone phone;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "address")
    private final List<Address> addresses;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "family")
    private List<Family> families;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = new Phone("", "");
        this.addresses = new ArrayList<>();
        this.families = new ArrayList<>();
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void addFamily(Family family) {
        families.add(family);
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", addresses=" + addresses +
                ", families=" + families +
                '}';
    }

}
