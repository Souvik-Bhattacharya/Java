package exception_handling;

import java.util.Scanner;

class InvalidInputException extends Exception{
    int number;

    InvalidInputException(int number){
        this.number = number;
    }

    @Override
    public String toString(){
        return "InvalidInputException"+" ["+number+"]";
    }
}

class TestPrime{
    boolean isPrime(int number) throws InvalidInputException{
        if(number <= 1){
            throw new InvalidInputException(number);
        }

        for(int i = 2; i <= (int)Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        
        return true;
    }
}

public class Test {
    public static void main(String[] args){
        boolean result;
        int number;
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        sc.close();

        TestPrime test = new TestPrime();
        try {
            result = test.isPrime(number);
            if(result) System.out.println(number+" is a prime number");
            else System.out.println(number+" is not a prime number");
        } catch (InvalidInputException e) {
            System.out.println(e);
        };
    }
}
