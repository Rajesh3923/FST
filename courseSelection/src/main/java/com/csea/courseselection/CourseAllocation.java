package com.csea.courseselection;

public class CourseAllocation {

    // Fetch course details by course ID
    public Course getCourse(int courseId) {
        // Example hardcoded data
        if (courseId == 101) {
            return new Course(101, "Java Programming", "Computer Science");
        } else if (courseId == 102) {
            return new Course(102, "Database Management", "Information Technology");
        } else if (courseId == 103) {
            return new Course(103, "Data Structures", "Computer Science");
        }
        // Return null if the course ID is invalid
        return null;
    }
}

