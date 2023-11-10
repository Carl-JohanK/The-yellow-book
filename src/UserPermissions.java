import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPermissions {
    InputOutput input = new InputOutput();
    PhoneBookBuilder person = new PhoneBookBuilder();
    AdressBuilder adress = new AdressBuilder();
    List<PhoneBook> phoneBooks = new ArrayList<>();
    private String passWord = "password";
    private boolean adminPerms = false;

    public void Login(String passWord){
        boolean wantOtLogin = true;
        while (wantOtLogin){
            if(this.passWord.equals(passWord)){
                input.OutPrint("you are now login");
                adminPerms = true;
                wantOtLogin = false;
            } else {
                String answer = input.Question("do you still want to login (yes/no):");
                if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")){
                    Login(input.Question("login password(password): "));
                }
            }
            wantOtLogin = false;
        }
    }
    public void AddContact(){ //There may be too many prints
        if(!adminPerms) {
            input.OutPrint("you have to login before you can add");
            Login(input.Question("login password(password): "));
        }
        if(adminPerms){
            List<String> phoneNumbers = new ArrayList<>();
            boolean isDone = false;

            person.Name(input.Question("name:"));
            person.LastName(input.Question("last Name:"));
            person.YearsOld(input.QuestionInt("age:"));

            adress.City(input.Question("Adress (City):"));
            adress.PostalCode(input.QuestionInt("Adress (postal Code):"));
            adress.StreetName(input.Question("Adress (street name):"));
            adress.Port(input.Question("Adress (port):"));
            person.Adress(adress.Build());

            //you can set phone number to a string tex: "asdawc"
            //ints cant have a "0" as a start and you cant have "+46" if you want
            phoneNumbers.add(input.Question("phone number:"));
            while (!isDone) {
                String answer = input.Question("do you have another phone number (yes:no):");
                if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    isDone = true;
                    break;
                }
                phoneNumbers.add(input.Question("phone number:"));
            }
            phoneBooks.add(person.PhoneNumbers(phoneNumbers).Build());
        }

    }
    public void PrintAllContacts(){
        for (int i = 0; i < phoneBooks.size(); i++) {
            input.OutPrint( (i + 1) + "\n" + phoneBooks.get(i).toString());
        }
    }

    //i can use regex (\w+match\w+|\w+match|match?\w+) or .contains(match)
    // for more efficient search engine
    public void ViewPhoneBook(String match){
        boolean matches = false;
        Pattern pattern = Pattern.compile("\\w+" + match + "\\w+|\\w+" + match + "|" + match + "?\\w+");

        for (int i = 0; i < phoneBooks.size(); i++) {
            Matcher matcher = pattern.matcher(phoneBooks.get(i).toString());

            if(phoneBooks.get(i).getName().equalsIgnoreCase(match)){
                input.OutPrint(phoneBooks.get(i).toString());
                matches = true;
                break;
            }
            else if (phoneBooks.get(i).equals(match)) {
                input.OutPrint(phoneBooks.get(i).toString());
                matches = true;
            }
            //kep in mind that this might have some unintended consequences
            else if (matcher.find()) {
                input.OutPrint(phoneBooks.get(i).toString());
                matches = true;
            }
        }
        if(!matches){
            input.OutPrint("could not find the person you wer searching for\n\n");
            PrintAllContacts();
        }
    }
    public void RemovePhoneBook(int profile){
        if(!adminPerms){
            input.OutPrint("you have to login before you can remove");
            Login(input.Question("login password(password): "));
        }
        if(adminPerms){
            phoneBooks.remove(profile);
        }
    }
    public void ChangeContact(int profile){ //probably same problem as "row 28"
        if(!adminPerms){
            input.OutPrint("you have to login before you can change");
            Login(input.Question("login password(password): "));
        }
        if(adminPerms) {
            List<String> phoneNumbers = new ArrayList<>();
            boolean isDone = false;

            PhoneBook userProfile = phoneBooks.get(profile);
            String response = input.Question("what do you want to change on\n" +
                    " (name/full name, age, adress or phone number)\n" + userProfile);
            switch (response.toLowerCase()) {
                case "full name":
                case "name":
                    userProfile.setName(input.Question("what is your new name:"));
                    userProfile.setLastName(input.Question("what is your new last name:"));
                    break;

                case "age":
                    userProfile.setYearsOld(input.QuestionInt("what is your new age:"));
                    break;

                case "adress":
                    adress.City(input.Question("what is your new Adress (City):"));
                    adress.PostalCode(input.QuestionInt("what is your new Adress (postal Code):"));
                    adress.StreetName(input.Question("what is your new Adress (street name):"));
                    adress.Port(input.Question("what is your new Adress (port):"));
                    userProfile.setAdress(adress.Build());
                    break;

                case "phone number":
                    phoneNumbers.add(input.Question("what is your new phone number:"));
                    while (!isDone) {
                        String answer = input.Question("do you have another phone number (yes:no):");
                        if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                            isDone = true;
                            break;
                        }
                        phoneNumbers.add(input.Question("phone number:"));
                    }
                    userProfile.setPhoneNumbers(phoneNumbers);
                    break;
                default:
                    ChangeContact(profile);
            }
        }
    }
}
