// Base Class
class Course {
    protected String courseName;
    protected int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration,
                        String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded Course: " + isRecorded);
    }
}

// Subclass of OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private final double fee;
    private final double discount;

    public PaidOnlineCourse(String courseName, int duration,
                            String platform, boolean isRecorded,
                            double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: ₹" + calculateFinalFee());
    }
}

// Main Class
public class EducationalCourseHierarchy {
    public static void main(String[] args) {

        PaidOnlineCourse course = new PaidOnlineCourse(
                "Java Programming",
                40,
                "Udemy",
                true,
                5000,
                20
        );

        System.out.println("Course Details:");
        course.displayDetails();
    }
}