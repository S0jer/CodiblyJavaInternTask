package org.example.bubblesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BubbleSort implements Sort, Comparable<BubbleSort> {
    public List<Comparable> sort(List<Comparable> input) {
        if (input == null) {
            throw new RuntimeException("Wrong argument!");
        }

        input = input.stream().filter(Objects::nonNull).toList();
        List<Comparable> comparableList = new ArrayList<>(input);
        boolean notSorted = true;

        while (notSorted) {
            notSorted = false;
            for (int j = 1; j < comparableList.size(); j++) {
                ToCompareValues toCompareValues = setTypeOfVariable(comparableList, j);
                if (toCompareValues.x().compareTo(toCompareValues.y()) >= 1) {
                    swapElements(comparableList, j);
                    notSorted = true;
                }
            }
        }
        return comparableList;
    }

    private void swapElements(List<Comparable> comparableList, int j) {
        Comparable tmp = comparableList.get(j - 1);
        comparableList.set(j - 1, comparableList.get(j));
        comparableList.set(j, tmp);
    }

    private ToCompareValues setTypeOfVariable(List<Comparable> comparableList, int j) {
        if (comparableList.get(j - 1) instanceof Integer && comparableList.get(j) instanceof Double) {
            return new ToCompareValues(IntegerToDouble(comparableList.get(j - 1)), comparableList.get(j));
        } else if (comparableList.get(j) instanceof Integer && comparableList.get(j - 1) instanceof Double) {
            return new ToCompareValues(comparableList.get(j - 1), IntegerToDouble(comparableList.get(j)));
        }
        return new ToCompareValues(comparableList.get(j - 1), comparableList.get(j));
    }

    private double IntegerToDouble(Comparable value) {
        return Double.parseDouble(value.toString());
    }

    @Override
    public int compareTo(BubbleSort o) {
        return 0;
    }
}
