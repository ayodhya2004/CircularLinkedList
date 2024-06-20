package linkedlist;


public class CircularLinkedList<T> {
    private CNode<T> tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    public void addToFront(T data) {
        CNode<T> newNode = new CNode<>(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    public void addToEnd(T data) {
        CNode<T> newNode = new CNode<>(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFromFront() {
        if (tail == null) return;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }

    public void removeFromEnd() {
        if (tail == null) return;
        if (tail.next == tail) {
            tail = null;
        } else {
            CNode<T> current = tail;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
    }

    public void printList() {
        if (tail == null) return;
        CNode<T> current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addToFront(10);
        list.addToFront(20);
        list.addToEnd(30);
        list.addToEnd(40);

        System.out.print("List: ");
        list.printList(); // Output: 20 10 30 40 

        list.removeFromFront();
        System.out.print("After removing from front: ");
        list.printList(); // Output: 10 30 40 

        list.removeFromEnd();
        System.out.print("After removing from end: ");
        list.printList(); // Output: 10 30 
    }
}