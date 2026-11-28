public class Seat {
    private final int number;
    private String studentName;

    public Seat(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean isReserved() {
        return studentName != null;
    }

    public boolean reserve(String studentName) {
        if (isReserved() || studentName == null || studentName.trim().isEmpty()) {
            return false;
        }
        this.studentName = studentName.trim();
        return true;
    }

    public boolean cancelReservation() {
        if (!isReserved()) {
            return false;
        }
        studentName = null;
        return true;
    }
}