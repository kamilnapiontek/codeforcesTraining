package org.example.jumpGame;

import java.util.List;

public class JumpGame {
    public int minimumJumps(List<Integer> listToJump) {

        if (!isJumpPossible(listToJump)) {
            throw new IllegalStateException("Jump is not possible.");
        }

        int currentIndex = 0;
        int jumpsToReturn = 0;
        int longestPossibleJump;
        int placeInArray;
        int difference = 0;

        while (impossibleFinalJump(listToJump, currentIndex)) {
            longestPossibleJump = 0;
            placeInArray = listToJump.get(currentIndex) - 1;
            for (int i = 1; i <= listToJump.get(currentIndex); i++) {
                if (longestPossibleJump < (listToJump.get(currentIndex + i) - placeInArray)) {
                    longestPossibleJump = listToJump.get(currentIndex + i - placeInArray);
                    difference = i;
                }
                placeInArray--;
            }
            currentIndex += difference;
            jumpsToReturn++;
        }
        return jumpsToReturn + 1;
    }

    private boolean impossibleFinalJump(List<Integer> listToJump, int currentIndex) {
        return listToJump.get(currentIndex) + currentIndex < listToJump.size() - 1;
    }

    private boolean isJumpPossible(List<Integer> list) {
        int howManyZerosInRow;
        int possibleZeroIndex;
        int extraSpace;
        boolean possibleJump;
        int currentIndex;
        if (list.get(0) == 0) return false;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == 0) {
                howManyZerosInRow = 1;
                possibleZeroIndex = i + 1;
                while (possibleZeroIndex < list.size() && list.get(possibleZeroIndex) == 0) {
                    howManyZerosInRow++;
                    possibleZeroIndex++;
                    if (possibleZeroIndex == list.size() - 1) break;
                }

                extraSpace = 0;
                possibleJump = false;
                currentIndex = i - 1;
                while (!possibleJump) {
                    if (list.get(currentIndex) - extraSpace > howManyZerosInRow) possibleJump = true;
                    else {
                        currentIndex--;
                        if (currentIndex == -1) return false;
                        extraSpace++;
                    }
                }

                i += howManyZerosInRow - 1;
            }
        }
        return true;
    }
}