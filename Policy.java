import java.util.Scanner;

/**
 * The Policy class represents an insurance policy with various attributes 
 * such as policy number, provider name, policyholder information, and 
 * methods to calculate BMI and policy price.
 */
public class Policy {
   
   private String policyNumber;
   private String providerName;
   private String policyholderFirstName;
   private String policyholderLastName;
   private int policyholderAge;
   private String policyholderSmokingStatus;
   private double policyholderHeight;
   private double policyholderWeight;
   
   private static final double BASE_FEE = 600;
   private static final double AGE_FEE = 75;
   private static final double SMOKER_FEE = 100;
   private static final double BMI_THRESHOLD = 35;
   private static final double BMI_FEE_RATE = 20;
   private static final double BMI_MULTIPLIER = 703;
   private static final double SENIOR_STATUS = 50;
   
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

        System.out.print("Please enter Policyholder's First Name: ");
        policyholderFirstName = scanner.nextLine();

        System.out.print("Please enter Policyholder's Last Name: ");
        policyholderLastName = scanner.nextLine();

        System.out.print("Please enter Policyholder's Age: ");
        policyholderAge = Integer.parseInt(scanner.nextLine());

        System.out.print("Please enter Smoking Status (smoker/non-smoker): ");
        policyholderSmokingStatus = scanner.nextLine();

        System.out.print("Please enter Policyholder's Height (in inches): ");
        policyholderHeight = Double.parseDouble(scanner.nextLine());

        System.out.print("Please enter Policyholder's Weight (in pounds): ");
        policyholderWeight = Double.parseDouble(scanner.nextLine());
    }

    /**
     * Constructs a Policy object with the specified values.
     * 
     * @param policyNumber the policy number
     * @param providerName the provider name
     * @param policyholderFirstName the policyholder's first name
     * @param policyholderLastName the policyholder's last name
     * @param policyholderAge the policyholder's age
     * @param smokingStatus the policyholder's smoking status
     * @param policyholderHeight the policyholder's height in inches
     * @param policyholderWeight the policyholder's weight in pounds
     */
    public Policy(String policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String smokingStatus,
                  double policyholderHeight, double policyholderWeight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.policyholderSmokingStatus = smokingStatus;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
    }
   
    /**
     * Gets the policy number.
     * 
     * @return the policy number
     */
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    /**
     * Sets the policy number.
     * 
     * @param policyNumber the new policy number
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
   
    /**
     * Gets the provider name.
     * 
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }
   
    /**
     * Sets the provider name.
     * 
     * @param providerName the new provider name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
   
    /**
     * Gets the policyholder's first name.
     * 
     * @return the policyholder's first name
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }
   
    /**
     * Sets the policyholder's first name.
     * 
     * @param policyholderFirstName the policyholder's new first name
     */
    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }
   
    /**
     * Gets the policyholder's last name.
     * 
     * @return the policyholder's last name
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }
   
    /**
     * Sets the policyholder's last name.
     * 
     * @param policyholderLastName the policyholder's new last name
     */
    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }
   
    /**
     * Gets the policyholder's age.
     * 
     * @return the policyholder's age
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }
   
    /**
     * Sets the policyholder's age.
     * 
     * @param policyholderAge the policyholder's new age
     */
    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }
   
    /**
     * Gets the policyholder's smoking status.
     * 
     * @return the policyholder's smoking status
     */
    public String getSmokingStatus() {
        return policyholderSmokingStatus;
    }
   
    /**
     * Sets the policyholder's smoking status.
     * 
     * @param policyholderSmokingStatus the new smoking status
     */
    public void setSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }
   
    /**
     * Gets the policyholder's height in inches.
     * 
     * @return the policyholder's height
     */
    public double getPolicyholderHeight() {
        return policyholderHeight;
    }
   
    /**
     * Sets the policyholder's height in inches.
     * 
     * @param policyholderHeight the policyholder's new height
     */
    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }
   
    /**
     * Gets the policyholder's weight in pounds.
     * 
     * @return the policyholder's weight
     */
    public double getPolicyholderWeight() {
        return policyholderWeight;
    }
   
    /**
     * Sets the policyholder's weight in pounds.
     * 
     * @param policyholderWeight the policyholder's new weight
     */
    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }
   
    /**
     * Calculates the Body Mass Index (BMI) of the policyholder.
     * 
     * @return the policyholder's BMI
     */
    public double calculateBMI() {
        return (policyholderWeight * BMI_MULTIPLIER) / (policyholderHeight * policyholderHeight);
    }
   
    /**
     * Calculates the price of the policy based on age, smoking status, and BMI.
     * 
     * @return the calculated policy price
     */
    public double calculatePolicyPrice() {
        double price = BASE_FEE;

        if (policyholderAge > SENIOR_STATUS) {
            price += AGE_FEE;
        }
        if ("smoker".equalsIgnoreCase(policyholderSmokingStatus)) {
            price += SMOKER_FEE;
        }
        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            price += (bmi - BMI_THRESHOLD) * BMI_FEE_RATE;
        }

        return price;
    }
}
      
      