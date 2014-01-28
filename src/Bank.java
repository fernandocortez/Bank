/*
 * PURPOSE
 * The purpose of this program is to create a simulation of a bank in which
 * customers will enter and add to a queue after a randomly generated amount
 * of time. The tellers will help as many customers as they are able to in the
 * allotted 2 minutes time.
 */

import java.util.Random;
import java.util.LinkedList;

public class Bank {
    public static final int RUNTIME = 120; // 120 sec = 2 min
    public static final int TELLERCOUNT = 5;

    public static void main(String[] args) {
        Random generator = new Random();
        LinkedList<Customer> lineQueue = new LinkedList<>(); // queue for arriving customers
        LinkedList<Teller> tellerQueue = new LinkedList<>(); // queue for available tellers

        Teller bankTeller[] = new Teller[TELLERCOUNT]; // array of present tellers
        for(int i = 0; i < TELLERCOUNT; i++) {
            bankTeller[i] = new Teller();
        }

        int nextCustomerETA = generator.nextInt(4) + 2; // timer for arrival of next customer
        for(int counter = 0; counter < RUNTIME; counter++) {
            /* When the nextCustomerETA reaches zero, a new customer arrives
             * and is added to the queue. The timer is then set again to a
             * value between 2 and 6, inclusive. Else, the time is reduced by 1
             */
            if(nextCustomerETA == 0) {
                Customer customer = new Customer();
                lineQueue.add(customer);
                nextCustomerETA = generator.nextInt(4) + 2;
            } else {
                nextCustomerETA--;
            }

            for(int i = 0; i < TELLERCOUNT; i++) {
                if(bankTeller[i].getTellerAvailability()) {
                    tellerQueue.add(bankTeller[i]);
                } else if(bankTeller[i].getRemainingTimeCurrentCustomer() == 0) {
                    bankTeller[i].setTellerAvailability(true);
                    bankTeller[i].incNumCustomersHelped();
                } else {
                    bankTeller[i].decRemainingTimeCurrentCustomer();
                    bankTeller[i].incTotalTimeWithCustomers();
                }
            }

            while( !tellerQueue.isEmpty() && !lineQueue.isEmpty() ) {
                Teller teller = tellerQueue.removeFirst();
                Customer customer = lineQueue.removeFirst();
                teller.setTellerAvailability(false);
                teller.setRemainingTimeCurrentCustomer(customer.getTimeWithTeller());
            }
        }

        System.out.printf("%s %30s %27s\n", "NAME", "Number Customers Helped", "Total Time with Customers");
        for(int i = 0; i < TELLERCOUNT; i++) {
            System.out.printf("Teller %2d", i);
            System.out.printf("%26d", bankTeller[i].getNumCustomersHelped());
            System.out.printf("%28d\n", bankTeller[i].getTotalTimeWithCustomers());
        }
    }
}
