public class Customer {
    final int id;
    final char type;
    final int arrivalTime;
    final int numItems;

    public Customer(int setCustomerID, char type, int setArrivalTime, int setNumItems) {
        this.id = setCustomerID;
        this.type = type;
        this.arrivalTime = setArrivalTime;
        this.numItems = setNumItems;
    }

    public String toString() {
        return "(" + id + ", " + numItems + ")";
    }
}
