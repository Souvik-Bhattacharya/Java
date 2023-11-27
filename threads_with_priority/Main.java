package threads_with_priority;

class Counter extends Thread{
    int counter = 0;

    Counter(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i = 0; i < 3; i++){
            counter++;
            System.out.println(Thread.currentThread().getName()+" is counting "+counter);
        }
    }
}

public class Main {
    public static void main(String[] args){
        Counter highCounter = new Counter("High");
        Counter normalCounter = new Counter("normal");
        Counter lowCounter = new Counter("low");

        highCounter.setPriority(Thread.MAX_PRIORITY);
        normalCounter.setPriority(Thread.NORM_PRIORITY);
        lowCounter.setPriority(Thread.MIN_PRIORITY);

        
        highCounter.start();
        normalCounter.start();
        lowCounter.start();
        
        try {
            highCounter.join();
            normalCounter.join();
            lowCounter.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Exiting main...");
    }
}
