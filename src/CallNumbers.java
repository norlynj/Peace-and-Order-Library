public class CallNumbers {
    private Node head;
    private int size;

   /*
    Implement the methods of the interface
   */

   private class Node {
       private final int data;
       private Node next;

       public Node(int data) {
           this.data = data;
       }
   }

    public CallNumbers(){
        this.head = null;
        this.size = 0;
    }

    //insert the element in ascending order, any insertion must follow the order
    public void addElement(int element){
        Node newNode = new Node(element);
        Node temp;

        //if element already exist
        if (getCallNumber(element) != -1){
            System.out.println("Element already exist in the list");
            return;
        }

        //if value of new node is smaller than head node, then insert the node at the start
        if (head == null ||head.data >= newNode.data){
            newNode.next = head;
            head = newNode;
        }

        else {
            temp = head; //locate the node before point of insertion
            while (temp.next != null && temp.next.data < newNode.data){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++; //increments list size

        System.out.println(element + " added!");
    }

    // remove an element if found in the list
    public void removeElement(int element){
        //store head node
        Node temp = head, prev = null;

        //if the element can't be found in the linked list
        if (getCallNumber(element) == -1){
            System.out.println("Element is not in the list");
            return;
        }

        //if head node holds the element
        if (temp != null && temp.data == element){
            head = temp.next;
        }
        else {
            //search for the element to be deleted,
            // keep track of the prev node as we need to change temp.next
            while (temp != null && temp.data != element) {
                prev = temp;
                temp = temp.next;
            }
            if (prev != null && temp != null) {
                prev.next = temp.next; //unlink the node from the linked list
            }
        }
        size--; //decrements list size
        System.out.println(element + " removed!");
    }

    //check if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //returns the size of the list
    public int size(){
        return size;
    }

    //returns the call number to left of the element specified
    public int getLeftCallNumber(int element){
        Node temp = head, prev = null;

        //loop through the list if temp is not null
        while (temp != null){
            if(temp.data == element){
                if (prev != null) {
                    return prev.data; //returns the left call number
                }
                else
                    return -1;
            }
            prev = temp;
            temp = temp.next;
        }
        return -1;

    }

    //returns the call number to right of the element specified
    public int getRightCallNumber(int element){
        Node temp = head;

        //loop through the list if temp is not null
        while (temp != null){
            if(temp.data == element) {
                if (temp.next != null) {
                    return temp.next.data; //returns the right call number
                } else {
                    return -1;
                }
            }
            temp = temp.next;
        }
       return -1;
    }

    //returns the call number if found in the list, otherwise returns -1
    public int getCallNumber(int element){
       //create a temp node pointing to head
       Node temp = head;

       //loop through the list if temp is not null
       while (temp != null){
           if(temp.data == element){
               return element; //return element if found
           }
           temp = temp.next;
       }

       return -1;
    }

    //displays the call numbers in the list
    public void displayCallNumbers(){
        //store head node
       Node temp = head;
        if(head == null){
            return;
        }
        //loops while temp is not null
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
