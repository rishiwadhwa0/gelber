import java.util.LinkedList;

public class Register {
    final int id;
    final int minutesPerItem;
    LinkedList<Customer> line = new LinkedList<>();;

    public Register(int setId, int setMinutesPerItem) throws IllegalArgumentException {
        id = setId;
        if (setMinutesPerItem <= 0) { throw new IllegalArgumentException("Cashier cannot be that quick."); }
        minutesPerItem = setMinutesPerItem;
    }

    public String toString() { return line.toString(); }

    public int getId() { return id; }

    public int getMinutesPerItem() { return minutesPerItem; }

    public void assignCustomer(Customer c) { line.addLast(c); }

    public Customer removeFrontCustomer() { return line.removeFirst(); }

    public Customer getFrontCustomer() { return line.peekFirst(); }

    public Customer getBackCustomer() { return line.peekLast(); }

    public int getLineSize() { return line.size(); }

    public LinkedList<Customer> getLine() { return line; }
}
