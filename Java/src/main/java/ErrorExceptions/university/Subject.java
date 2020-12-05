package ErrorExceptions.university;

import ErrorExceptions.university.enums.SubjectName;

import java.util.Objects;

public class Subject {
    private SubjectName subjectName;
    private int mark;

    public Subject(SubjectName subjectName, int mark) throws IllegalArgumentException {
        if (mark < 0 || mark > 10) {
            throw new IllegalArgumentException("The mark supposed to be in the range from 0 to 10");
        } else {
            this.subjectName = subjectName;
            this.mark = mark;
        }
    }

    public SubjectName getSubjectName() {
        return this.subjectName;
    }

    public int getMark() {
        return this.mark;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Subject)) {
            return false;
        } else {
            Subject subject = (Subject) o;
            return this.mark == subject.mark && this.subjectName.equals(subject.subjectName);
        }
    }

    public int hashCode() {
        return Objects.hash(this.subjectName, this.mark);
    }

    public String toString() {
        return "SubjectName{subjectName='" + this.subjectName + "', mark=" + this.mark + "}";
    }
}
