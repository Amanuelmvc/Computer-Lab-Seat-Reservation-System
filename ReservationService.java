import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private final List<Seat> seats = new ArrayList<>();

    public ReservationService(int seatCount) {
        for (int number = 1; number <= seatCount; number++) {
            seats.add(new Seat(number));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat(int seatNumber, String studentName) {
        Seat seat = findSeat(seatNumber);
        return seat != null && seat.reserve(studentName);
    }

    public boolean cancelReservation(int seatNumber) {
        Seat seat = findSeat(seatNumber);
        return seat != null && seat.cancelReservation();
    }

    private Seat findSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.size()) {
            return null;
        }
        return seats.get(seatNumber - 1);
    }
}
