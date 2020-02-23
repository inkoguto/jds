import java.util.ArrayList;
import java.util.List;

public class SingleLinked {
    public static void main(String []args) {
        SingleLinkedList slinkedl = new SingleLinkedList();

        slinkedl.addAtEnd(new Node(0));
        slinkedl.addAtEnd(new Node(1));
        slinkedl.addAtEnd(new Node(2));
        slinkedl.addAtEnd(new Node(3));
        System.out.println("original linked list");
        slinkedl.display();
        
        System.out.println("After delete 1");
        slinkedl.delete(1);
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
        if (current.getValue() instanceof Integer && current.getValue() == key) {
            this.head = current.getNext();

            return;
        }
        while (current != null) {
            Node next = current.getNext();
            if (next.getValue() instanceof Integer && next.getValue() == key) {
                current.setNext(next.getNext());
                next = null;
                break;
            }
        }
    }

    public void delete(String key) {
        
    }

}
