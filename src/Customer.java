import java.util.Random;

public class Customer {
    Random generator = new Random();
    private final int timeWithTeller; //amount of time customer spends with teller

    /*
     * Each customer is initialized wanting to spend 3-5 seconds with a teller
     */
    public Customer() {
        this.timeWithTeller = generator.nextInt(3) + 2;
    }

    //Returns the amount of time each customer will spend with teller
    public int getTimeWithTeller() {
        return this.timeWithTeller;
    }
}
