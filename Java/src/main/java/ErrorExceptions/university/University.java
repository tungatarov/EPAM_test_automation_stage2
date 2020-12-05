package ErrorExceptions.university;

import ErrorExceptions.university.enums.FacultyName;
import ErrorExceptions.university.enums.SubjectName;
import ErrorExceptions.university.exceptions.NoFacultiesAtUniversityException;
import ErrorExceptions.university.exceptions.NoGroupsAtFacultyException;
import ErrorExceptions.university.exceptions.NoStudentsInGroupException;
import ErrorExceptions.university.exceptions.StudentHasNoSubjectsException;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() throws NoFacultiesAtUniversityException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesAtUniversityException("There are no faculties at the university.");
        } else {
            return this.faculties;
        }
    }

    private List<Group> getListOfAllFacultyGroups() throws NoFacultiesAtUniversityException {
        List<Group> groups = new ArrayList<>();
        for (Faculty f : getFaculties()) {
            groups.addAll(f.getGroups());
        }
        return groups;
    }

    private List<Student> getListOfAllUniversityStudents() throws NoStudentsInGroupException,
                                                    NoFacultiesAtUniversityException {
        List<Student> students = new ArrayList<>();
        for (Group g : getListOfAllFacultyGroups()) {
            students.addAll(g.getStudents());
        }

        return students;
    }

    public double calcAverageStudentGrade(String firstName, String lastName) throws
            StudentHasNoSubjectsException, NoStudentsInGroupException, NoFacultiesAtUniversityException {
        double averageStudentGrade = 0;
        for (Student s : getListOfAllUniversityStudents()) {
            if (s.getFirstName().toLowerCase().equals(firstName.toLowerCase()) &&
                    s.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                for (Subject subj : s.getSubjects()) {
                    averageStudentGrade += subj.getMark();
                }
                averageStudentGrade /= s.getSubjects().size();
                break;
            }
        }
        return averageStudentGrade;
    }

    public double calcAverageSubjectGradeInGroup(String groupName, SubjectName subjectName) throws
            StudentHasNoSubjectsException, NoStudentsInGroupException, NoFacultiesAtUniversityException {
        double averageSubjectGrade = 0;
        int count = 0;
        for (Student s : getGroup(groupName).getStudents()) {
            for (Subject subj : s.getSubjects()) {
                if (subj.getSubjectName().equals(subjectName)) {
                    averageSubjectGrade += subj.getMark();
                    count++;
                }
            }
        }
        averageSubjectGrade /= count;
        return averageSubjectGrade;
    }

    private Group getGroup(String groupName) throws NoFacultiesAtUniversityException {
        Group group = null;
        for (Group g : getListOfAllFacultyGroups()) {
            if (g.getName().toLowerCase().equals(groupName.toLowerCase())) {
                group = g;
            }
        }
        return group;
    }

    public double calcAverageSubjectGradeInFaculty(FacultyName facultyName, SubjectName subjectName) throws
                                            StudentHasNoSubjectsException, NoStudentsInGroupException,
                                            NoGroupsAtFacultyException, NoFacultiesAtUniversityException {
        double averageSubjectGrade = 0;
        int count = 0;
        for (Group g : getListOfAllGroupsOfFaculty(facultyName)) {
            averageSubjectGrade += calcAverageSubjectGradeInGroup(g.getName(), subjectName);
            count++;
        }
        averageSubjectGrade /= count;
        return averageSubjectGrade;
    }

    private List<Group> getListOfAllGroupsOfFaculty(FacultyName facultyName) throws
                                                    NoGroupsAtFacultyException {
        List<Group> groups = new ArrayList<>();
        for (Faculty f : faculties) {
            if (f.getName().equals(facultyName)) {
                groups.addAll(f.getGroups());
            }
        }
        return groups;
    }

    public double calcAverageSubjectGradeInUniversity(SubjectName subjectName) throws
                            NoGroupsAtFacultyException, StudentHasNoSubjectsException,
                            NoStudentsInGroupException, NoFacultiesAtUniversityException {
        double averageSubjectGrade = 0;
        for (Faculty f : faculties) {
            averageSubjectGrade += calcAverageSubjectGradeInFaculty(f.getName(), subjectName);
        }
        averageSubjectGrade /= faculties.size();
        return averageSubjectGrade;
    }
}
