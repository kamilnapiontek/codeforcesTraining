package org.example.georgeAndAccommodation;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Dormitory {
    // https://codeforces.com/problemset/problem/467/A
    public int calculateAvailableRoomsFor2(List<Room> rooms) {
        AtomicInteger numberOfAvailableRoomsFor2People = new AtomicInteger();
        rooms.forEach(room -> {
            if (room.getMaxCapacity() - room.getAccommodatedPeople() >= 2)
                numberOfAvailableRoomsFor2People.getAndIncrement();
        });
        return numberOfAvailableRoomsFor2People.get();
    }
}
