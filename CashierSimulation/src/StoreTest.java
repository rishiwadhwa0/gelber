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

        assertEquals(1, s.getRegister(1).getLine().get(0).id);
        assertEquals(2, s.getRegister(2).getLine().get(0).id);
        assertEquals(3, s.getRegister(3).getLine().get(0).id);
        assertEquals(4, s.getRegister(1).getLine().get(1).id);
        assertEquals(5, s.getRegister(2).getLine().get(1).id);
        assertEquals(6, s.getRegister(1).getLine().get(2).id);
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

    @Test
    void updateFrontCustomersIfFinished() {
        Store s = new Store(0, 3);
        Customer c1 = new Customer(1, 'A', 7, 7); // reg 1
        c1.setServiceTime(1);
        s.addCustomer(c1);
        Customer c2 = new Customer(2, 'A', 7, 7); // reg 2
        c2.setServiceTime(1);
        s.addCustomer(c2);
        Customer c3 = new Customer(3, 'A', 7, 7); // reg 3
        c3.setServiceTime(1);
        s.addCustomer(c3);
        s.addCustomer(new Customer(4, 'A', 7, 2)); // reg 1
        s.addCustomer(new Customer(5, 'A', 7, 5)); // reg 2
        s.addCustomer(new Customer(6, 'B', 7, 10)); // reg 1

        assertEquals(3, s.getRegister(1).getLineSize());
        assertEquals(2, s.getRegister(2).getLineSize());
        assertEquals(1, s.getRegister(3).getLineSize());
        s.currentTime = 8;
        s.updateFrontCustomersIfFinished();

        // confirm customer 1 is done
        assertEquals(2, s.getRegister(1).getLineSize());
        assertEquals(8, s.getRegister(1).getFrontCustomer().serviceTime);

        // confirm customer 2 is done
        assertEquals( 1, s.getRegister(2).getLineSize());
        assertEquals(8, s.getRegister(2).getFrontCustomer().serviceTime);

        // confirm customer 3 is NOT done
        assertEquals(1, s.getRegister(3).getLineSize());
        assertEquals(c3, s.getRegister(3).getFrontCustomer());

        // for customer 3: confirm last register takes twice the time
        s.currentTime = 14; // shouldn't be done yet
        s.updateFrontCustomersIfFinished();
        assertEquals(1, s.getRegister(3).getLineSize());
        assertEquals(c3, s.getRegister(3).getFrontCustomer());
        s.currentTime = 15;
        s.updateFrontCustomersIfFinished(); // should be done
        assertEquals(0, s.getRegister(3).getLineSize());
        assertEquals(null, s.getRegister(3).getFrontCustomer());
    }

    @Test
    void areAllRegistersEmpty() {
        Store s = new Store(0, 3);
        assertEquals(true, s.areAllRegistersEmpty());

        s.addCustomer(new Customer(1, 'A', 7, 7)); // reg 1
        assertEquals(false, s.areAllRegistersEmpty());
    }

    @Test
    void addCustomerTypeNotAOrB() {
        Store s = new Store(0, 3);
        try {
            s.addCustomer(new Customer(1, 'C', 7, 7));
            assert(false);
        } catch (IllegalArgumentException iae) { assert(true); }
    }

    @Test
    void getRegisterOutOfBounds() {
        Store s = new Store(0, 3);
        s.getRegister(1);
        s.getRegister(2);
        s.getRegister(3);

        try { s.getRegister(0); assert(false); }
        catch (IllegalArgumentException iae) { assert(true); }

        try { s.getRegister(4); assert(false); }
        catch (IllegalArgumentException iae) { assert(true); }
    }

    @Test
    void storeWithNonPositiveNumRegisters() {
        try { Store s = new Store(7, 0); assert(false); }
        catch (IllegalArgumentException iae) { assert (true); }

        try { Store s = new Store(7, -1); assert(false); }
        catch (IllegalArgumentException iae) { assert (true); }
    }
}

