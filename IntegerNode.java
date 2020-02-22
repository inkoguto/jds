public class IntegerNode extends Node {
    private Integer value;

    public IntegerNode(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

}