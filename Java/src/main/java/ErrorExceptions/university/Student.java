package ErrorExceptions.university;

import ErrorExceptions.university.exceptions.StudentHasNoSubjectsException;

import java.util.List;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private List<Subject> subjects;

    public Student(String firstName, String lastName, List<Subject> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public List<Subject> getSubjects() throws StudentHasNoSubjectsException {
        if (subjects.isEmpty()) {
            throw new StudentHasNoSubjectsException("The student has no subjects (must have at least one)");
        } else {
            return this.subjects;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                subjects.equals(student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, subjects);
    }

    public String toString() {
        return "Student{firstName='" + this.firstName + "', lastName='" + this.lastName + "', subjects=" + this.subjects + "}";
    }
}