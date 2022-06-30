import java.util.Scanner;

public class CountingTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        /*Task 1 – Choose a number

            Ask: Hi Timmy! Choose a number to count to: 

            Make sure Timmy can enter the value BESIDE the question. 
        */
        System.out.print("Hello! Choose a number to count to: ");
        int number = scan.nextInt();

        /* Task 2 – Count from 0 to that number

             Let's say Timmy entered 5, you would display: 0 1 2 3 4 5 

        */
        for (int x = 0; x <= number; x++) {
            System.out.print(x + " ");
        }

        System.out.println();

        scan.close();
    }
}
