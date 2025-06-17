import java.util.ArrayList;
import java.util.Scanner;


class Contact {
    String name;
    String mobile;
    String email;

    
    Contact(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Mobile: " + mobile);
        System.out.println("Email: " + email);
        System.out.println("-------------------------");
    }
}


public class ContactBook {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Contact Book Menu =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    String mobile = scanner.nextLine();
                    System.out.print("Enter Email ID: ");
                    String email = scanner.nextLine();

                    contacts.add(new Contact(name, mobile, email));
                    System.out.println("Contact added successfully!\n");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.\n");
                    } else {
                        System.out.println("\n===== Contact List =====");
                        for (Contact c : contacts) {
                            c.display();
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
