package sdf;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        
        // send a welcome message:
        System.out.println("Welcome to the calculator.");

        // get input from user
        Console cons = System.console();
        boolean isConnected = true;
        Integer $last = 0;

        while (isConnected) {
            String[] input = cons.readLine().split(" ");

            if (input[0].equalsIgnoreCase("exit")) {
                isConnected = false;
                
            } else {

                Calculator calc = new Calculator(input, $last);

                // return the result
                System.out.printf(">> %d\n", calc.getResult());
                // update result
                $last = calc.getResult();
    
                // check the calculator status
                isConnected = calc.getStatus();

            }
        }

        System.out.println("Bye bye");

    }
}