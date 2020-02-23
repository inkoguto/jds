import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SingleLinked {
    public static void main(String []args) {
        SingleLinkedList slinkedl = new SingleLinkedList();
        ListHandler handler = new ListHandler();
        slinkedl = handler.populate(slinkedl);
        handler.print(slinkedl, "original list");
        slinkedl.sort();
        handler.print(slinkedl, "sorted list");
    }
}

class ListHandler {
    public SingleLinkedList populate(SingleLinkedList list) {
        Random random = new Random();
        int range = 100000;
        for (int i = 0; i <= range; i++) {
            list.addAtEnd(new Node(random.nextInt((range - 0) + 1)));
        }

        return list;
    }

    public void print(SingleLinkedList list, String message) {
        System.out.println(message);
        list.display();
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
