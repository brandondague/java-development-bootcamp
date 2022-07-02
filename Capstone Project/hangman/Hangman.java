import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {
    "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = getRandomWord();
        char[] puzzle = generatePuzzle(word);
        char guess = ' ';
        int misses = 0;
        Stack<Character> missedGuesses = new Stack<Character>();

        while (true) {
            printBoard(misses, missedGuesses, puzzle);
            guess = scan.next().charAt(0);
            Stack<Integer> guessIndexes = makeGuess(guess, word);
            if (guessIndexes.size() > 0) {
                for (int i = 0; i < guessIndexes.size(); i++) {
                    puzzle[guessIndexes.get(i)] = guess;
                }
            } else {
                char duplicateLetter = verifyGuess(guess, missedGuesses);
                if (duplicateLetter == ' ') {
                    System.out.println("\nYou already guessed that letter");
                } else {
                    missedGuesses.push(guess);
                    misses += 1;
                }
            }
            int gameStatus = checkGameStatus(puzzle, misses);
            if (gameStatus == 1) {
                printBoard(misses, missedGuesses, puzzle);
                System.out.println("\n\nOut of guesses. You lose");
                break;
            } else if (gameStatus == 2) {
                printBoard(misses, missedGuesses, puzzle);
                System.out.println("\n\nCongratulations! You guessed the right word.");
                break;
            }
        }
        
        scan.close();
        System.exit(0);
    }

    public static String getRandomWord() {
        int randomNumber = (int)(Math.random() * words.length);
        return words[randomNumber];
    }

    public static char[] generatePuzzle(String word) {
        char[] puzzle = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            puzzle[i] = '_';
        }
        return puzzle;
    }

    public static void printGallows(int misses) {
        System.out.println("\n" + gallows[misses]);
    }

    public static void printPuzzle(char[] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            System.out.print(puzzle[i] + " ");
        }
    }

    public static void printBoard(int misses, Stack<Character> missedGuesses, char[] puzzle) {
        printGallows(misses);
        System.out.print("Word:\t");
        printPuzzle(puzzle);
        System.out.println("");
        System.out.print("\nMisses:\t");
        for (char letter : missedGuesses) {
            System.out.print(letter + " ");
        }
        System.out.println();
        System.out.print("\nGuess:\t");
    }

    public static Stack<Integer> makeGuess(char guess, String word) {
        char[] wordArray = word.toCharArray();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == guess) {
                st.push(i);
            }
        }
        return st;
    }

    public static char verifyGuess(char guess, Stack<Character> missedGuesses) {
        for (char letter : missedGuesses) {
            if (letter == guess) {
                return ' ';
            }
        }
        return guess;
    }

    public static int checkGameStatus(char[] puzzle, int misses) {
        if (misses == 6) {
            return 1;
        }
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == '_') {
                return 0;
            }
        }
        return 2;
    }

}





