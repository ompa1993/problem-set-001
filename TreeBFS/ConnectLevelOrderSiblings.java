package TreeBFS;

import java.util.*;

class TreeNodeConnect {
    int val;
    TreeNodeConnect left;
    TreeNodeConnect right;
    TreeNodeConnect next;

    TreeNodeConnect(int x){
        val = x;
        left = right = next = null;
    }

    public void printLevelOrder() {
        TreeNodeConnect nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeConnect current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}


public class ConnectLevelOrderSiblings {

    public static void main(String[] args) {
        TreeNodeConnect root = new TreeNodeConnect(12);
        root.left = new TreeNodeConnect(7);
        root.right = new TreeNodeConnect(1);
        root.left.left = new TreeNodeConnect(9);
        
        root.right.left = new TreeNodeConnect(10);
        root.right.right = new TreeNodeConnect(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

    private static void connect(TreeNodeConnect root) {
        if (root == null){
            return;
        }

        Queue<TreeNodeConnect> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNodeConnect previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++){
                TreeNodeConnect currentNode = queue.poll();

                if (previousNode != null){
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;

                if (currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }

        }
    }
}
