package DSA.Stack;

public class FixedUndoStack {

    private final String[] data;
    private int top;

    // Constructor
    public FixedUndoStack(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    // Push a new edit into the stack
    public boolean push(String edit) {
        if (top == data.length - 1) {
            System.out.println("Undo buffer is full.");
            return false;
        }

        data[++top] = edit;
        return true;
    }

    // Remove the most recent edit
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo.");
        }

        return data[top--];
    }

    // View the most recent edit
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Undo buffer is empty.");
        }

        return data[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Main method
    public static void main(String[] args) {

        FixedUndoStack undoStack = new FixedUndoStack(3);

        System.out.println("Push Type A: " + undoStack.push("Type A"));
        System.out.println("Push Type B: " + undoStack.push("Type B"));
        System.out.println("Push Type C: " + undoStack.push("Type C"));

        // This push will fail because the stack is full
        System.out.println("Push Type D: " + undoStack.push("Type D"));

        // Peek at the latest edit
        System.out.println("Latest Edit: " + undoStack.peek());

        // Undo the latest edit
        System.out.println("Undo: " + undoStack.pop());

        // Peek again
        System.out.println("Latest Edit after Undo: " + undoStack.peek());

        // Undo remaining edits
        System.out.println("Undo: " + undoStack.pop());
        System.out.println("Undo: " + undoStack.pop());

        // Check if stack is empty
        System.out.println("Is Empty: " + undoStack.isEmpty());
    }
}