
package customer;

/**
 *
 * @author Alina Svarishchuk
 */
public class LinkedQueue {

    //create a variable for storing the first and last customer
    public Customer first;
    private Customer last;

    //linked queue constructor
    public LinkedQueue() {
        first = null;
        last = null;
    }

    //check to see if the queue is empty
    public boolean isEmpty() {
        return first == null;
    }

    //method to add a new customer to the queue
    public void enqueue(Customer newCustomer) {

        //if the line is empty, set the new customer to be the first customer
        if (isEmpty()) {
            first = newCustomer;
            
        } else {

            //if line is not empty, create a reference to the next object 
            //set last to reference the new customer
            last.setNext(newCustomer);
        }

        //last should always reference the newest customer
        last = newCustomer;
    }

    //method to remove customer from queue
    public Customer dequeue() {

        //if the line is empty, print a message
        if (isEmpty()) {
            System.out.println("The line is already empty");
            return null;
        }

        //create a reference to store the old first object
        Customer oldFirst = first;

        //first should now reference the next object in the queue
        first = first.getNext();

        //if the queue is empty after the first object is set to oldFirst, last will be set to null
        if (isEmpty()) {
            last = null;
        }
        
        //return the object removed from the queue
        return oldFirst;
    }

    //getter - returns first customer in line
    public Customer getFirst() {
        return first;
    }

    //getter - returns last customer in line
    public Customer getLast() {
        return last;
    }

}
