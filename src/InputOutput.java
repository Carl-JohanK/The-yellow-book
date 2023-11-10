import java.util.Scanner;

public class InputOutput {
    Scanner scan = new Scanner(System.in);
    public String Question(String question){
        System.out.println(question);
        String response = scan.nextLine();
        return response;
    }
    public int QuestionInt(String question) {
        int response = 0;
        try {
            response = Integer.parseInt(Question(question));
        } catch (NumberFormatException e) {
            QuestionInt("that is not a number try a new number:");
        }

        return response;
    }
    public void OutPrint(String text){
        System.out.println(text);
    }
}
