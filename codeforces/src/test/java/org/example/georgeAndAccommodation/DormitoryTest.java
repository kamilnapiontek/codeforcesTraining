package org.example.georgeAndAccommodation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DormitoryTest {
    Dormitory dormitory = new Dormitory();

    @Test
    void shouldReturn0AvailableRoomsWhenThreeRoomsAreFull() {
        //given
        List<Room> rooms = List.of(
                new Room(1, 1),
                new Room(2, 2),
                new Room(3, 3));
        //when
        int availableRooms = dormitory.calculateAvailableRoomsFor2(rooms);
        //then
        Assertions.assertEquals(0, availableRooms);
    }

    @Test
    void shouldReturn2AvailableRoomsWhenTwoOutOfThreeRoomsHaveTheRequiredSpace() {
        //given
        List<Room> rooms = List.of(
                new Room(1, 10),
                new Room(0, 10),
                new Room(10, 10));
        //when
        int availableRooms = dormitory.calculateAvailableRoomsFor2(rooms);
        //then
        Assertions.assertEquals(2, availableRooms);
    }

}