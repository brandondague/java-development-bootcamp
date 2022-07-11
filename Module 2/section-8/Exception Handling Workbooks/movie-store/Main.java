import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {

    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {
            loadMovies("movies.txt");
            System.out.println(store);
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("PROCESS COMPLETE");
        }
        

    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please make a selection: \n" +
                               "a) view catalouge\n" +
                               "b) purchase\n" +
                               "c) rent\n" +
                               "d) return\n" +
                               "x) exit\n");
            char choice = scanner.nextLine().charAt(0);
            String name;
            switch (choice) {
                case 'a': System.out.println(store);
                          break;
                case 'b': System.out.print("name: ");
                          name = scanner.nextLine();
                          store.action(name, "sell");
                          break;
                case 'c': System.out.print("name: ");
                          name = scanner.nextLine();
                          store.action(name, "rent");
                          break;
                case 'd': System.out.print("name: ");
                          name = scanner.nextLine();
                          store.action(name, "return");
                          break;
                case 'x': System.out.print("exiting");
                          break;
                default:  break;
            }
            if (choice == 'x') {
                break;
            }
        }
        scanner.close();
    }


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner fileScanner = new Scanner(fis);
        while (fileScanner.hasNextLine()) {
            String[] parsedLine = fileScanner.nextLine().split("--");
            Movie movie = new Movie(parsedLine[0], parsedLine[1], Double.parseDouble(parsedLine[2]));
            store.addMovie(movie);
        }
        fileScanner.close();
    }

}
