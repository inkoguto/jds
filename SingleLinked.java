import java.util.ArrayList;
import java.util.List;

public class SingleLinked {
    public static void main(String []args) {
        SingleLinkedList slinkedl = new SingleLinkedList();

        slinkedl.addAtEnd(new Node(0));
        slinkedl.addAtEnd(new Node(1));
        slinkedl.addAtEnd(new Node(2));
        slinkedl.addAtEnd(new Node(3));
        slinkedl.addAtEnd(new Node(6));
        slinkedl.addAtBegin(new Node(54));
        System.out.println("original linked list");
        slinkedl.display();
        
        System.out.println("After delete 1");
        slinkedl.delete(1);
        slinkedl.display();

        System.out.println("after insert 66 after 2");
        slinkedl.add(2, new Node(66));
        slinkedl.display();

        System.out.println("after reverse");
        slinkedl.reverse();
        slinkedl.display();

        System.out.println("after sort");
        slinkedl.sort();
        slinkedl.display();
    }
}

class Node {
    private Integer value;
    private Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public void setNext(Node node) {
        this.next = node;
    }
    public Node getNext() {
        return this.next;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

class SingleLinkedList {
    private Node head;

    public SingleLinkedList() { }

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void addAtEnd(Node node) {
        Node current = this.head;
        if (current == null) {
            this.head = node;
            
            return;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
    }

    public void addAtBegin(Node node) {
        node.setNext(this.head);
        this.head = node;
    }

    public void add(Integer key, Node node) {
        Node current = this.head;

        while (current != null) {
            if (current.getValue() == key) {
                node.setNext(current.getNext());
                current.setNext(node);
                break;
            }
            current = current.getNext();
        }
    }

    public List<Node> traverse() {
        List<Node> list = new ArrayList<Node>();
        Node current = this.head;
        while (current != null) {
            list.add(current);
            current = current.getNext();
        }
        return list;
    }

    public void display() {
        this.traverse().forEach(node->System.out.println(node.getValue()));
    }

    public void delete(Integer key) {
        Node current = this.head;
        if (current.getValue() == key) {
            this.head = current.getNext();

            return;
        }
        while (current != null) {
            Node next = current.getNext();
            if (next.getValue() == key) {
                current.setNext(next.getNext());
                next = null;
                break;
            }
            current = current.getNext();
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = this.head;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        this.head = prev;
    }

    public Integer size() {
        Integer size = 0;
        Node current = this.head;

        while (current != null) {
            size += 1;
            current = current.getNext();
        }

        return size;
    }

    public void sort() {
        Node current = this.head;
        Node next = null;
        Integer size = this.size();
        Integer tmpValue = null;
        int i, j, k;
        k = size;
        for (i = 0; i < size - 1; i++, k--) {
            current = this.head;
            next = current.getNext();
            for (j = 1; j < k; j++) {
                if (current.getValue() > next.getValue()) {
                    tmpValue = current.getValue();
                    current.setValue(next.getValue());
                    next.setValue(tmpValue);
                }
                current = current.getNext();
                next = current.getNext();
            }
        }
    }

}
