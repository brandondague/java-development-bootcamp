import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.Contact;
import models.ContactManager;

public class Main {

    static ContactManager contactList = new ContactManager();
    public static void main(String[] args) {


        try {
            loadContacts("contacts.txt");
            System.out.println("CONTACTS LOADED\n\n");
            System.out.println("manager");
            manageContacts();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nPROCESS COMPLETE");
        }

    
    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */
    public static void manageContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your contacts manager");
        while (true) {
            System.out.println("Please type the letter corresponding to your choice,"
                               + "\na) add a contact"
                               + "\nb) remove a contact"
                               + "\nc) print contacts"
                               + "\nd) exit");
            char choice = scanner.nextLine().toLowerCase().trim().charAt(0);
            String name;
            switch (choice) {
                case 'a': System.out.println("Please enter the following information,");
                          System.out.print("Name: ");
                          name = scanner.nextLine().trim();
                          System.out.print("Phone number: ");
                          String phoneNumber = scanner.nextLine().trim();
                          System.out.print("Birth date: ");
                          String birthDate = scanner.nextLine().trim();
                          try {
                            contactList.addContact(new Contact(name, birthDate, phoneNumber));
                          } catch (ParseException e) {
                            System.out.println(e.getMessage());
                          }
                          break;
                case 'b': System.out.print("Please enter who you would like to remove: ");
                          name = scanner.nextLine().trim();
                          contactList.removeContact(name);
                          break;
                case 'c': System.out.println(contactList);
                          break;
                case 'd': System.out.println("Exiting contacts manager");
                          break;
                default:  break;
            }
            if (choice == 'd') {
                break;
            }
        }
        scanner.close();
    }



    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */
    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner fileScanner = new Scanner(fis);
        while (fileScanner.hasNextLine()) {
            try {
                Contact contact = new Contact(fileScanner.next(), fileScanner.next(), fileScanner.next());
                contactList.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        fileScanner.close();
    }

}
