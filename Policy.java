import java.util.Scanner;

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

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public String getSmokingStatus() {
        return policyholderSmokingStatus;
    }

    public void setSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    public double calculateBMI() {
        return (policyholderWeight * BMI_MULTIPLIER) / (policyholderHeight * policyholderHeight);
    }

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
      
      