package org.example.boringApartments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoringApartmentsTest {
    private final BoringApartments boringApartments = new BoringApartments();

    @Test
    void shouldReturn13ClicksForApartmentWithNumber22() {
        // given
        int lastApartmentNumber = 22;
        // when
        int result = boringApartments.getNumberOfClick(lastApartmentNumber);
        // then
        Assertions.assertEquals(13, result);
    }

    @Test
    void shouldReturn90ClicksForApartmentWithNumber9999() {
        // given
        int lastApartmentNumber = 9999;
        // when
        int result = boringApartments.getNumberOfClick(lastApartmentNumber);
        // then
        Assertions.assertEquals(90, result);
    }

    @Test
    void shouldReturn1ClickForApartmentWithNumber1() {
        // given
        int lastApartmentNumber = 1;
        // when
        int result = boringApartments.getNumberOfClick(lastApartmentNumber);
        // then
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldReturn66ClicksForApartmentWithNumber777() {
        // given
        int lastApartmentNumber = 777;
        // when
        int result = boringApartments.getNumberOfClick(lastApartmentNumber);
        // then
        Assertions.assertEquals(66, result);
    }

    @Test
    void shouldContainExceptionWhenApartmentNumberIsBelow1() {
        // given
        int lastApartmentNumber = 0;
        // when
        Assertions.assertThrows(IllegalStateException.class, () -> {
            boringApartments.getNumberOfClick(lastApartmentNumber);
        });
    }

    @Test
    void shouldContainExceptionWhenApartmentNumberIsBiggerThan9999WithMessage() {
        // given
        int lastApartmentNumber = 10000;
        // when
        Assertions.assertThrows(IllegalStateException.class, () -> {
            boringApartments.getNumberOfClick(lastApartmentNumber);
        }, "There is no such apartment.");
    }
}