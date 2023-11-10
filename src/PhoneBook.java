import java.util.List;

public class PhoneBook {
    private String name;
    private String lastName;
    private int yearsOld;
    private Adress adress;
    private List<String> phoneNumbers;

    protected PhoneBook(String name, String lastName, int yearsOld, Adress adress, List<String> phoneNumbers){
        this.name = name;
        this.lastName = lastName;
        this.yearsOld = yearsOld;
        this.adress = adress;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return  "name: " + name +
                "\nlast name:" + lastName +
                "\nAge:" + yearsOld +
                "\nAdress:" + adress +
                "\nPhone Numbers:" + phoneNumbers;
    }

    @Override
    public boolean equals(Object obj) {
        String phoneObj = (String) obj;
        return this.getName().equals(phoneObj) || this.getLastName().equals(phoneObj) || this.adress.equals(obj);
    }
}
