package TreeBFS;

import java.util.*;

public class ConnectAllSiblings {
    public static void connect(TreeNodeConnect root) {
        if (root == null)
            return;

        Queue<TreeNodeConnect> queue = new LinkedList<>();
        queue.offer(root);
        TreeNodeConnect currentNode = null, previousNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (previousNode != null)
                previousNode.next = currentNode;
            previousNode = currentNode;

            // insert the children of current node in the queue
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNodeConnect root = new TreeNodeConnect(12);
        root.left = new TreeNodeConnect(7);
        root.right = new TreeNodeConnect(1);
        root.left.left = new TreeNodeConnect(9);
        root.right.left = new TreeNodeConnect(10);
        root.right.right = new TreeNodeConnect(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNodeConnect current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
