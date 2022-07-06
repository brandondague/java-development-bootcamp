//import Scanner
import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        
        //set up scanner.
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello. What is your name?");
        //Pick up user's name and store it.
        String userName = scan.nextLine();

                           
        //add new a line before asking next question. 
        System.out.println("Hi " + userName + "! I'm Javabot. Where are you from?");
        //Pick up user's home and store it.
        String userLocation = scan.nextLine();
                        

        //add new a line before asking next question.
        System.out.println("I hear it's beautiful at " + userLocation + "! I'm from a place called Oracle");
        System.out.println("How old are you?");
        //Pick up age and store it.
        int userAge = scan.nextInt();


        //add new a line before asking next question.
        System.out.println("So you're " + userAge + ", cool! I'm 400 years old.");
        System.out.println("This means I'm " + (400 / userAge) + " times older than you.");
        System.out.println("Enough about me. What's your favourite language? (just don't say Python)");
        //Pick up language and store it.
        scan.nextLine();
        String favoriteLanguage = scan.nextLine();


        //add new a line here.
        System.out.println(favoriteLanguage + ", that's great! Nice chatting with you " + userName + ". I have to log off now. See ya!");
        
        //close scanner. 
        scan.close();
        
    }
}
