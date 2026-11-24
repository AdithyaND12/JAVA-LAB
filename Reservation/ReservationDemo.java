import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reservation reservation = new Reservation();

        for (int attempt = 1; attempt <= 3; attempt++) {
            boolean successful = false;
            System.out.print("Attempt " + attempt + " - enter a seat number (1-5): ");
            try {
                int seatNumber = scanner.nextInt();
                reservation.reserveSeat(seatNumber);
                successful = true;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input: enter a whole-number seat number.");
                scanner.next();
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid seat number: " + exception.getMessage());
            } catch (SeatAlreadyBookedException exception) {
                System.out.println(exception.getMessage());
            } finally {
                System.out.println("Transaction completed: "
                        + (successful ? "successful." : "unsuccessful."));
            }
        }
    }
}
