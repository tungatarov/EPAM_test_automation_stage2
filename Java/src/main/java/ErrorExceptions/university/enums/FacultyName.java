package ErrorExceptions.university.enums;

public enum FacultyName {

    ECONOMICS("Economics"),
    ENGINEERING("Engineering"),
    MATHEMATIC("Mathematic"),
    HISTORY("History");

    private String facultyName;

    FacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "FacultyName{" +
                "facultyName='" + facultyName + '\'' +
                "} " + super.toString();
    }
}