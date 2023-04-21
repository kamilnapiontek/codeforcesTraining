package org.example.boringApartments;

public class BoringApartments {
    // https://codeforces.com/problemset/problem/1433/A
    public int getNumberOfClick(int lastApartmentNumber) {

        if (lastApartmentNumber <= 0 || lastApartmentNumber >= 10000) {
            throw new IllegalStateException("There is no such apartment.");
        }

        int totalClicks = 0;
        int apartmentNumber = 1;
        int baseNumber = 1;
        int howManyDigits = 1;

        while (apartmentNumber != lastApartmentNumber) {
            totalClicks += howManyDigits;
            apartmentNumber = apartmentNumber * 10 + baseNumber;
            howManyDigits++;
            if (howManyDigits == 5) {
                baseNumber++;
                apartmentNumber = baseNumber;
                howManyDigits = 1;
            }
        }
        return totalClicks + howManyDigits;
    }
}

