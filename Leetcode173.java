import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    // Returns the next smallest number
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }

    // Returns whether we have a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper method: Push all left children to stack
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Manually create the BST:
        //         7
        //        / \
        //       3   15
        //           / \
        //          9  20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Initialize iterator
        BSTIterator iterator = new BSTIterator(root);

        // Use the iterator
        System.out.println("BST In-order Traversal using Iterator:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
