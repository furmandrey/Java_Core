package ru.geekbrains.lesson9;

import java.util.List;
import java.util.stream.Collectors;

public class HomeWork {

    public static void main(String[] args) {
        List<Student> students = Data.getStudentsList();
        Course randomCourse = Data.getRandomCourse();
        System.out.println(getUnicsCourses(students));
        System.out.println(inquisitiveStudents(students));
        System.out.println(getStudentsFromCourse(students, randomCourse));

        System.out.println(getStudentsWithGivenQtyOfCourses(students, 4));
    }

    // 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
    public static List<Course> getUnicsCourses(List<Student> students) {
        System.out.print("*1* Unique courses:  ");
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
    public static List<Student> inquisitiveStudents (List<Student> students) {
        System.out.print("*2* Most inquisitive students:  ");
        return students.stream()
                .sorted((s1, s2) -> (s2.getAllCourses().size()) - (s1.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }
    //****
    public static List<Student> getStudentsWithGivenQtyOfCourses(List<Student> students, int q) {
        System.out.print("* The list of the students taking " + q + " or more courses at the same time: ");
        return students.stream()
                .filter(student -> student.getAllCourses().size() >= q)
                .collect(Collectors.toList());
    }


    // 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
    public static List<Student> getStudentsFromCourse(List<Student> students, Course course) {
        System.out.print("*3* The list of students taking the course " + "'" + course + "' :");
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }

}

