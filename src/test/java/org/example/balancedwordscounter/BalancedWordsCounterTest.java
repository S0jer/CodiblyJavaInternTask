package org.example.balancedwordscounter;

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


class BalancedWordsCounterTest {

    @ParameterizedTest
    @MethodSource("properInputsProvider")
    void shouldCheckProperCounterResults(String input, Integer expectedResult) {
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();

        Integer actualResult = balancedWordsCounter.count(input);

        assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @MethodSource("errorInputsProvider")
    void shouldCheckProperErrorReturn(String input) {
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();
        String expectedMessage = "Wrong string argument!";

        Exception exception = assertThrows(RuntimeException.class, () -> balancedWordsCounter.count(input));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


    static Stream<Arguments> properInputsProvider() {
        List<String> inputs = new ArrayList<>(Arrays.asList("aabbabcccba", ""));
        List<Integer> expectedResults = new ArrayList<>(Arrays.asList(28, 0));


        return Stream.of(arguments(inputs.get(0), expectedResults.get(0)),
                arguments(inputs.get(1), expectedResults.get(1)));
    }


    static Stream<Arguments> errorInputsProvider() {
        List<String> inputs = new ArrayList<>(Arrays.asList("abababa1", null));

        return Stream.of(arguments(inputs.get(0)),
                arguments(inputs.get(1)));
    }
}