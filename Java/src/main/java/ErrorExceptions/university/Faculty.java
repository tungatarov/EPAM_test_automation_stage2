package ErrorExceptions.university;

import ErrorExceptions.university.enums.FacultyName;
import ErrorExceptions.university.exceptions.NoGroupsAtFacultyException;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private FacultyName facultyName;
    private List<Group> groups;

    public Faculty(FacultyName facultyName, List<Group> groups) {
        this.facultyName = facultyName;
        this.groups = groups;
    }

    public FacultyName getName() throws NoGroupsAtFacultyException {
        if (groups.isEmpty()) {
            throw new NoGroupsAtFacultyException("Faulty " + getName() + " has no groups");
        } else {
            return this.facultyName;
        }
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Faculty)) {
            return false;
        } else {
            Faculty faculty = (Faculty)o;
            return this.facultyName.equals(faculty.facultyName) && this.groups.equals(faculty.groups);
        }
    }

    public int hashCode() {
        return Objects.hash(this.facultyName, this.groups);
    }

    public String toString() {
        return "FacultyName{name=" + this.facultyName + ", groups=" + this.groups + "}";
    }
}
