// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UserPermissions userAccess = new UserPermissions(); //you can add more users
        InputOutput input = new InputOutput(); //inputOutput is not a good name
        boolean isDone = false;
        while (!isDone){
            int answer = input.QuestionInt("What do you want to do?\n" +
                    "1: Add a contact\n2: Search/view contacts" +
                    "\n3: Update existing contacts\n4: Delete contact" +
                    "\n5: Exit");
            switch (answer){
                case 1:
                    userAccess.AddContact();
                    break;
                case 2:
                    userAccess.ViewPhoneBook(input.Question("What (name, last name, street name)\n" +
                            "Do you want to search for:"));
                    break;
                case 3:
                    userAccess.PrintAllContacts();
                    userAccess.ChangeContact(input.QuestionInt(
                            "Witch profile do you want to change") - 1);
                    break;
                case 4:
                    userAccess.PrintAllContacts();
                    userAccess.RemovePhoneBook(input.QuestionInt(
                            "witch profile do you want to delete") - 1);
                    break;
                case 5:
                    isDone = true;
                    break;
                default:
                    input.OutPrint("That is not an available option");
            }
        }
    }
}