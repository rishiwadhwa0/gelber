import java.util.LinkedList;

public class Register {
    final int id;
    final int minutesPerItem;
    LinkedList<Customer> line = new LinkedList<>();;

    public Register(int setId, int setMinutesPerItem) {
        this.id = setId;
        this.minutesPerItem = setMinutesPerItem;
    }

    public int getId() { return id; }

    public void assignCustomer(Customer c) { line.addLast(c); }

    public Customer removeFrontCustomer() { return line.removeFirst(); }

    public Customer getFrontCustomer() { return line.peekFirst(); }

    public Customer getBackCustomer() { return line.peekLast(); }

    public int getLineSize() { return line.size(); }

    public LinkedList getLine() { return line; }
}
