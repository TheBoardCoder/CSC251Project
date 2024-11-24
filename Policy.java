import java.util.Scanner;

/**
 * The Policy class represents an insurance policy with attributes such as
 * policy number, provider name, and associated policyholder information.
 */
public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static final double BASE_FEE = 600;
    private static final double AGE_FEE = 75;
    private static final double SMOKER_FEE = 100;
    private static final double BMI_THRESHOLD = 35;
    private static final double BMI_FEE_RATE = 20;
    private static final int SENIOR_STATUS = 50;

    /**
     * Default constructor that initializes a Policy object by prompting 
     * the user for input values.
     */
    public Policy() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter Policy Number: ");
        policyNumber = scanner.nextLine();

        System.out.print("Please enter Provider Name: ");
        providerName = scanner.nextLine();

        System.out.println("Enter Policyholder Details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();
        System.out.print("Height (in inches): ");
        double height = Double.parseDouble(scanner.nextLine());
        System.out.print("Weight (in pounds): ");
        double weight = Double.parseDouble(scanner.nextLine());

        policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
    }

    /**
     * Constructs a Policy object with the specified values.
     * 
     * @param policyNumber the policy number
     * @param providerName the provider name
     * @param policyHolder the associated policyholder
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
    }

    // Getter and setter methods
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    /**
     * Calculates the price of the policy based on age, smoking status, and BMI.
     * 
     * @return the calculated policy price
     */
    public double calculatePolicyPrice() {
        double price = BASE_FEE;

        if (policyHolder.getAge() > SENIOR_STATUS) {
            price += AGE_FEE;
        }
        if ("smoker".equalsIgnoreCase(policyHolder.getSmokingStatus())) {
            price += SMOKER_FEE;
        }
        double bmi = policyHolder.calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            price += (bmi - BMI_THRESHOLD) * BMI_FEE_RATE;
        }

        return price;
    }
    
     /**
     * Provides a string representation of the Policy object.
     * 
     * @return a string representation of the Policy
     */
    @Override
    public String toString() {
        return "Policy{" +
               "Policy Number='" + policyNumber + '\'' +
               ", Provider Name='" + providerName + '\'' +
               ", Policy Price=$" + String.format("%.2f", calculatePolicyPrice()) +
               ", Policy Holder=" + policyHolder +
               '}';
    }
}

