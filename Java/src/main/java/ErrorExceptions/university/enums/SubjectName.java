package ErrorExceptions.university.enums;

public enum SubjectName {
    ENGLISH("English"),
    MATH("Math"),
    BIOLOGY("Biology"),
    HISTORY("History"),
    ECONOMICS("Economics"),
    PHYSICS("Physics"),
    PHILOSOPHY("Philosophy"),
    PSYCHOLOGY("Psychology");

    private String subjectName;

    SubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "SubjectName{" +
                "subjectName='" + subjectName + '\'' +
                "} " + super.toString();
    }
}
