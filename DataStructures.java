public class DataStructures {
    public static void main(String []args) {
        SingleLinkedList slinkedl = new SingleLinkedList();

        slinkedl.addAtEnd(new IntegerNode(0));
        slinkedl.addAtEnd(new IntegerNode(1));
        slinkedl.addAtEnd(new IntegerNode(2));
        slinkedl.addAtEnd(new StringNode("test"));
        slinkedl.addAtEnd(new IntegerNode(3));
        System.out.println("original linked list");
        slinkedl.display();
        
        System.out.println("After delete 1");
        slinkedl.delete(1);
        slinkedl.display();
    }
}