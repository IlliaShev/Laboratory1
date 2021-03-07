package com.labaratory1.comparators;

import com.labaratory1.abstractions.Student;

import java.util.Comparator;

/**
 * Interface StudentNameComparator
 */
public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
