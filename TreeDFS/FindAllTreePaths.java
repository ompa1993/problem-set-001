package TreeDFS;
import java.util.*;
/*
* Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
*
* This problem follows the Binary Tree Path Sum pattern. We can follow the same DFS approach. There will be two differences:

Every time we find a root-to-leaf path, we will store it in a list.
We will traverse all paths and will not stop processing after finding the first path.
* */


public class FindAllTreePaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum){
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {

        if (root == null){
            return;
        }

        //add the current node to currentPath
        currentPath.add(root.val);

        //if sum is equal to the value of the current node, we have found a path. Add path to all paths
        if (root.val == sum && root.left == null && root.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            //traverse the left sub-tree
            findPathsRecursive(root.left, sum - root.val, currentPath, allPaths);

            //traverse the right sub-tree
            findPathsRecursive(root.right, sum - root.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }


}
