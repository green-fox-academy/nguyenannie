package reservations;

import java.util.ArrayList;
import java.util.List;

class ReservationsRecord {
    List<Reservations> record;

    ReservationsRecord() {
        record = new ArrayList<>();
    }

    void add(int numberOfReservations) {
        for(int i = 0; i < numberOfReservations; i++) {
            record.add(new Reservations());
        }
    }
}
