import java.util.*;

/**
 * Traverse the implicit binary tree in 'treeArr' starting at 'rootIndex'
 * in the order specified by 'order'.  Print each node's content to
 * standard output as it is processed by the traversal.
 */
public class TraverseImplicitBT {

        static void traverse(String order, int rootIndex, int[] treeArr) {
                if (treeArr.length < 1) {
                        return;
                }
                if (rootIndex >= treeArr.length) {
                        System.out.println("Invalid");
                        return;
                } else {
                        traverseHelper(order, 1, treeArr);
                }
        }

        static void traverseHelper(String order, int rootIndex, int[] treeArr) {
                if (rootIndex >= treeArr.length) {
                        return;
                }
                if (order == "pre") {
                        System.out.println(treeArr[rootIndex]);
                        traverseHelper(order, rootIndex * 2, treeArr);
                        traverseHelper(order, rootIndex * 2 + 1, treeArr);
                } else if (order == "post") {
                        traverseHelper(order, rootIndex * 2, treeArr);
                        traverseHelper(order, rootIndex * 2 + 1, treeArr);
                        System.out.println(treeArr[rootIndex]);
                }
        }

        // for Code Visualizer
        public static void main(String[] args) {
                int[] tree = { 0, 1, 2, 3, 4, 5, 6 };

                traverse("post",1, tree);
        }
}
