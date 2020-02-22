import java.util.List;
import java.util.ArrayList;

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