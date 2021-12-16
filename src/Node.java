public class Node {
         private Node left;
         private Node right;
        private Words data;
         int height;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public Words getData() {
        return data;
    }

    public void setData(Words data) {
        this.data = data;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Words n)
    {
        data = n;

    }
}
