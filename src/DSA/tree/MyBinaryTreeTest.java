package DSA.tree;

public class MyBinaryTreeTest {

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree(new Character[] {'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', null, null, 'V', null, 'J', 'L'});
        tree.displayArray();
        System.out.println(tree.getLeftChild(0));
        System.out.println(tree.getRightChild(0));
        System.out.println(tree.getLeftChild(1));
        System.out.println(tree.getRightChild(1));
        System.out.println(tree.getLeftChild(9));
        System.out.println(tree.getRightChild(9));
        System.out.println(tree.getParent(9));
        tree.printInorder();
        tree.printPreorder();
        tree.printPostorder();
    }

}
/*
 *            D
 *       A        F
 *     E   B    R   T
 *    G Q      V   J L
 */
