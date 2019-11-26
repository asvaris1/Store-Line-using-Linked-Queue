
package customer;

import java.util.Random;

/**
 *
 * @author Alina Svarishchuk
 */
public class GroceryStore {

    public static void main(String[] args) {

        //create a new linked queue
        LinkedQueue line = new LinkedQueue();

        //intialize variables to hold line statistics
        int lineLength = 0;
        int maxLineLength = 0;
        int customersServiced = 0;

        //iterate through 60 minutes
        for (int i = 0; i < 60; i++) {

            //check to make sure the line is not empty 
            if (line.isEmpty() == false) {

                //decrease the remaining service time for the first customer in line by a minute
                if (line.getFirst().getServiceTime() > 0) {
                    line.getFirst().decServiceTime();
                } else {
                    //if remaining service time is 0, remove customer from queue
                    line.dequeue();

                    //decrease line length by 1, increase customers serviced by 1
                    lineLength--;
                    customersServiced++;
                    System.out.println("Customer serviced and removed from the queue.  Queue length is now " + lineLength);
                }
            }

            //random integer generated between 0-3
            int c = new Random().nextInt(4);

            //random integer has a 25% chance of being 1
            if (c == 1) {

                //increase line length by 1
                lineLength++;

                //set the new maximum line length if applicable
                if (lineLength > maxLineLength) {
                    maxLineLength = lineLength;
                }

                //add a new customer to the line
                line.enqueue(new Customer());

                //print message to indicate current line length
                System.out.println("New Customer added! Queue length is now " + lineLength);

            }

            //divider to seperate minutes
            System.out.println("-------------------------------------");

        }

        //print out maximum line length
        System.out.println("Maximum Line Length: " + maxLineLength);

        //print out total number of customers serviced
        System.out.println("Total Customers Serviced: " + customersServiced);
    }
}
