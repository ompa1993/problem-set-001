package TreeDFS;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {

    public static Integer findSumOfPathNumbers(TreeNode root){
        List<Integer> pathTotals = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, currentPath, pathTotals);

        return calculatePathSum(pathTotals);
    }

    private static void findPathsRecursive(TreeNode root, List<Integer> currentPath, List<Integer> allPaths) {

        if (root == null){
            return;
        }

        //add the current node to currentPath
        currentPath.add(root.val);

        //if sum is equal to the value of the current node, we have found a path. Add path to all paths
        if (root.left == null && root.right == null){
            Integer sumOfPath = calculateCurrentPathSum(currentPath);
            allPaths.add(sumOfPath);
        } else {
            //traverse the left sub-tree
            findPathsRecursive(root.left, currentPath, allPaths);

            //traverse the right sub-tree
            findPathsRecursive(root.right, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    private static Integer calculateCurrentPathSum(List<Integer> currentPath) {
        Integer sum = 0;
        int multiplier = 1;
        for (int i = currentPath.size() - 1; i >= 0; i--){
            sum += currentPath.get(i) * multiplier;
            multiplier *= 10;
        }
        return sum;
    }

    private static Integer calculatePathSum(List<Integer> currentPath) {
        Integer sum = 0;
        for (Integer num : currentPath){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
