public class LinkedListBook {

    class Node {
        Book data;
        Node next;
        Node prev; 

        Node(Book b) { 
            data = b; 
            next = null;
            prev = null;
        }
    }

    Node head;
    Node tail; 

    public void addBook(Book b) {
        if (isIdExists(b.id)) {
            System.out.println("Error: ID '" + b.id + "' sudah digunakan!");
            return;
        }

        Node newNode = new Node(b);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean isIdExists(String id) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.id.equals(id)) {
                return true; 
            }
            cur = cur.next;
        }
        return false; 
    }

    public void showBooks() {
        if (head == null) {
            System.out.println("  (Tidak ada buku saat ini)");
            return;
        }

        Node cur = head;
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║            DAFTAR SEMUA BUKU (DOUBLY LL)           ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        
        int count = 1;
        while (cur != null) {
            Book b = cur.data;
            System.out.println("------------------------------------------------------");
            System.out.println(count + ". ID    : " + b.id);
            System.out.println("   Judul : " + b.title);
            System.out.println("   Penulis: " + b.author);
            System.out.println("   Tahun : " + b.year + " | Stok: " + b.stock);
            
           
            cur = cur.next;
            count++;
        }
        System.out.println("------------------------------------------------------");
    }
    
    public Book searchBook(String id) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.id.equals(id)) {
                return cur.data;
            }
            cur = cur.next;
        }
        return null;
    }

    public void sortByTitle() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node cur = head;
            while (cur.next != null) {
                if (cur.data.title.compareToIgnoreCase(cur.next.data.title) > 0) {
                    Book temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while (swapped);
        System.out.println("Sukses: Buku diurutkan berdasarkan Judul.");
        showBooks();
    }
    
    public void sortById() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node cur = head;
            while (cur.next != null) {
                if (cur.data.id.compareTo(cur.next.data.id) > 0) {
                    Book temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while (swapped);
        System.out.println("Sukses: Buku diurutkan berdasarkan ID.");
        showBooks();
    }
}