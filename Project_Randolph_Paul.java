import java.util.Scanner;

public class Project_Randolph_Paul {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Enter Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Enter Policyholder's First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Policyholder's Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Policyholder's Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Enter Policyholder's Height (in inches): ");
        double height = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Policyholder's Weight (in pounds): ");
        double weight = Double.parseDouble(scanner.nextLine());

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

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

        scanner.close();
    }
}