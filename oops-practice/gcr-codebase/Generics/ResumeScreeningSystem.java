import java.util.ArrayList;
import java.util.List;

abstract class JobRole {

    protected String candidateName;

    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    abstract void display();
}

class SoftwareEngineer extends JobRole {

    SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    void display() {
        System.out.println("Software Engineer : " + candidateName);
    }
}

class DataScientist extends JobRole {

    DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    void display() {
        System.out.println("Data Scientist : " + candidateName);
    }
}

class ProductManager extends JobRole {

    ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    void display() {
        System.out.println("Product Manager : " + candidateName);
    }
}

class Resume<T extends JobRole> {

    private final List<T> resumes = new ArrayList<>();

    void addResume(T resume) {
        resumes.add(resume);
    }

    List<T> getResumes() {
        return resumes;
    }
}

public class ResumeScreeningSystem {

    public static <T extends JobRole> void processResume(T role) {
        System.out.println("Processing Resume...");
        role.display();
    }

    static void screeningPipeline(List<? extends JobRole> list) {

        for (JobRole role : list) {
            role.display();
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> se = new Resume<>();
        se.addResume(new SoftwareEngineer("Mahi"));
        se.addResume(new SoftwareEngineer("Riya"));

        Resume<DataScientist> ds = new Resume<>();
        ds.addResume(new DataScientist("Aman"));
        ds.addResume(new DataScientist("Rahul"));

        Resume<ProductManager> pm = new Resume<>();
        pm.addResume(new ProductManager("Priya"));
        pm.addResume(new ProductManager("Ankit"));

        System.out.println("Software Engineer Resumes");
        screeningPipeline(se.getResumes());

        System.out.println();

        System.out.println("Data Scientist Resumes");
        screeningPipeline(ds.getResumes());

        System.out.println();

        System.out.println("Product Manager Resumes");
        screeningPipeline(pm.getResumes());

        System.out.println();

        processResume(new SoftwareEngineer("Karan"));
    }
}