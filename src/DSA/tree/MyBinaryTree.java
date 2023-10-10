package DSA.tree;

public class MyBinaryTree {
    
    private Object[] arr = new Object[10];
    
    public MyBinaryTree() {
    }
    
    public MyBinaryTree(int capacity) {
        arr = new Object[capacity];
    }
    
    public MyBinaryTree(Object[] arr) {
        int len = arr.length;
        this.arr = new Object[len];
        for (int i = 0; i < len; i++) {
            this.arr[i] = arr[i];
        }
    }
    
    public void displayArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public Object getLeftChild(int index) {
        try {
            return arr[2 * index + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public Object getRightChild(int index) {
        try {
            return arr[2 * index + 2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public Object getParent(int index) {
        try {
            return arr[(index - 1) / 2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public void printInorder() {
        inorder(0);
        System.out.println();
    }
    
    private void inorder(int i) {
        if (i < arr.length && arr[i] != null) {  // short circuit
            inorder(2 * i + 1);
            System.out.print(arr[i] + " ");
            inorder(2 * i + 2);
        }
    }
    
    public void printPreorder() {
        preorder(0);
        System.out.println();
    }
    
    private void preorder(int i) {
        if (i < arr.length && arr[i] != null) {  // short circuit
            System.out.print(arr[i] + " ");
            preorder(2 * i + 1);
            preorder(2 * i + 2);
        }
    }
    
    public void printPostorder() {
        postorder(0);
        System.out.println();
    }
    
    private void postorder(int i) {
        if (i < arr.length && arr[i] != null) {  // short circuit
            postorder(2 * i + 1);
            postorder(2 * i + 2);
            System.out.print(arr[i] + " ");
        }
    }
}
