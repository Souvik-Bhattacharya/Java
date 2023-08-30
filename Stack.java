class Array {
    int si[];
    double sd[];
    String ss[];
    int top;

    Array(int size) {
        si = new int[size];
        top = -1;
    }

    Array(double size) {
        sd = new double[(int) size];
        top = -1;
    }

    Array(String size) {
        ss = new String[Integer.parseInt(size)];
        top = -1;
    }

    void push(int data) {
        if (top == si.length - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            si[top] = data;
            System.out.println(data + " is pushed into the stack!");
        }
    }

    void push(double data) {
        if (top == sd.length - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            sd[top] = data;
            System.out.println(data + " is pushed into the stack!");
        }
    }

    void push(String data) {
        if (top == ss.length - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            ss[top] = data;
            System.out.println(data + " is pushed into the stack!");
        }
    }

    void pop_i() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println(si[top] + " is popped from the stack!");
            si[top] = 0;
            top--;
        }
    }

    void pop_d() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println(sd[top] + " is popped from the stack!");
            sd[top] = 0.0;
            top--;
        }
    }

    void pop_s() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println(ss[top] + " is popped from the stack!");
            ss[top] = null;
            top--;
        }
    }

    void display(String type) {
        System.out.print("\nThe stack is:");
        if (type == "int") {
            for (var e : si) {
                System.out.print(" " + e);
            }
        } else if (type == "double") {
            for (double e : sd) {
                System.out.print(" " + e);
            }
        } else {
            for (String e : ss) {
                System.out.print(" " + e);
            }
        }
        System.out.println();
    }
}

public class Stack {
    public static void main(String args[]) {
        Array s1 = new Array(5);
        Array s2 = new Array(5.0);
        Array s3 = new Array("5");

        s1.push(1);
        s1.push(2);
        s1.pop_i();
        s1.display("int");

        System.out.println();
        s2.push(1.0);
        s2.push(2.0);
        s2.pop_d();
        s2.display("double");

        System.out.println();
        s3.push("1");
        s3.push("2");
        s3.pop_s();
        s3.display("string");
    }
}