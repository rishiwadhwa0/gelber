public class Customer {
    final int id;
    final char type;
    final int arrivalTime;
    final int numItems;

    Integer serviceTime;

    public Customer(int setCustomerID, char setType, int setArrivalTime, int setNumItems) {
        id = setCustomerID;
        type = setType;
        arrivalTime = setArrivalTime;
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
