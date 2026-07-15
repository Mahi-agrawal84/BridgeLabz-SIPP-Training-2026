import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmailDomainCounter {
    public static void main(String[] args) {

        String fileName = "emails.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String email;
            Map<String, Integer> domainCount = new HashMap<>();

            while ((email = br.readLine()) != null) {

                // Extract domain using String methods
                int atIndex = email.indexOf('@');

                if (atIndex != -1) {
                    String domain = email.substring(atIndex + 1);

                    domainCount.put(domain,
                            domainCount.getOrDefault(domain, 0) + 1);
                }
            }

            System.out.println("Domain Usage Count:");
            for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                System.out.println(entry.getKey() + " -> "
                        + entry.getValue() + " user(s)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}