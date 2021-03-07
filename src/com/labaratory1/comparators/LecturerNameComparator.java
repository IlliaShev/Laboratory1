package com.labaratory1.comparators;

import com.labaratory1.abstractions.Lecturer;

import java.util.Comparator;

/**
 * Interface LecturerNameComparator
 */
public class LecturerNameComparator implements Comparator<Lecturer> {
    @Override
    public int compare(Lecturer o1, Lecturer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
