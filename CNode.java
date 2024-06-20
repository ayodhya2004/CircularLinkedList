package linkedlist;

public class CNode<T> {
    T data;
    CNode<T> next;

    public CNode(T data) {
        this.data = data;
        this.next = null;
    }
}
