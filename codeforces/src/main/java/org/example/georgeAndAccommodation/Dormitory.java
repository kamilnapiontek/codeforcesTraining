package org.example.georgeAndAccommodation;

import java.util.List;

public class Dormitory {
    // https://codeforces.com/problemset/problem/467/A
    public int calculateAvailableRoomsFor2(List<Room> rooms) {
        int numberOfAvailableRoomsFor2People = 0;
        for (Room room : rooms) {
            if (room.getMaxCapacity() - room.getAccommodatedPeople() >= 2)
                numberOfAvailableRoomsFor2People++;
        }
        return numberOfAvailableRoomsFor2People;
    }
}
