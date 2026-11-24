class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private final double price;
    private static int totalBooks;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        totalBooks++;
    }

    public void display() {
        System.out.printf("Book ID: %d%nTitle: %s%nAuthor: %s%nPrice: Rs. %.2f%n",
                bookId, title, author, price);
    }

    public static Book search(Book[] books, int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                return book;
            }
        }
        return null;
    }

    public static Book search(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book costlierBook(Book other) {
        return price >= other.price ? this : other;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}

public class BookDemo {
    private static void displaySearchResult(Book book) {
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            book.display();
        }
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(101, "Java Basics", "R. Kumar", 450.00),
                new Book(102, "Data Structures", "A. Rao", 620.00),
                new Book(103, "Operating Systems", "M. Shah", 550.00)
        };

        System.out.println("All books");
        for (Book book : books) {
            book.display();
            System.out.println();
        }

        System.out.println("Search by Book ID (102)");
        displaySearchResult(Book.search(books, 102));

        System.out.println("\nSearch by title (Java Basics)");
        displaySearchResult(Book.search(books, "Java Basics"));

        System.out.println("\nCostlier of the first two books");
        books[0].costlierBook(books[1]).display();

        System.out.println("\nTotal books created: " + Book.getTotalBooks());
    }
}
