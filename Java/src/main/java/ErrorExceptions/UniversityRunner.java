package ErrorExceptions;

import ErrorExceptions.university.*;
import ErrorExceptions.university.enums.FacultyName;
import ErrorExceptions.university.enums.SubjectName;
import ErrorExceptions.university.exceptions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniversityRunner {

    public static void main(String[] args) {

        List<Student> MA101 = null, MA102 = null, EC103 = null, H104 = null;

        try {
                MA101 = Arrays.asList(
                    new Student("John", "Smith", Arrays.asList(
                            new Subject(SubjectName.MATH, 4),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.HISTORY, 3),
                            new Subject(SubjectName.PHYSICS, 4))),
                    new Student("Abraham", "Jones", Arrays.asList(
                            new Subject(SubjectName.MATH, 4),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.HISTORY, 3),
                            new Subject(SubjectName.PHYSICS, 4))),
                    new Student("Paul", "Sullivan", Arrays.asList(
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.HISTORY, 3),
                            new Subject(SubjectName.PHYSICS, 3))),
                    new Student("Nicola", "Barrela", Arrays.asList(
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.HISTORY, 2),
                            new Subject(SubjectName.PHYSICS, 2))));

                MA102 = Arrays.asList(
                    new Student("Hira", "Malone", Arrays.asList(
                            new Subject(SubjectName.MATH, 4),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.HISTORY, 3),
                            new Subject(SubjectName.PHYSICS, 4))),
                    new Student("Lila", "Gardiner", Arrays.asList(
                            new Subject(SubjectName.MATH, 4),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.HISTORY, 3),
                            new Subject(SubjectName.PHYSICS, 4))),
                    new Student("Evan", "Doyle", Arrays.asList(
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.HISTORY, 3),
                            new Subject(SubjectName.PHYSICS, 3))),
                    new Student("Jarred", "Noel", Arrays.asList(
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.HISTORY, 2),
                            new Subject(SubjectName.PHYSICS, 2))));

                EC103 = Arrays.asList(
                    new Student("Garry", "Morris", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 4),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.PSYCHOLOGY, 4))),
                    new Student("Hana", "Shields", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 4),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.PHYSICS, 4))),
                    new Student("Zavier", "Franklin", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 3),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.PSYCHOLOGY, 3))),
                    new Student("Alexia", "Chavez", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 3),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.HISTORY, 2),
                            new Subject(SubjectName.PSYCHOLOGY, 2))));

                H104 = Arrays.asList(
                    new Student("Casey", "Salinas", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 4),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.PSYCHOLOGY, 4))),
                    new Student("Brooke", "Hutchings", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 4),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.PHYSICS, 4))),
                    new Student("Morgan", "Short", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 3),
                            new Subject(SubjectName.ENGLISH, 4),
                            new Subject(SubjectName.MATH, 3),
                            new Subject(SubjectName.PSYCHOLOGY, 3))),
                    new Student("Alexia", "Merritt", Arrays.asList(
                            new Subject(SubjectName.ECONOMICS, 3),
                            new Subject(SubjectName.ENGLISH, 3),
                            new Subject(SubjectName.HISTORY, 2),
                            new Subject(SubjectName.PSYCHOLOGY, 2))));

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        List<Faculty> faculties = Arrays.asList(
                new Faculty(FacultyName.MATHEMATIC, Arrays.asList(
                        new Group("MA101", MA101),
                        new Group("MA102", MA102))),
                new Faculty(FacultyName.ECONOMICS, Collections.singletonList(
                        new Group("EC103", EC103))),
                new Faculty(FacultyName.HISTORY, Collections.singletonList(
                        new Group("H104", H104))));

        University university = new University(faculties);

        try {
            System.out.printf("The average score for student %s is %.1f\n",
                    "John" + "Smith", university.calcAverageStudentGrade("John", "Smith"));

            System.out.printf("The average %s score in the %s Group  is %.1f\n",
                    SubjectName.MATH.getSubjectName(), "MA101", university
                            .calcAverageSubjectGradeInGroup("MA101", SubjectName.MATH));

            System.out.printf("The average %s score in the Faculty of %s is %.1f\n",
                    SubjectName.MATH.getSubjectName(), FacultyName.MATHEMATIC.getFacultyName(), university
                            .calcAverageSubjectGradeInFaculty(FacultyName.MATHEMATIC, SubjectName.MATH));

            System.out.printf("The average %s score in the university is %.1f\n",
                    SubjectName.ENGLISH.getSubjectName(), university
                            .calcAverageSubjectGradeInUniversity(SubjectName.ENGLISH));

        } catch (StudentHasNoSubjectsException | NoStudentsInGroupException |
                NoGroupsAtFacultyException | NoFacultiesAtUniversityException e) {
            e.printStackTrace();
        }
    }
}
