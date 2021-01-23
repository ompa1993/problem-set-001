package TreeDFS;

public class PathWithGivenSequence {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }

    private static boolean findPath(TreeNode root, int[] sequence) {

        if (root == null){
            return sequence.length == 0;
        }

        return findPathRecursive(root, sequence, 0);

    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {
        if (currentNode == null){
            return false;
        }

        //if we have reached at the end and sequence has not been found
        if (sequenceIndex > sequence.length || currentNode.val != sequence[sequenceIndex]){
            return false;
        }

        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1){
            return true;
        }

        return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
                || findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
    }
}
