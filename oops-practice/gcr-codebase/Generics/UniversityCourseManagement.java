import java.util.ArrayList;
import java.util.List;

abstract class CourseType {

    protected String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    abstract void display();
}

class ExamCourse extends CourseType {

    ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    void display() {
        System.out.println("Exam Course : " + courseName);
    }
}

class AssignmentCourse extends CourseType {

    AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    void display() {
        System.out.println("Assignment Course : " + courseName);
    }
}

class ResearchCourse extends CourseType {

    ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    void display() {
        System.out.println("Research Course : " + courseName);
    }
}

class Course<T extends CourseType> {

    private final List<T> courses = new ArrayList<>();

    void addCourse(T course) {
        courses.add(course);
    }

    List<T> getCourses() {
        return courses;
    }
}

public class UniversityCourseManagement {

    static void displayCourses(List<? extends CourseType> list) {

        for (CourseType course : list) {
            course.display();
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Data Structures"));
        examCourses.addCourse(new ExamCourse("Operating Systems"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Java Programming"));
        assignmentCourses.addCourse(new AssignmentCourse("Web Development"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Artificial Intelligence"));
        researchCourses.addCourse(new ResearchCourse("Machine Learning"));

        System.out.println(" Exam Courses ");
        displayCourses(examCourses.getCourses());

        System.out.println();

        System.out.println(" Assignment Courses ");
        displayCourses(assignmentCourses.getCourses());

        System.out.println();

        System.out.println(" Research Courses ");
        displayCourses(researchCourses.getCourses());
    }
}