import java.util.*;

/**
 * Created by Nastya on 06.06.2016.
 */
public class HW {
    public static void main(String[] args) {
        Map<String, Integer> car = new TreeMap<>(new MyComparator());

        car.put("BMW", 5);
        car.put("Mercedes", 3);
        car.put("Audi", 4);
        car.put("Ford", 10);
        car.put("Hyundai", 2);
        car.put("Mazda", 2);

        car.remove("BMW");
        car.remove("Ford");

        car.put("Mazda", 5);
        car.put("BMW", 9);
        car.put("Audi", 2);

        System.out.println(car);
        System.out.println("Total car: " + car.size());

        //search for key
        String searchKey = "BMW";
        if (car.containsKey(searchKey))
            System.out.println("Found total " + car.get(searchKey) + " " + searchKey + " cars");

        // Clear all values.
        car.clear();

        // Equals to zero.
        System.out.println("After clear operation, size: " + car.size());
    }
    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            int result = o1.length() - o2.length();
            if (result == 0) {
                return o1.compareTo(o2);
            }
            return result;
        }
    }



}

