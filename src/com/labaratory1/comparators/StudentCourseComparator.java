package com.labaratory1.comparators;

import com.labaratory1.abstractions.Student;

import java.util.Comparator;

/**
 * Interface StudentCourseComparator
 */
public class StudentCourseComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getCourse() - o2.getCourse();
    }
}
