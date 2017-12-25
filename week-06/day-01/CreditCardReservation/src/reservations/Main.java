package reservations;

public class Main {
    public static void main(String[] args) {
        int numberOfReservations = 8;
        ReservationsRecord reservationsRecord = new ReservationsRecord();
        reservationsRecord.add(numberOfReservations);

        for(int i = 0; i < reservationsRecord.record.size(); i++) {
            reservationsRecord.record.get(i).formatPrintOut();
        }
    }
}
