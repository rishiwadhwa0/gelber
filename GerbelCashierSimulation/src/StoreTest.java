import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    void addCustomer() {
        Store s = new Store(0, 3);
        s.addCustomer(new Customer(1, 'A', 7, 7)); // reg 1
        s.addCustomer(new Customer(2, 'A', 7, 7)); // reg 2
        s.addCustomer(new Customer(3, 'A', 7, 7)); // reg 3
        s.addCustomer(new Customer(4, 'A', 7, 2)); // reg 1
        s.addCustomer(new Customer(5, 'A', 7, 5)); // reg 2
        s.addCustomer(new Customer(6, 'B', 7, 10)); // reg 1

        assertEquals(1, s.getRegister(1).line.get(0).id);
        assertEquals(2, s.getRegister(2).line.get(0).id);
        assertEquals(3, s.getRegister(3).line.get(0).id);
        assertEquals(4, s.getRegister(1).line.get(1).id);
        assertEquals(5, s.getRegister(2).line.get(1).id);
        assertEquals(6, s.getRegister(1).line.get(2).id);
    }

    @Test
    void getRegisterWithShortestLine() {
        Store s = new Store(0, 3);
        s.addCustomer(new Customer(1, 'A', 7, 7)); // reg 1
        s.addCustomer(new Customer(2, 'A', 7, 7)); // reg 2
        s.addCustomer(new Customer(3, 'A', 7, 7)); // reg 3
        s.addCustomer(new Customer(4, 'A', 7, 2)); // reg 1
        s.addCustomer(new Customer(5, 'A', 7, 5)); // reg 2
        s.addCustomer(new Customer(6, 'B', 7, 10)); // reg 1

        assertEquals(3, s.getRegisterWithShortestLine().id);
    }

    @Test
    void getRegisterWithShortestLineEmpty() {
        Store s = new Store(0, 3);
        s.addCustomer(new Customer(1, 'A', 7, 7)); // reg 1
        s.addCustomer(new Customer(2, 'A', 7, 7)); // reg 2

        assertEquals(3, s.getRegisterWithShortestLine().id);
    }

    @Test
    void getRegisterWithLastCustomerLeastItems() {
        Store s = new Store(0, 3);
        s.addCustomer(new Customer(1, 'A', 7, 7)); // reg 1
        s.addCustomer(new Customer(2, 'A', 7, 7)); // reg 2
        s.addCustomer(new Customer(3, 'A', 7, 7)); // reg 3
        s.addCustomer(new Customer(4, 'A', 7, 2)); // reg 1
        s.addCustomer(new Customer(5, 'A', 7, 5)); // reg 2
        s.addCustomer(new Customer(6, 'B', 7, 10)); // reg 1

        assertEquals(2, s.getRegisterWithLastCustomerLeastItems().id);
    }

    @Test
    void getRegisterWithLastCustomerLeastItemsEmpty() {
        Store s = new Store(0, 3);
        s.addCustomer(new Customer(1, 'A', 7, 7)); // reg 1
        s.addCustomer(new Customer(2, 'A', 7, 7)); // reg 2

        assertEquals(3, s.getRegisterWithLastCustomerLeastItems().id);
    }
}

