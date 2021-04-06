# gerbel

## Requirements
1. Java


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
