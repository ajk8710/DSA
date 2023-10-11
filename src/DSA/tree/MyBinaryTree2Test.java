package DSA.tree;

public class MyBinaryTree2Test {
    
    public static void main(String[] args) {
        MyBinaryTree2 tree = new MyBinaryTree2(new Character[] {'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', null, null, 'V', null, 'J', 'L'});
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
