public class BookTree {

    class Node {
        Book data;
        Node left, right;

        Node(Book b) { data = b; }
    }

    Node root;

    public void insert(Book b) {
        root = insertRec(root, b);
    }

    private Node insertRec(Node r, Book b) {
        if (r == null) return new Node(b);

        if (b.id < r.data.id)
            r.left = insertRec(r.left, b);
        else
            r.right = insertRec(r.right, b);

        return r;
    }

    public Book search(int id) {
        return searchRec(root, id);
    }

    private Book searchRec(Node r, int id) {
        if (r == null) return null;
        if (id == r.data.id) return r.data;

        return (id < r.data.id) ? searchRec(r.left, id) : searchRec(r.right, id);
    }
}
