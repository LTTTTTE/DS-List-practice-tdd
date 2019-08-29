public class Node<Integer> {
    private Integer data;
    private Node next;
    private Node prev;

    public Node(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
