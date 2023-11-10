import java.util.List;

public class PhoneBookBuilder {
    private String name;
    private String lastName;
    private int yearsOld;
    private Adress adress;
    private List<String> phoneNumbers;

    public PhoneBookBuilder Name(String name){
        this.name = name;
        return this;
    }
    public PhoneBookBuilder LastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public PhoneBookBuilder YearsOld(int yearsOld){
        this.yearsOld = yearsOld;
        return this;
    }
    public PhoneBookBuilder Adress(Adress adress){
        this.adress = adress;
        return this;
    }
    public PhoneBookBuilder PhoneNumbers(List<String> phoneNumbers){
        this.phoneNumbers = phoneNumbers;
        return this;
    }
    public PhoneBook Build(){
        return new PhoneBook(name, lastName, yearsOld, adress, phoneNumbers);
    }
}
