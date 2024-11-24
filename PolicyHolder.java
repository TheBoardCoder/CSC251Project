/**
 * The PolicyHolder class represents a person associated with an insurance policy.
 * It includes personal details such as name, age, smoking status, height, and weight.
 */
public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    private static final double BMI_MULTIPLIER = 703;

    /**
     * Default constructor for PolicyHolder.
     */
    public PolicyHolder() {}

    /**
     * Constructs a PolicyHolder object with specified values.
     * 
     * @param firstName     the policyholder's first name
     * @param lastName      the policyholder's last name
     * @param age           the policyholder's age
     * @param smokingStatus the policyholder's smoking status
     * @param height        the policyholder's height in inches
     * @param weight        the policyholder's weight in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age, 
                        String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getter and setter methods for all fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) of the policyholder.
     * 
     * @return the policyholder's BMI
     */
    public double calculateBMI() {
        return (weight * BMI_MULTIPLIER) / (height * height);
    }
}
