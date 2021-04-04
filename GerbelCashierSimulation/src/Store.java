public class Store {
    final int t0;
    Register[] registers = null;

    public Store(int setT0, int setNumRegisters) {
        t0 = setT0;
        registers = new Register[setNumRegisters];
        for (int i = 0; i < registers.length; i++) {
            int minutesPerItem = i != registers.length-1 ? 1 : 2;
            registers[i] = new Register((i+1), minutesPerItem);
        }
    }

    public void printStore() {
        for (int i = 0; i < registers.length; i++) { System.out.println(registers[i].getLine().toString()); }
    }

    public Register getRegister(int registerId) throws IllegalArgumentException {
        if (registerId <= 0 || registerId > registers.length) { throw new IllegalArgumentException(); }
        return registers[registerId-1];
    }

    public Register getRegisterWithShortestLine() {
        Register minRegister = registers[0];
        int minLineSize = minRegister.getLineSize();
        if (minLineSize == 0) { return minRegister; } // don't even look for a shorter line
        for (int i = 1; i < registers.length; i++) {
            Register currRegister = registers[i];
            int currLineSize = currRegister.getLineSize();
            if (currLineSize < minLineSize) { minRegister = currRegister; minLineSize = currLineSize; }
        }
        return minRegister;
    }

    public Register getRegisterWithLastCustomerLeastItems() {
        Register minRegister = registers[0];
        if (minRegister.getLineSize() == 0) { return minRegister; } // OR return least idx empty line
        int minItems = minRegister.getBackCustomer().numItems;
        for (int i = 1; i < registers.length; i++) {
            Register currRegister = registers[i];
            if (currRegister.getLineSize() == 0) { return currRegister; } // OR return least idx empty line
            int currItems = currRegister.getBackCustomer().numItems;
            if (currItems < minItems) { minRegister = currRegister; minItems = currItems; }
        }
        return minRegister;
    }

    public void addCustomer(Customer c) {
        switch (c.type) {
            case 'A':
                getRegisterWithShortestLine().assignCustomer(c);
                break;
            case 'B':
                getRegisterWithLastCustomerLeastItems().assignCustomer(c);
                break;
        }
    }
}
