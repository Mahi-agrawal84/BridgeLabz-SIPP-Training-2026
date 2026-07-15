package DSA.Stack;

public class FunctionCallStack {

    private static class Frame {
        String functionName;
        Frame next;

        public Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top;

    public FunctionCallStack() {
        top = null;
    }

    // Push a function call onto the stack
    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    // Pop the most recent function call
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to return from.");
        }

        String name = top.functionName;
        top = top.next;
        return name;
    }

    // Peek at the currently executing function
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Call stack is empty.");
        }

        return top.functionName;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {

        FunctionCallStack callStack = new FunctionCallStack();

        callStack.push("main()");
        callStack.push("login()");
        callStack.push("validateUser()");

        System.out.println("Current Function: " + callStack.peek());

        System.out.println("Returned From: " + callStack.pop());

        System.out.println("Current Function: " + callStack.peek());

        callStack.push("displayDashboard()");

        System.out.println("Current Function: " + callStack.peek());

        while (!callStack.isEmpty()) {
            System.out.println("Returning From: " + callStack.pop());
        }
    }
}