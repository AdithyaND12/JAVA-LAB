public class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(int seatNumber) {
        super("Seat " + seatNumber + " is already booked.");
    }
}
