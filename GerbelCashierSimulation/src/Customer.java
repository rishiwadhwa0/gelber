public class Customer {
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
}
