# Peace-and-Order-Library

This program maintains an array with a maximum of 10 elements where each element is a linked list. 
Each index in the array corresponds to the Dewey Decimal call number classification e.g index 0 
corresponds to 000, index 1 corresponds to 100, and so on.


Technical Requirement Summary
• The solution shall insert a book using its call number where the first digit of the 
call number indicates the classification it falls within
• The solution shall enable the user to retrieve the call number assigned to its left 
and right once the call number is inserted
• The insertion order of the elements in each list shall be in an ascending manner
• The solution shall remove a call number in a list
• The solution shall check if the list is empty, retrieve the size of the linked list, and 
get the total number of lists inserted.
• The solution shall display the linked list inserted, either on a specific list, or the 
entire list created


Java class and Purpose

Ordered Collection (interface)
The OrderedCollection interface defines the behavior of call numbers.

CallNumbers 
The CallNumbers class implements the methods defined in the interface. 

DeweyDecimalSystem 
DeweyDecimalSystem class instantiates the CallNumbers class. It is created to maintain an array with a maximum of 10 elements, 
where each element is a linked list. The array is initialized at the Library class.

Library 
The Library class is the main class. It implements the user input handling and processing. It initializes an array of 
DeweyDecimalSystem object to create an array of linked lists so that it can add and remove book call numbers.
