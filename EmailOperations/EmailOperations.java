import java.util.Scanner;

public class EmailOperations {
    private static final String VALID_DOMAIN = "bmsce.ac.in";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a student's email address: ");
        String enteredEmail = scanner.nextLine();
        String email = enteredEmail.trim();

        System.out.println("Email length: " + enteredEmail.length());
        System.out.println("Trimmed email: " + email);

        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex == email.length() - 1
                || atIndex != email.lastIndexOf('@')) {
            System.out.println("The entered value is not a valid email address.");
            return;
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        String lowercaseEmail = email.toLowerCase();

        System.out.println("Username: " + username);
        System.out.println("Domain: " + domain);
        System.out.println("Belongs to BMSCE: " + domain.equalsIgnoreCase(VALID_DOMAIN));
        System.out.println("Lowercase email: " + lowercaseEmail);

        System.out.print("Enter a prefix to check: ");
        String prefix = scanner.nextLine().trim();
        System.out.println(email.startsWith(prefix)
                ? "Email starts with the given prefix."
                : "Email does not start with the given prefix.");

        System.out.println("Ends with " + VALID_DOMAIN + ": "
                + lowercaseEmail.endsWith(VALID_DOMAIN));
        System.out.println("Email with updated domain: "
                + lowercaseEmail.replace(VALID_DOMAIN, "cse.bmsce.ac.in"));

        System.out.print("Enter a character or sequence to find: ");
        String sequence = scanner.nextLine();
        System.out.println(email.contains(sequence)
                ? "Email contains \"" + sequence + "\"."
                : "Email does not contain \"" + sequence + "\".");

        System.out.print("Enter another email address to compare: ");
        String secondEmail = scanner.nextLine().trim();
        System.out.println("Email addresses are identical (ignoring case): "
                + email.equalsIgnoreCase(secondEmail));
    }
}
