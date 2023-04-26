package org.example.jumpGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class JumpGameTest {
    private final JumpGame jumpGame = new JumpGame();

    @ParameterizedTest
    @MethodSource("correctData")
    void shouldReturnMinimumJumpsToPassTheTable(List<Integer> listToJump, int result) {
        //when
        int minimumJumps = jumpGame.minimumJumps(listToJump);
        //then
        Assertions.assertEquals(result, minimumJumps);

    }

    private static Stream<Arguments> correctData() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 1, 1, 4), 2),
                Arguments.of(List.of(2, 3, 0, 1, 4), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionData")
    void shouldContainExceptionWhenTheListCannotBeSkipped(List<Integer> listToJump) {
        // when
        Assertions.assertThrows(IllegalStateException.class, () -> {
            jumpGame.minimumJumps(listToJump);
        });
    }

    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 0, 0, 0, 0, 0, 5)),
                Arguments.of(List.of(2, 1, 0, 5, 2))
        );
    }
}