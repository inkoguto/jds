public abstract class Node {
    private Node next;

    public void setNext(Node node) {
        this.next = node;
    }
    public Node getNext() {
        return this.next;
    }

    abstract public Object getValue();
}