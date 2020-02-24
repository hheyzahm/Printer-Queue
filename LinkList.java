package printer;

public class LinkList {

    Node head;
    Node tail;
     

    public void addNodeAtHead(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
       
    }

    public void addNodeAtTail(int value) {
        Node n = new Node(value);
       
        if (head == null) {
            head = n;
            tail = n;
        } else {

            tail.next = n;
            tail = tail.next;
        }
    }

    public int deleteNodeFromHead() {
        if (head == null) {
            return -1;
        }
       
        head = head.next;
        return 1;

    }

    public int deleteNodeFromTail() {
        if (head == null) {
            return -1;
        }
        
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return 1;
    }

    public int getCurrentSize() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

}
