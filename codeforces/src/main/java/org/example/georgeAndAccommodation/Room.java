package org.example.georgeAndAccommodation;

class Room {
    private final int accommodatedPeople;
    private final int maxCapacity;

    Room(int howManyPeopleAccommodated, int maxCapacity) {
        this.accommodatedPeople = howManyPeopleAccommodated;
        this.maxCapacity = maxCapacity;
    }

    public int getAccommodatedPeople() {
        return accommodatedPeople;
    }

    int getMaxCapacity() {
        return maxCapacity;
    }
}
