import java.io.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";      // Input file
        String outputFile = "reportcard.txt";   // Output file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             // Append mode = true (prevents overwriting old reports)
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

            String line;

            bw.write("\n REPORT CARD \n");

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\s+");

                if (data.length < 4) {
                    bw.write("Invalid Record: " + line + "\n");
                    continue;
                }

                String name = data[0];

                int mark1 = Integer.parseInt(data[1]);
                int mark2 = Integer.parseInt(data[2]);
                int mark3 = Integer.parseInt(data[3]);

                double average = (mark1 + mark2 + mark3) / 3.0;

                bw.write("Student Name : " + name + "\n");
                bw.write("Marks        : " + mark1 + ", " + mark2 + ", " + mark3 + "\n");
                bw.write("Average      : " + String.format("%.2f", average) + "\n");
                bw.write("\n");
            }

                System.out.println("Report card generated successfully in " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found!");
            System.out.println("Please check if '" + inputFile + "' exists.");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format in file.");
        }
    }
}