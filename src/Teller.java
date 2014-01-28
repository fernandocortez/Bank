import java.util.Random;

public class Teller {
    private boolean available; //true if teller is available for next customer
    private int totalTimeWithCustomers;
    private int numCustomersHelped;
    private int remainingTimeCurrentCustomer;
    Random generator = new Random();

    /*
     * When each teller is initialized, they are not available as they are
     * currently attending a customer.
     */
    public Teller() {
        this.available = false;
        this.totalTimeWithCustomers = 0;
        this.numCustomersHelped = 0;
        this.remainingTimeCurrentCustomer = generator.nextInt(4) + 2;
    }

    public boolean getTellerAvailability() {
        return available;
    }

    public void setTellerAvailability(boolean availability) {
        this.available = availability;
    }

    public int getTotalTimeWithCustomers() {
        return totalTimeWithCustomers;
    }

    public void incTotalTimeWithCustomers() {
        this.totalTimeWithCustomers++;
    }

    public int getNumCustomersHelped() {
        return numCustomersHelped;
    }

    public void incNumCustomersHelped() {
        this.numCustomersHelped++;
    }

    public int getRemainingTimeCurrentCustomer() {
        return remainingTimeCurrentCustomer;
    }

    public void setRemainingTimeCurrentCustomer(int remainingTimeCurrentCustomer) {
        this.remainingTimeCurrentCustomer = remainingTimeCurrentCustomer;
    }

    public void decRemainingTimeCurrentCustomer() {
        this.remainingTimeCurrentCustomer--;
    }
}
