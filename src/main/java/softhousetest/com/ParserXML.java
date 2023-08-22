package softhousetest.com;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.*;

public class ParserXML {
    private final List<Person> peopleList = new ArrayList<>();

    public String output;

    public ParserXML(String output) {
        this.output = output;
    }

    public void parseInput(String input) {
        String[] entries = input.split("\n");

        Person person = null;
        boolean isfamily = false;
        String firstName;
        String lastName;
        String mobile;
        String homeNumber;
        String street;
        String city;
        String postalCode;
        String familyName;
        String born;


        for (String line : entries) {
            String[] parts = line.split("\\|");
            switch (parts[0]) {
                case "P":
                    firstName = parts[1];
                    lastName = parts[2];
                    person = new Person(firstName, lastName);
                    peopleList.add(person);
                    isfamily = false;
                    break;
                case "T":
                    if (person == null) {
                        break;
                    }
                    if (isfamily) {
                        mobile = parts[1];
                        homeNumber = parts[2];
                        List<Family> families = peopleList.get(peopleList.size() - 1).getFamilies();
                        families.get(families.size() - 1).setPhone(new Phone(mobile, homeNumber));
                        peopleList.get(peopleList.size() - 1).setFamilies(families);

                    } else {
                        mobile = parts[1];
                        homeNumber = parts[2];
                        peopleList.get(peopleList.size() - 1).setPhone(new Phone(mobile, homeNumber));
                    }
                    break;
                case "A":
                    if (isfamily) {
                        if (parts.length < 4) {
                            street = parts[1];
                            city = parts[2];
                            postalCode = "";
                            Address address = new Address();
                            address.setStreet(street);
                            address.setCity(city);
                            address.setpostalCode(postalCode);
                            List<Family> families = peopleList.get(peopleList.size() - 1).getFamilies();
                            families.get(families.size() - 1).setAddress(address);
                            peopleList.get(peopleList.size() - 1).setFamilies(families);
                            break;
                        } else {
                            street = parts[1];
                            city = parts[2];
                            postalCode = parts[3];
                            Address address = new Address();
                            address.setStreet(street);
                            address.setCity(city);
                            address.setpostalCode(postalCode);
                            List<Family> families = peopleList.get(peopleList.size() - 1).getFamilies();
                            families.get(families.size() - 1).setAddress(address);
                            peopleList.get(peopleList.size() - 1).setFamilies(families);
                            break;
                        }
                    } else {
                        if (parts.length < 4) {
                            street = parts[1];
                            city = parts[2];
                            postalCode = "";
                            Address address = new Address();
                            address.setStreet(street);
                            address.setCity(city);
                            address.setpostalCode(postalCode);
                            peopleList.get(peopleList.size() - 1).addAddress(address);
                            break;
                        } else {
                            street = parts[1];
                            city = parts[2];
                            postalCode = parts[3];
                            Address address = new Address();
                            address.setStreet(street);
                            address.setCity(city);
                            address.setpostalCode(postalCode);
                            peopleList.get(peopleList.size() - 1).addAddress(address);
                            break;
                        }
                    }
                case "F":
                    isfamily = true;
                    if (person == null) {
                        break;
                    } else if (parts.length == 3) {
                        familyName = parts[1];
                        born = parts[2];
                        peopleList.get(peopleList.size() - 1).addFamily(new Family(familyName, born));
                        break;
                    } else if (parts.length == 2) {
                        familyName = parts[1];
                        born = "";
                        peopleList.get(peopleList.size() - 1).addFamily(new Family(familyName, born));
                        break;
                    } else {
                        familyName = "";
                        born = "";
                        peopleList.get(peopleList.size() - 1).addFamily(new Family(familyName, born));
                    }
                    break;
            }

        }
        People people = new People(peopleList);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(output), people);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}