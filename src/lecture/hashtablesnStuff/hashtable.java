package lecture.hashtablesnStuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class hashtable {

    public static void main(String[] args) {

        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(2);
        s.add(2);
        s.add(1);
        s.add(2);
        s.add(1);
        s.add(2);

        ArrayList<Integer> set = new ArrayList<Integer>();
        Map<Integer, Integer> hash = new HashMap<>();

        for (int element : s) {
            int count = hash.getOrDefault(element, 0) + 1;
            // System.out.println(count);
            hash.put(element, count);


            if (count == 1/* first element */) {
                set.add(element);
                System.out.println(set);
            }
        }

        for (int i : set) {
            int fq = hash.get(i);

            // if the needed element appears more than once than print out out and decreases
            // the amount in the set in a new set
            while (fq > 0) {
                System.out.println(i);
                fq--;

            }
        }
        System.out.println(hash);

    }
}
