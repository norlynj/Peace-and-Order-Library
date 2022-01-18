import java.util.Scanner;

public class Library {
    DeweyDecimalSystem[] deweyDecimalSystem;
    Scanner in;
    int callNum = 0;
    int index = 0;

    public Library(){
        deweyDecimalSystem = new DeweyDecimalSystem[10];
        deweyDecimalSystem[0] = new DeweyDecimalSystem();
        deweyDecimalSystem[1] = new DeweyDecimalSystem();
        deweyDecimalSystem[2] = new DeweyDecimalSystem();
        deweyDecimalSystem[3] = new DeweyDecimalSystem();
        deweyDecimalSystem[4] = new DeweyDecimalSystem();
        deweyDecimalSystem[5] = new DeweyDecimalSystem();
        deweyDecimalSystem[6] = new DeweyDecimalSystem();
        deweyDecimalSystem[7] = new DeweyDecimalSystem();
        deweyDecimalSystem[8] = new DeweyDecimalSystem();
        deweyDecimalSystem[9] = new DeweyDecimalSystem();

        in = new Scanner(System.in);
    }

    //menu for options
    public void showMenu(){
        String choice = "";

        while(!choice.equals("Q")){
            String format = "%-40s%s%n"; //this is for indention
            System.out.println("Maintaining Peace and Order in the Library");

            System.out.println("Choose one to continue: ");
            System.out.printf(format, "(A) Add element", "(X) Remove element");
            System.out.printf(format, "(S) Get list size", "(E) Check if list is empty");
            System.out.printf(format, "(L) Get call number to the left", "(R) Get call number to the right");
            System.out.printf(format, "(C) Get call number", "(D) Display call number");
            System.out.printf(format, "(T) Get total", "(Q) Quit");

            choice = in.nextLine().toUpperCase();
            switch(choice){
                case "A":
                    getInput();
                    add(callNum, index);
                    break;
                case "X":
                    getInput();
                    remove(callNum, index);
                    break;
                case "S":
                    getInput();
                    listSize(index);
                    break;
                case "E":
                    getInput();
                    listIsEmpty(index);
                    break;
                case "R":
                    getInput();
                    getRightCN(callNum, index);
                    break;
                case "L":
                    getInput();
                    getLeftCN(callNum, index);
                    break;
                case "C":
                    getInput();
                    getCN(callNum, index);
                    break;
                case "T":
                    getTotal();
                    break;
                case "D":
                    getInput();
                    displayList(callNum, index);
                    break;
                case "Q":
                    System.exit(0);
                default:
                    System.out.println("You pressed the wrong key!");
            }
        }
    }

    //gets the input
    public void getInput(){
        //Gets the call number first
        System.out.println("Enter call number: ");
        while(!in.hasNextInt()) {
            System.out.println("Invalid!");
            in.next();
        }
        callNum = in.nextInt();
        in.nextLine();

        //gets the first digit of the call number as index
        index = firstNum(callNum);
    }

    //retrieve the first digit of a number to know what index to insert
    public int firstNum(int x){
        //if x < 100, just return 0
        if(x < 0 || x > 999) {
            System.out.println("Sorry, call number invalid.");
            showMenu();
        }
        if(x < 100) {
            return 0;
        }

        while(x > 9){
            x /= 10;
        }
        return x;
    }

    //inserts the book in the given index
    public void add(int cn, int i){
        deweyDecimalSystem[i].callNumbers.addElement(cn);
        System.out.println("\n");
    }

    //removes element
    public void remove(int cn, int i){
        deweyDecimalSystem[i].callNumbers.removeElement(cn);
        System.out.println("\n");
    }


    //gets the list size of that certain classification
    public void listSize(int i){
        int size = deweyDecimalSystem[i].callNumbers.size();
        System.out.println("Size of the list is " + size);
        System.out.println("\n");
    }

    //checks if list is empty
    public void listIsEmpty(int i){
        boolean empty = deweyDecimalSystem[i].callNumbers.isEmpty();
        if(empty){
            System.out.println("List is empty.\n");
        }
        else {
            System.out.println("List is not empty.\n");
        }
        System.out.println("\n");
    }

    //shows the call number to the right
    public void getRightCN(int cn, int i){
        int rightCN = deweyDecimalSystem[i].callNumbers.getRightCallNumber(cn);

        if(rightCN != -1){
            System.out.println("The call number to the right is "+ rightCN);
        }
        else{
            System.out.println("The call number to the right is null");
        }
        System.out.println("\n");
    }

    //shows the call number to the left
    public void getLeftCN(int cn, int i){
        int leftCN = deweyDecimalSystem[i].callNumbers.getLeftCallNumber(cn);
        if(leftCN != -1){
            System.out.println("The call number to the left is "+ leftCN);
        }
        else{
            System.out.println("The call number to the left is null");
        }
        System.out.println("\n");
    }

    //checks if it exists in the list
    public void getCN(int cn, int i){

        int getCallNum = deweyDecimalSystem[i].callNumbers.getCallNumber(cn);

        //if call num exist
        if(getCallNum != -1){
            System.out.println("The call number "+ cn + " exists on the list.");
        }
        //if call num DNE
        else{
            System.out.println("The call number "+ cn + " does not exist on the list.");
        }

        System.out.println("\n");
    }

    //returns total number of call numbers already inserted from all of the linked list
    public void getTotal(){
        int sum = 0;
        for (int i = 0; i < deweyDecimalSystem.length; i++) {
            if (deweyDecimalSystem[i] != null) {
                sum += deweyDecimalSystem[i].callNumbers.size();
            }
        }
        System.out.println("Total number of call numbers: " +sum);

        System.out.println("\n");
    }

    //display the call number in the list
    public void displayList(int cn, int i){
        System.out.println("\n(A) Display all\n(I) Display list on a specific index");
        String c = in.nextLine().toUpperCase();

        switch(c) {

            //if user wants to display all
            case "A":
                System.out.println("The call numbers in the list are...");
                for (i = 0; i < deweyDecimalSystem.length; i++) {
                    if (deweyDecimalSystem[i] != null) {
                        deweyDecimalSystem[i].callNumbers.displayCallNumbers();
                    }
                }
                System.out.println("\n");
                break;

            //if just on a certain index/ book classification
            case "I":
                boolean empty = deweyDecimalSystem[i].callNumbers.isEmpty();
                if (empty) {
                    System.out.println("The call numbers in the list " + cn + " is empty.");
                } else {
                    System.out.println("The call numbers in the list " + cn);
                    deweyDecimalSystem[i].callNumbers.displayCallNumbers();
                }
                System.out.println("\n");
                break;
        }

    }

    public static void main(String[] args){
        Library library = new Library();
        library.showMenu();
    }

}
