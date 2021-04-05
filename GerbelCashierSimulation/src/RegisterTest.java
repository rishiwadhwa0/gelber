import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    Register r;

    @BeforeEach
    void register() {
        r = new Register(7, 7);
        Random random = new Random();

        for (int i = 1; i < 8; i++) { r.assignCustomer(new Customer(i, 'A', 7, i)); }
    }

    @Test
    void getId() {
        assertEquals(r.id, 7);
    }

    @Test
    void removeCustomer() {
        r.removeFrontCustomer();
        assertEquals(6, r.getLineSize());
        Customer fc = r.getFrontCustomer();
        assertEquals(2, fc.id);
        assertEquals('A', fc.type);
        assertEquals(7, fc.arrivalTime);
        assertEquals(2, fc.numItems);
    }

    @Test
    void getFrontCustomer() {
        Customer fc = r.getFrontCustomer();
        assertEquals(1, fc.id);
        assertEquals('A', fc.type);
        assertEquals(7, fc.arrivalTime);
        assertEquals(1, fc.numItems);
    }

    @Test
    void getBackCustomer() {
        Customer fc = r.getBackCustomer();
        assertEquals(7, fc.id);
        assertEquals('A', fc.type);
        assertEquals(7, fc.arrivalTime);
        assertEquals(7, fc.numItems);
    }

    @Test
    void getLineSize() {
        assertEquals(7, r.getLineSize());
    }

    @Test
    void registerWithQuickCashier() {
        try { Register r = new Register(7, 0); assert(false); }
        catch (IllegalArgumentException iae) { assert(true); }

        try { Register r = new Register(7, -1); assert(false); }
        catch (IllegalArgumentException iae) { assert(true); }
    }
}