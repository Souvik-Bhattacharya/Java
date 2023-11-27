package stack_with_object_class;

class Stack {
    Object s[];
    int top;

    Stack(int size) {
        s = new Object[size];
        top = -1;
    }
    
    void push(Object data) {
        if (top == s.length - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            s[top] = data;
            System.out.println(data + " is pushed into the stack!");
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println(s[top] + " is popped from the stack!");
            s[top] = null;
            top--;
        }
    }

    void display() {
        System.out.print("\nThe stack is:");
        for (Object e : s) {
            System.out.print(" " + e);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String args[]) {
        Stack s = new Stack(5);

        s.push(1);
        s.push(2);
        s.pop();
        s.display();

        System.out.println();
        
        s.push(1.0);
        s.push(2.0);
        s.pop();
        s.display();

        System.out.println();
        
        s.push("1");
        s.push("2");
        s.pop();
        s.display();
    }
}