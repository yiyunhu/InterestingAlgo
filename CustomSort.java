import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Sort by frequency of each numbers
 * If frequency are same, sort the number itself in ascending order.
 */
public class CustomSort {
        static void customSort(int[] arr) {
                // a map to store frequency of each number
                Map<Integer, Integer> frequency = new HashMap<>();
                for (int i: arr) {
                        frequency.put(i, frequency.getOrDefault(i, 0) + 1);
                }

                // int array cannot use comparator
                Integer res[] = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                        res[i] = arr[i];
                }
                Arrays.sort(res, new Comparator<Integer>()
                        {
                                public int compare(Integer a, Integer b) {
                                        if (frequency.get(a) > frequency.get(b)) {
                                                return 1;
                                        } else if (frequency.get(a) < frequency.get(b)) {
                                                return -1;
                                        } else {
                                                return a - b;
                                        }
                                }
                        });
                for (int i = 0; i < arr.length; i++) {
                        arr[i] = res[i];
                }
        }

        public static void main(String[] args) {
                int[] values = {3, 1, 2, 4, 2};
                customSort(values);
                for (int i = 0; i < values.length; i++) {
                        System.out.println(values[i]);
                }

        }
}
