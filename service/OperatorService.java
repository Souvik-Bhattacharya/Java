package service;

import java.util.ArrayDeque;
import adInterface.Queue;

public class OperatorService<T> implements Queue<T> {
    java.util.Queue<T> queue = new ArrayDeque<>();

    @Override
    public void enqueue(T customer){
        queue.offer(customer);
        System.out.println("Ticket is generated for "+customer);
    }   

    @Override
    public void dequeue(){
        T customer = queue.poll();
        if (customer == null) {
            System.out.println("Queue is empty");
        }
        else System.out.println(customer+" is served");
    }
}
