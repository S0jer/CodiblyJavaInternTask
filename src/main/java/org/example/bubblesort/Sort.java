package org.example.bubblesort;

import java.util.List;

@FunctionalInterface
public interface Sort {
    List<Comparable> sort(List<Comparable> toSortList);
}
