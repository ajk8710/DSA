package DSA.linkedList.problems;

// Add two polynomials represented by linked list with node(coefficient, power, next).
// 4x5 + 5x4 + 2x3 + 3x2 + 7x
// 9x6 + 6x4 + 3x2
public class LinkedListAddPolynomials {

    public static void main(String[] args) {
        int[][] arr = {{4, 5}, {5, 4}, {2, 3}, {3, 2}, {7, 1}};
        LinkedListPoly list1 = new LinkedListPoly(arr);
        
        arr = new int[][] {{9, 6}, {6, 4}, {3, 2}};
        LinkedListPoly list2 = new LinkedListPoly(arr);
        
        list1.display();
        list2.display();
        
        NodePoly list3Head = addTwoPolynomials(list1.head, list2.head);
        LinkedListPoly list3 = new LinkedListPoly(list3Head);
        list3.display();
        
    }
    
    public static NodePoly addTwoPolynomials(NodePoly head1, NodePoly head2) {
        if (head1 == null) {  // if one or the other list is empty
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }
        
        LinkedListPoly returnList = new LinkedListPoly();
        NodePoly curr1 = head1;
        NodePoly curr2 = head2;
        while (curr1 != null && curr2 != null) {  // Go through the lists, compare their powers
            if (curr1.pow > curr2.pow) {          // If power of one list is bigger than the other, append node to return list. If power is same add them then append.
                returnList.append(curr1.coe, curr1.pow);  
                curr1 = curr1.next;
            }
            else if (curr2.pow > curr1.pow) {
                returnList.append(curr2.coe, curr2.pow);
                curr2 = curr2.next;
            }
            else {  // if curr1.pow == curr2.pow
                returnList.append(curr1.coe + curr2.coe, curr1.pow);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
        
        while (curr1 != null) {  // handle the leftovers
            returnList.append(curr1.coe, curr1.pow);  
            curr1 = curr1.next;
        }
        
        while (curr2 != null) {  // handle the leftovers
            returnList.append(curr2.coe, curr2.pow);  
            curr2 = curr2.next;
        }
        
        return returnList.head;
    }
}

class NodePoly {
    int coe;
    int pow;
    NodePoly next;
    
    public NodePoly() {
    }
    
    public NodePoly(int coe, int pow) {
        this.coe = coe;
        this.pow = pow;
    }
}

class LinkedListPoly {
    NodePoly head;
    NodePoly tail;
    int len = 0;
    
    public LinkedListPoly() {
    }
    
    public LinkedListPoly(int[][] initialData) {
        for (int i = 0; i < initialData.length; i++) {
            int coeff = initialData[i][0];
            int power = initialData[i][1];
            this.append(coeff, power);
            len++;
        }
    }
    
    public LinkedListPoly(NodePoly head) {
        this.head = head;
        NodePoly curr = head;
        while (curr != null && curr.next != null) {  // find a tail of passed list
            curr = curr.next;
        }
        this.tail = curr;
    }
    
    public void append(int coe, int pow) {
        NodePoly node = new NodePoly(coe, pow);
        
        if (head == null) {  // if empty list
            head = node;     // head points to new node
            tail = node;     // tail points to new node
        }
        else {                 // if not empty set
            tail.next = node;  // tail's next points to new node
            tail = node;       // new node is now tail
        }
        len++;
    }

    /*
    public void insert(int data) {
        NodePoly newNode = new NodePoly(data);
        
        NodePoly prev = null;
        NodePoly curr = head;
        
        if (len == 0) {  // if empty list
            head = newNode;
            tail = newNode;
            len++;
            return;
        }
        
        while (curr != null && newNode.data > curr.data) {  // traverse pointers
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == null) {  // inserting at the beginning
            newNode.next = curr;
            head = newNode;
        }
        else if (curr == null) {  // inserting at the end
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = curr;
            prev.next = newNode;
        }
        len++;
    }
    
    public void delete(int data) {
        NodePoly prev = null;
        NodePoly curr = head;
        
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        
        if (curr == null) {  // node with data is not found or list is empty
            return;
        }
        else if (prev == null) {  // node with data is the first node
            head = curr.next;
            if (curr == tail) {   // if delete results in empty list
                tail = null;
            }
            len--;
        }
        else {
            prev.next = curr.next;
            if (curr == tail) {  // if deleted last item
                tail = prev;
            }
            len--;
        }
    }
    */
    
    public void display() {
        NodePoly curr = head;  // use curr, not head. head is not to be updated.
        
        if (curr == null) {  // if empty list
            System.out.println();
            return;
        }
        else if (curr.next == null) {  // if list with only one node
            System.out.println(curr.coe + "X^" + curr.pow);
            return;
        }
        
        // at this point, there must be at least two nodes
        while (curr != tail) {
            System.out.print(curr.coe + "X^" + curr.pow + " + ");
            curr = curr.next;
        }
        System.out.println(curr.coe + "X^" + curr.pow);  // print tail
    }
    
    public int len() {
        return len;
    }
    
}
