package hellojpa;

import javax.persistence.*;

@Entity
//public class Food extends BaseEntity{
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

    @Embedded
    private Period period;

    @Embedded
    private PersonInfo personInfo;

    @Embedded
    @AttributeOverride(name = "personName" , column = @Column(name = "GUEST_NAME"))
    @AttributeOverride(name = "personCountry" , column = @Column(name = "GUEST_COUNTRY"))
    @AttributeOverride(name = "personGender" , column = @Column(name = "GUEST_GENDER"))
    private PersonInfo guestInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public PersonInfo getGuestInfo() {
        return guestInfo;
    }

    public void setGuestInfo(PersonInfo guestInfo) {
        this.guestInfo = guestInfo;
    }
}
