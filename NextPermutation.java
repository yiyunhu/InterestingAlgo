/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr:
 * [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 *
 * The next permutation of an array of integers is the next lexicographically
 * greater permutation of its integer. More formally, if all the permutations
 * of the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that follows
 * it in the sorted container. If such arrangement is not possible, the array
 * must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * LC 31.
 */
public class NextPermutation {
        public static void nextPermutation(int[] nums) {
                // e.g. 1 3 5 8 6 2 1 0
                // from the last digit, find the first digit not ascending: 5
                // find 6, swap -> 1 3 6 8 5 2 1 0
                // after digit 6, reverse all digits in ascending order
                int i = nums.length - 2;
                while (i >= 0 && nums[i + 1] <= nums[i]) {
                        i--;
                }

                if (i < 0) {
                        reverse(nums, 0);
                        return;
                }
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                        j--;
                }
                swap(nums, j, i);
                reverse(nums, i + 1);
        }

        private static void swap(int[] nums, int a, int b) {
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
        }

        private static void reverse(int[] nums, int start) {
                int end = nums.length - 1;
                while (start < end) {
                        swap(nums, start, end);
                        start++;
                        end--;
                }
        }

        public static void main(String[] args) {
                int[] nums = new int[] {1, 5, 1};
                nextPermutation(nums);
                for (int i = 0; i < nums.length; i++) {
                        System.out.println(nums[i]);
                }
        }
}
