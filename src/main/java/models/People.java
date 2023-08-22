package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "people")
public class People {
    @JacksonXmlProperty(localName = "person")
    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Person> personList;

    public People(List<Person> people) {
        this.personList = people;
    }
}
