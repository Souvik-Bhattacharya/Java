package producer_consumer;

class SharedVariables{
    private int x = 0;
    private boolean isProduced = false;
    private boolean isConsumed = false;

    public synchronized void produce(){
        while(isProduced){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        x++;
        isProduced = true;
        isConsumed = false;
        notifyAll();
    }

    public synchronized void consume(){
        while(isConsumed){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Consumed "+x);
        isConsumed = true;
        isProduced = false;
        notifyAll();
    }
}

class Producer extends Thread{
    SharedVariables shared;

    Producer(SharedVariables shared){
        this.shared = shared;
    }

    @Override
    public void run(){
        while(true){
            shared.produce();
        }
    }
}

class Consumer extends Thread{
    SharedVariables shared;

    Consumer(SharedVariables shared){
        this.shared = shared;
    }

    @Override
    public void run(){
        while(true){
            shared.consume();
        }
    }
}

public class ProducerConsumer{
    public static void main(String[] args){
        SharedVariables shared = new SharedVariables();
        Producer producer = new Producer(shared);
        Consumer consumer = new Consumer(shared);
        producer.start();
        consumer.start();
    }
}