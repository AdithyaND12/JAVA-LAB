public class Reservation {
    private static final int TOTAL_SEATS = 5;
    private final boolean[] bookedSeats = new boolean[TOTAL_SEATS + 1];

    public void reserveSeat(int seatNumber) throws SeatAlreadyBookedException {
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            throw new IllegalArgumentException(
                    "Seat number must be between 1 and " + TOTAL_SEATS + ".");
        }
        if (bookedSeats[seatNumber]) {
            throw new SeatAlreadyBookedException(seatNumber);
        }
        bookedSeats[seatNumber] = true;
        System.out.println("Seat " + seatNumber + " reserved successfully.");
    }
}
