import java.util.Stack;

public class BorrowHistory {
    Stack<String> history = new Stack<>();

    public void push(String data) {
        history.push(data);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("History kosong!");
            return;
        }

        System.out.println("=== HISTORY PEMINJAMAN ===");
        for (String h : history)
            System.out.println(h);
    }
}
