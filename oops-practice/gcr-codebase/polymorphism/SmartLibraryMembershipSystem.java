// Superclass
class LibraryMember {
    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    double calculateFine(int overdueDays) {
        return 0;
    }

    void printDetails() {
        System.out.println("Member Name : " + memberName);
        System.out.println("Member ID   : " + memberId);
    }
}

// Student Member
class StudentMember extends LibraryMember {

    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 2.0; // ₹2 per day
    }
}

// Faculty Member
class FacultyMember extends LibraryMember {

    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 1.0; // ₹1 per day
    }
}

// Guest Member
class GuestMember extends LibraryMember {

    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 5.0; // ₹5 per day
    }
}

// Main Class
public class SmartLibraryMembershipSystem {

    // Search member by ID
    private static void findMemberById(LibraryMember[] members,
                                       String searchId) {

        boolean found = false;

        for (LibraryMember member : members) {
            if (member.memberId.equals(searchId)) {
                System.out.println("\nMember Found:");
                member.printDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nNo member found with ID: " + searchId);
        }
    }

    public static void main(String[] args) {

        LibraryMember[] members = {
                new StudentMember("Mahi", "S101"),
                new FacultyMember("Rahul", "F201"),
                new GuestMember("Anjali", "G301"),
                new StudentMember("Aman", "S102")
        };

        int overdueDays = 7;

        System.out.println(" Library Members ");

        // Dynamic Method Dispatch
        for (LibraryMember member : members) {

            member.printDetails();

            double fine = member.calculateFine(overdueDays);

            System.out.println("Fine for " + overdueDays
                    + " overdue days: ₹" + fine);
            System.out.println(" ");
        }

        // Search Member by ID
        String searchId = "F201";
        findMemberById(members, searchId);
    }
}