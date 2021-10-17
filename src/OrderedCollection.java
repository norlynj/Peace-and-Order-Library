public interface OrderedCollection {

    // adds an element and maintains the order
    void addElement(int element);

    // remove an element if found in the list
    void removeElement(int element);

    //check if the list is empty
    boolean isEmpty();

    //returns the size of the list
    int size();

    //returns the call number to left of the element specified
    int getLeftCallNumber(int element);

    //returns the call number to right of the element specified
    int getRightCallNumber(int element);

    //returns the call number if found in the list, otherwise returns -1
    int getCallNumber(int element);

    //displays the call numbers in the list
    void displayCallNumbers();

}


