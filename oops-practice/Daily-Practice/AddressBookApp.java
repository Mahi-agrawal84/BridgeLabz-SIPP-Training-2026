import java.util.*;

class Contact {
    private final String name;
    private final String phone;
    private final String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name  : " + name +
               "\nPhone : " + phone +
               "\nEmail : " + email;
    }
}

public class AddressBookApp {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final HashMap<String, Contact> contactMap = new HashMap<>();
    private final HashSet<String> phoneNumbers = new HashSet<>();

    // Add Contact
    public void addContact(String name, String phone, String email) {
        if (contactMap.containsKey(name)) {
            System.out.println("Contact with this name already exists.");
            return;
        }

        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number not allowed.");
            return;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        contactMap.put(name, contact);
        phoneNumbers.add(phone);

        System.out.println("Contact added successfully.");
    }

    // Search Contact
    public void searchContact(String name) {
        Contact contact = contactMap.get(name);

        if (contact != null) {
            System.out.println("\nContact Found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Delete Contact
    public void deleteContact(String name) {
        Contact contact = contactMap.remove(name);

        if (contact != null) {
            contacts.remove(contact);
            phoneNumbers.remove(contact.getPhone());
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Display Contacts Sorted by Name
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Collections.sort(contacts, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        System.out.println("\n Contact List ");
        for (Contact c : contacts) {
            System.out.println(c);
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AddressBookApp book = new AddressBookApp();

            int choice;

            do {
                System.out.println("\n Address Book Menu ");
                System.out.println("1. Add Contact");
                System.out.println("2. Search Contact");
                System.out.println("3. Delete Contact");
                System.out.println("4. Display All Contacts");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        book.addContact(name, phone, email);
                    }

                    case 2 -> {
                        System.out.print("Enter Name to Search: ");
                        String name = sc.nextLine();
                        book.searchContact(name);
                    }

                    case 3 -> {
                        System.out.print("Enter Name to Delete: ");
                        String name = sc.nextLine();
                        book.deleteContact(name);
                    }

                    case 4 -> book.displayContacts();

                    case 5 -> System.out.println("Exiting...");

                    default -> System.out.println("Invalid choice.");
                }

            } while (choice != 5);
        }
    }
}