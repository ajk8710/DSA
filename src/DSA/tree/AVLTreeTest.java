package DSA.tree;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(94);
        tree.printInorder();
        tree.insert(33);
        tree.printInorder();
        tree.insert(50);
        
        tree.printLevelOrder();
        System.out.println();
        
        tree.printInorder();
        tree.insert(76);
        tree.printInorder();
        tree.insert(96);
        tree.printInorder();
        tree.insert(67);
        
        tree.printLevelOrder();
        System.out.println();
        
        tree.printInorder();
        tree.insert(56);
        tree.printInorder();
        tree.insert(65);
        tree.printInorder();
        tree.insert(83);
        tree.printInorder();
        tree.insert(34);
        tree.printInorder();
        
        tree.printLevelOrder();
        System.out.println();
        
        System.out.print("Delete 65: ");
        tree.delete(65);
        tree.printInorder();
        System.out.print("Delete 94: ");
        tree.delete(94);
        tree.printInorder();
        
        tree.printLevelOrder();
        System.out.println();
        
        System.out.print("Delete 67: ");
        tree.delete(67);
        tree.printInorder();
        System.out.print("Delete 76: ");
        tree.delete(76);
        tree.printInorder();
        System.out.print("Delete 0: ");
        tree.delete(0);  // non existing value
        tree.printInorder();
        System.out.println();
        
        tree.insert(67);
        tree.printInorder();
        tree.insert(67);
        tree.printInorder();
        tree.insert(1);
        tree.printInorder();
        tree.insert(3);
        tree.printInorder();
    }

}
