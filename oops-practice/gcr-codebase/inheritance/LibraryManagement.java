// Superclass
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

// Subclass
class Author extends Book {
    private final String name;
    private final String bio;

    public Author(String title, int publicationYear,
                  String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Method to display book and author details
    public void displayInfo() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);

        System.out.println("\nAuthor Details:");
        System.out.println("Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Main Class
public class LibraryManagement {
    public static void main(String[] args) {

        Author author = new Author(
                "Java Programming",
                2024,
                "James Gosling",
                "Creator of the Java programming language"
        );

        author.displayInfo();
    }
}