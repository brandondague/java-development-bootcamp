public class WorkSchedule {
    public static void main(String[] args) {
        int day = 3;  
        boolean holiday = true;
         
        // if it's a holiday, print: "woohoo, no work!");
        if (holiday) {
            System.out.println("Woohoo, no work!");
        }
        // if it's the weekend, print: "it's the weekend, no work!"
        else if (day == 6 || day == 7) {
            System.out.println("It's the weekend, no work!");
        }
        // otherwise, print: "Wake up at 7:00 :( ";
        else {
            System.out.println("Wake up at 7:00 :(");
        }
        }

    }
