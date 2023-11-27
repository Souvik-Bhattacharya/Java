package threads_with_factors_factorial;

import java.util.Scanner;

class FactorialThread extends Thread{
    int number;

    FactorialThread(int number){
        this.number = number;
    }

    @Override
    public void run(){
        int factorial = 1;

        for(int i = 1; i <= number; i++){
            factorial *= i;
        }

        System.out.println("The factorial of "+number+" is "+factorial);
    }
}

class FactorThread extends Thread{
    int number;

    FactorThread(int number){
        this.number = number;
    }

    @Override
    public void run(){
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                System.out.println(i+" is a factor of "+number);
            }
        }
    }
}

public class Main {
    public static void main(String[] args){
        int number;
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        sc.close();

        FactorialThread factorial = new FactorialThread(number);
        FactorThread factor = new FactorThread(number);

        factor.start();
        factorial.start();

        try {
            factor.join();
            factorial.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Exiting main...");
    }
}
