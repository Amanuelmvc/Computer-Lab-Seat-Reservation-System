import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ReservationService reservations = new ReservationService(10);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\nComputer Lab Seat Reservation");
                System.out.println("1. View seats");
                System.out.println("2. Reserve a seat");
                System.out.println("3. Cancel a reservation");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        showSeats(reservations);
                        break;
                    case "2":
                        reserveSeat(scanner, reservations);
                        break;
                    case "3":
                        cancelReservation(scanner, reservations);
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("Please choose 1, 2, 3, or 4.");
                }
            }
        }
        System.out.println("Goodbye.");
    }

    private static void showSeats(ReservationService reservations) {
        for (Seat seat : reservations.getSeats()) {
            String status = seat.isReserved()
                    ? "Reserved by " + seat.getStudentName()
                    : "Available";
            System.out.println("Seat " + seat.getNumber() + ": " + status);
        }
    }

    private static void reserveSeat(Scanner scanner, ReservationService reservations) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        int seatNumber = readSeatNumber(scanner);
        if (seatNumber == -1) {
            return;
        }

        if (reservations.reserveSeat(seatNumber, name)) {
            System.out.println("Seat " + seatNumber + " reserved for " + name.trim() + ".");
        } else {
            System.out.println("That seat is unavailable, or the name is empty.");
        }
    }

    private static void cancelReservation(Scanner scanner, ReservationService reservations) {
        int seatNumber = readSeatNumber(scanner);
        if (seatNumber == -1) {
            return;
        }

        if (reservations.cancelReservation(seatNumber)) {
            System.out.println("Reservation cancelled.");
        } else {
            System.out.println("No reservation was found for that seat.");
        }
    }

    private static int readSeatNumber(Scanner scanner) {
        System.out.print("Enter seat number (1-10): ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a whole number.");
            return -1;
        }
    }
}
