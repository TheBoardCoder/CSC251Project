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

                // Create a Policy object and add it to the list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
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
                System.out.println("\nPolicy Information:");
                System.out.println("Policy Number: " + policy.getPolicyNumber());
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println("Policyholder First Name: " + policy.getPolicyholderFirstName());
                System.out.println("Policyholder Last Name: " + policy.getPolicyholderLastName());
                System.out.println("Policyholder Age: " + policy.getPolicyholderAge());
                System.out.println("Smoking Status: " + policy.getSmokingStatus());
                System.out.println("Policyholder Height (in inches): " + policy.getPolicyholderHeight());
                System.out.println("Policyholder Weight (in pounds): " + policy.getPolicyholderWeight());
                System.out.printf("Policyholder BMI: %.2f\n", policy.calculateBMI());
                System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());
                System.out.println();
            }

            // Display the counts of smoker and non-smoker policies
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("The file 'PolicyInformation.txt' was not found.");
            e.printStackTrace();
        }
    }
}