public class Customer implements Comparable<Customer> {
    final int id;
    final char type;
    final int arrivalTime;
    final int numItems;

    Integer serviceTime;

    public Customer(int setCustomerID, char setType, int setArrivalTime, int setNumItems) throws IllegalArgumentException {
        id = setCustomerID;
        type = setType;
        arrivalTime = setArrivalTime;
        if (setNumItems <= 0) { throw new IllegalArgumentException("Customer must have at least 1 item."); }
        numItems = setNumItems;
        serviceTime = null;
    }

    public void setServiceTime(int setServiceTime) {
        serviceTime = setServiceTime;
    }

    public String toString() {
        return "(" + id + ", " + numItems + ")";
    }

    @Override
    public int compareTo(Customer c2) {
        if (arrivalTime < c2.arrivalTime) { return -1; }
        else if (c2.arrivalTime < arrivalTime) { return 1; }

        if (numItems < c2.numItems) { return -1; }
        else if (c2.numItems < numItems) { return 1; }

        if (type == 'A' && c2.type == 'B') { return -1; }
        else if (c2.type == 'A' && type == 'B') { return 1; }

        return 0;
    }
}
