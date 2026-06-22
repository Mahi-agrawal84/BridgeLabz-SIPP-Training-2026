class InterviewBot {

    // Instance Variables
    String botName;
    String technology;

    // Constructor using this keyword
    InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    // Method to conduct interview
    void conductInterview() {
        System.out.println("Bot Name   : " + botName);
        System.out.println("Technology : " + technology);
        System.out.println(botName + " is conducting a " +
                           technology + " interview.");
        System.out.println("");
    }
}

public class AIInterviewBot {

    public static void main(String[] args) {

        // Create 3 Interview Bots
        InterviewBot bot1 = new InterviewBot("TechBot", "Java");
        InterviewBot bot2 = new InterviewBot("CodeBot", "Python");
        InterviewBot bot3 = new InterviewBot("WebBot", "Web Development");

        // Conduct Interviews
        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}