package com.sdkr.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private class TreeNode {
        private int item;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node = " + item;
        }
    }

    private TreeNode root;

    public Tree() {
        root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        // root.right.left.left = new TreeNode(60);
        // root.right.left.right = new TreeNode(70);
        // root.right.right = new TreeNode(5);
        // root.right.right.right = new TreeNode(80);
        // root.right.left.right = new TreeNode(8);

        // root = null;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.item + " ");
            inOrder(root.right);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.item + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.item + " ");
        }
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode root) {
        if (root != null) {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        return 0;
    }

    public void nodesAtDistanceK(int k) {
        nodesAtDistanceK(root, k);
        System.out.println();
    }

    private void nodesAtDistanceK(TreeNode root, int k) {
        if (root != null) {
            if (k == 0)
                System.out.print(root.item + " ");
            else {
                nodesAtDistanceK(root.left, k - 1);
                nodesAtDistanceK(root.right, k - 1);
            }
        }
    }

    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }

    private void levelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var current = queue.poll();

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);

            System.out.print(current.item + " ");
        }
    }

    public void levelOrderLineByLine() {
        levelOrderLineByLine(root);
        // System.out.println();
    }

    private void levelOrderLineByLine1(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            var current = queue.poll();
            if (current == null) {
                queue.add(null);
                System.out.println();
            } else {
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);

                System.out.print(current.item + " ");
            }
        }
    }

    private void levelOrderLineByLine(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var queueSize = queue.size();
            while (queueSize-- != 0) {
                var current = queue.poll();

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);

                System.out.print(current.item + " ");
            }

            System.out.println();
        }

    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode root) {
        if (root != null) {
            int leftTreeSize = size(root.left);
            int rightTreeSize = size(root.right);

            return leftTreeSize + rightTreeSize + 1;
        }

        return 0;
    }

    public int maximum() {
        return maximum(root);
    }

    private int maximum(TreeNode root) {
        if (root != null) {
            int leftMaximum = maximum(root.left);
            int rightMximum = maximum(root.right);

            return Math.max(root.item, Math.max(leftMaximum, rightMximum));
        }

        return Integer.MIN_VALUE;
    }

    public void printLeftView() {
        printLeftView(root);
        System.out.println();
    }

    private void printLeftView(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            System.out.print(queue.peek().item + " ");
            var queueSize = queue.size();
            while (queueSize-- != 0) {
                var current = queue.poll();

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }

    public void hasChildrenSumProperty() {
        System.out.println(hasChildrenSumProperty(root) ? "YES" : "NO");
    }

    private boolean hasChildrenSumProperty(TreeNode root) {
        if (root == null)
            return true;

        var ans = true;

        ans &= hasChildrenSumProperty(root.left);
        ans &= hasChildrenSumProperty(root.right);

        if (root.left != null && root.right != null)
            return ans &= root.item == (root.left.item + root.right.item);
        else if (root.left != null)
            return ans &= root.item == (root.left.item);
        else if (root.right != null)
            return ans &= root.item == root.right.item;
        else
            return ans;
    }

    public boolean isBalanced() {
        return isBalanced(root) > 0 ? true : false;
    }

    public int isBalanced(TreeNode root) {
        if (root == null)
            return 0;

        var leftHeight = isBalanced(root.left);
        var rightHeight = isBalanced(root.right);

        if (leftHeight != -1 && rightHeight != -1) {
            if (Math.abs(leftHeight - rightHeight) <= 1) {
                return 1 + Math.max(leftHeight, rightHeight);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int maximumWidth() {
        return maximumWidth(root);
    }

    private int maximumWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            var queueSize = queue.size();
            maxWidth = Math.max(queueSize, maxWidth);
            while (queueSize-- != 0) {
                var current = queue.poll();
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return maxWidth;
    }

    private TreeNode previous;
    private TreeNode head;

    private void treeToList(TreeNode root) {
        if (root != null) {
            treeToList(root.left);
            if (previous != null) {
                previous.right = root;
            } else {
                this.head = root;
            }

            root.left = previous;
            previous = root;
            treeToList(root.right);
        }
    }

    public void getPostOrderOfConstructedTree(int[] inOrder, int[] preOrder) {
        var root = constructTree(inOrder, preOrder, 0, inOrder.length - 1);
        postOrder(root);
    }

    private int preOrderIndex;

    private TreeNode constructTree(int[] inOrder, int[] preOrder, int inOrderStartIndex, int inOrderEndIndex) {
        if (inOrderStartIndex > inOrderEndIndex) {
            return null;
        }

        var root = new TreeNode(preOrder[preOrderIndex++]);

        int inOrderIndex = 0;
        for (int i = inOrderStartIndex; i <= inOrderEndIndex; i++) {
            if (inOrder[i] == root.item) {
                inOrderIndex = i;
            }
        }

        root.left = constructTree(inOrder, preOrder, inOrderStartIndex, inOrderIndex - 1);
        root.right = constructTree(inOrder, preOrder, inOrderIndex + 1, inOrderEndIndex);

        return root;
    }

    private void printSpiral(TreeNode root) {
        if (root == null)
            return;

    }

    public void printSpiral() {
        printSpiral(root);
        System.out.println();
    }

    public void preOrderIterative() {
        if (root == null)
            return;

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            var current = stack.pop();
            System.out.print(current.item + " ");

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }

        System.out.println();
    }

    public void iterativeInorder() {
        if (root == null)
            return;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        // while (stack.isEmpty()) {
        // if ()
        // }
    }
}
