/**
 * Find the longest substring in two given strings.
 */
public class LongestSubstring {
        // a 2-D array ( row for s1, column for s2)
        // if s1[i] == s2[j], assign 1; if not assign 0
        // find the longest diagonal with continuous 1
        public static int findLongestSubstring(String s1, String s2) {
                int res = 0;
                int index = 0; // for getting the substring instead of length
                int n1 = s1.length();
                int n2 = s2.length();
                if (n1 == 0 || n2 == 0) {
                        return res;
                }
                int[][] array = new int[n1][n2];
                for (int i = 0; i < n1; i++) {
                        for (int j = 0; j < n2; j++) {
                                if (s1.charAt(i) == s2.charAt(j)) {
                                        if (i == 0 && j == 0) {
                                                array[i][j] = 1;
                                        } else {
                                                array[i][j] = array[i - 1][j - 1] + 1;
                                        }
                                }
//                                res = Math.max(res, array[i][j]);
                                if (array[i][j] > res) {
                                        res = array[i][j];
                                        // if we want to get this substring instead of the length
                                        index = i;
                                        // the output substring should be s1.subString(res - index + 1, res + 1)
                                }


                        }
                }
                return res;

        }

        public static void main(String[] args) {
                String s1 = "acbcbcef";
                String s2 = "abcbced";
                int res = findLongestSubstring(s1, s2);
                System.out.println(res);
        }
}
