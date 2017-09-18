package util;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class RandomNumberUtil {

    public static List<Integer> randomIntegersUpTo(int highest, int quantity) {
        if (highest < quantity - 1) {
            throw new RuntimeException("Requested " + quantity + " random numbers but only " + (highest + 1) + " available.");
        }

        // Add the numbers 0 to highest to this list
        ArrayList<Integer> potentialNumbers = new ArrayList<>(highest);
        for(int i = 0; i < highest + 1; i++) {
            potentialNumbers.add(i);
        }

        // Select numbers at random to add to the results
        Random rand = new Random();
        TreeSet<Integer> results = new TreeSet<>();
        while(potentialNumbers.size() > 0 && quantity > 0) {
            int index = rand.nextInt(potentialNumbers.size());
            results.add(potentialNumbers.remove(index));
            quantity--;
        }

        return new ArrayList<>(results);
    }
}
