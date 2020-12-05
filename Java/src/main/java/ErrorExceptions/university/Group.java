package ErrorExceptions.university;

import ErrorExceptions.university.exceptions.NoStudentsInGroupException;

import java.util.List;
import java.util.Objects;

public class Group {
    private String name;
    private List<Student> students;

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return this.name;
    }

    public List<Student> getStudents() throws NoStudentsInGroupException {
        if (students.isEmpty()) {
            throw new NoStudentsInGroupException("Group " + getName() + " has no students");
        } else {
            return this.students;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Group)) {
            return false;
        } else {
            Group group = (Group) o;
            return this.name.equals(group.name) && this.students.equals(group.students);
        }
    }

    public int hashCode() {
        return Objects.hash(this.name, this.students);
    }

    public String toString() {
        return "Group{name='" + this.name + "', students=" + this.students + "}";
    }
}
