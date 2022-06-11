package org.example.bubblesort;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BubbleSortTest {

    @Test
    void shouldCheckIfBubbleSortThrowExceptionForNull() {
        BubbleSort bubbleSort = new BubbleSort();
        String expectedMessage = "Wrong argument!";

        Exception exception = assertThrows(RuntimeException.class, () -> bubbleSort.sort(null));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @MethodSource("comparableListToSortProvider")
    void shouldCheckIfBubbleSortComparableList(List<Comparable> toSortList, List<Comparable> expectedSortedList, boolean expectedResult) {
        BubbleSort bubbleSort = new BubbleSort();

        toSortList = bubbleSort.sort(toSortList);

        assertEquals(expectedResult, toSortList.equals(expectedSortedList));
    }


    static Stream<Arguments> comparableListToSortProvider() {
        List<List<Comparable>> testInputs = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 4, 5, 6, 8, 3, 8)),
                new ArrayList<>(Arrays.asList(-9.3, 0.2, 4, 0.1, 5, 9)),
                new ArrayList<>(List.of()),
                new ArrayList<>(Arrays.asList(null, 5.0001))
        ));

        List<List<Comparable>> expectedResults = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 8, 8)),
                new ArrayList<>(Arrays.asList(-9.3, 0.1, 0.2, 4, 5, 9)),
                new ArrayList<>(List.of()),
                new ArrayList<>(List.of(5.0001))
        ));

        return Stream.of(arguments(testInputs.get(0), expectedResults.get(0), true),
                arguments(testInputs.get(1), expectedResults.get(1), true),
                arguments(testInputs.get(2), expectedResults.get(2), true),
                arguments(testInputs.get(3), expectedResults.get(3), true),
                arguments(testInputs.get(0), expectedResults.get(1), false),
                arguments(testInputs.get(2), expectedResults.get(1), false),
                arguments(testInputs.get(3), expectedResults.get(0), false),
                arguments(testInputs.get(2), expectedResults.get(3), false)
        );
    }
}