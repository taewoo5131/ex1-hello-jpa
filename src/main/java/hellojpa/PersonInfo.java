package hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class PersonInfo {
    private String personName;
    private String personCountry;
    private String personGender;

    public PersonInfo() {
    }

    public PersonInfo(String personName, String personCountry, String personGender) {
        this.personName = personName;
        this.personCountry = personCountry;
        this.personGender = personGender;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonCountry() {
        return personCountry;
    }

    public void setPersonCountry(String personCountry) {
        this.personCountry = personCountry;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }
}
