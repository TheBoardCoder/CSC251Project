import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolicyDemo {

    public static void main(String[] args) {
        // List to store all Policy objects
        ArrayList<Policy> policies = new ArrayList<>();
        
        // Counters for smoker and non-smoker policies
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            // Open the file
            File file = new File("C:\\Users\\Randolph\\Documents\\GitHub\\CSC251Project\\PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            // Read policies from the file
            while (fileScanner.hasNextLine()) {
                // Read each line corresponding to Policy fields
                String policyNumber = fileScanner.nextLine().trim();
                String providerName = fileScanner.nextLine().trim();
                String firstName = fileScanner.nextLine().trim();
                String lastName = fileScanner.nextLine().trim();
                int age = Integer.parseInt(fileScanner.nextLine().trim());
                String smokingStatus = fileScanner.nextLine().trim();
                double height = Double.parseDouble(fileScanner.nextLine().trim());
                double weight = Double.parseDouble(fileScanner.nextLine().trim());

                // Create a PolicyHolder object
                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
               
                // Create a Policy object with the PolicyHolder object
                Policy policy = new Policy(policyNumber, providerName, policyHolder);
                policies.add(policy);

                // Count smoker and non-smoker policies
                if ("smoker".equalsIgnoreCase(smokingStatus)) {
                    smokerCount++;
                } else if ("non-smoker".equalsIgnoreCase(smokingStatus)) {
                    nonSmokerCount++;
                }

                // Move to the next set of data (skip any empty lines if present)
                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }
            }

            fileScanner.close();

            // Display information about each policy
            for (Policy policy : policies) {
                System.out.println(policy);
                System.out.println();
            }

            // Display the counts of smoker and non-smoker policies
            System.out.println("Total number of policy objects created: " + Policy.getPolicyCount());
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("The file 'PolicyInformation.txt' was not found.");
            e.printStackTrace();
        }
    }
}