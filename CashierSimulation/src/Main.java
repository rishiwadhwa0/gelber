import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        if (args.length != 1) { throw new IllegalArgumentException("Please supply only 1 input file."); }

        List<String> lines = null;
        try { lines = Files.readAllLines(Paths.get(args[0])); }
        catch (IOException e) { e.printStackTrace(); return; }

        Store s = null;
        try { s = new Store(0, Integer.parseInt(lines.remove(0))); }
        catch (Exception e) { e.printStackTrace(); return; }

        PriorityQueue<Customer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < lines.size(); i++) {
            Customer c = null;
            try {
                String[] arrOfStr = lines.get(i).split(" ", 3);
                c = new Customer(
                        i + 1,
                        arrOfStr[0].charAt(0),
                        Integer.parseInt(arrOfStr[1]),
                        Integer.parseInt(arrOfStr[2])
                );
                minHeap.add(c);
            } catch (Exception e) { e.printStackTrace(); return; }
        }

        while (minHeap.size() != 0) { s.addCustomer(minHeap.poll()); }

        while (s.areAllRegistersEmpty() == false) { s.addMinute(); }

        System.out.format("Finished at: t=%d minutes%n", s.getCurrentTime());
    }
}
