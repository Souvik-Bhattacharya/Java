package myPackage;

import service.OperatorService;

public class Test {
    public static void main(String[] args) {
        OperatorService<String> operator = new OperatorService<>();

        operator.enqueue("Customer 1");
        operator.enqueue("Customer 2");
        operator.enqueue("Customer 3");

        operator.dequeue();
        operator.dequeue();
        operator.dequeue();
    }
}
