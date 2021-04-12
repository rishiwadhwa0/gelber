# gelber

## Requirements
1. Java


## Description
3 Objects: Store, Register, and Customer
- Most of the decision making is delegated to the Store Class, which maintains the current time and an arrray of Registers.
- The Register class maintains its own id, minutesPerItem, and a one LinkedList representing the line of its customers.
- The Customer class maintains attributes that describe a customer. Most notably, it overrides the compareTo() method, which allows it to be compared with other Customers. This is very important because it allows me to add Customers to a Minimum Heap (i.e. Minimum Priority Queue).

The Main class parses the input file, creates all the Customers and adds them to a Minimum Heap, and then uses Store.addCustomer() to run the simulation as it pops Customers off the Minimum Heap.

I have tried my best to include as much error handling as possible. 

I have also written and ran unit tests along my development process.


## Assumptions
1. For Customers that arrive at the same time T=t, they are assigned to registers one-by-one.
2. It follows that if two customers arrive at the same time T=t, the customer that is processed first can influence the second's assignment.

## Simulation
### To Compile and Run Simulation
1. Make sure you are in the src directory
2. javac Customer.java Register.java Store.java Main.java
3. java Main "../input/input1.txt"
4. java Main "../input/input2.txt"
5. java Main "../input/input3.txt"
6. java Main "../input/input4.txt"
7. java Main "../input/input5.txt"


## Unit Tests
### To Compile and Run Tests
1. Make sure you are in the src directory
2. javac -cp "junit-platform-console-standalone-1.8.0-M1.jar" CustomerTest.java Customer.java RegisterTest.java Register.java StoreTest.java Store.java
3. java -jar junit-platform-console-standalone-1.8.0-M1.jar -cp "." --select-class CustomerTest
4. java -jar junit-platform-console-standalone-1.8.0-M1.jar -cp "." --select-class RegisterTest
5. java -jar junit-platform-console-standalone-1.8.0-M1.jar -cp "." --select-class StoreTest
