/**
 * Program to Race Cars
 * 
 * @author      Cody Stone
 * @version 1.0, February 6, 2020
 */
package hmwk03_04;
import java.util.Random;
import java.util.Scanner;

public class RaceGame {
    /**
    * main - prompts the user for input and outputs race
    * 
    * @param   args   command line arguments
    * @return  N/A
    */    
    public static void main(String args[]) {
        Scanner input = new Scanner (System.in);
        
        Random rand = new Random();
        //create two RaceCar objects
        RaceCar user = new RaceCar(1, 0);
        RaceCar computer = new RaceCar(2, 0);
        int number;
        int position;
        int move = 0;
        int debug;
        int computerMove = 0;
        int don = 0;
        int randomNumber;
        boolean yay = false;
        boolean boo = false;
        
        //Prompt user for dice roll
        System.out.print("Dice roll or -1 for random? ");
        
        //recieve input
        debug = input.nextInt(); 
        System.out.println();
        
        user.print();
        computer.print();

        //if loop to set up debug dice rolling
        while (user.getPosition() < 20 && computer.getPosition() < 20){
            
            //prompt for input for double or nothing
            System.out.print("1=regular move, 2=double or nothing? ");
            
            //recieve double or nothing input
            don = input.nextInt();
            System.out.println();
        
            if (debug != -1 && debug % 2 == 0 && don == 2) {
                move = 0;
                boo = true;
            }
            else if (debug != -1 && debug % 2 != 0 && don == 2) {
                move = debug * 2;
                yay = true;
            }
            else if (debug != -1 && don == 1) {
                move = debug;
            }
            else if (debug == -1) {
             
                randomNumber = rand.nextInt(6) + 1;
                
                if (don == 2 && randomNumber % 2 != 0){
                    move = randomNumber * 2;
                    yay = true;
                }
                if (don == 2 && randomNumber % 2 == 0){
                    move = 0;
                    boo = true;
                }
            }
            if (debug == -1){
                computerMove = rand.nextInt(6) + 1;
            } else {
                computerMove = debug;
            }
            
            //update position along track
            user.setPosition(user.getPosition() + move);
            computer.setPosition(computer.getPosition() + computerMove);
        
            if (yay == true) {
                System.out.printf("Yay - you doubled your move, %d spaces%n", move);
            }
            else if (boo == true) {
                System.out.printf("Sorry, you don't move%n");
            } else {
                //print progress
                System.out.printf("You move %d spaces%n", move);   
            }
            System.out.printf("Computer moves %d spaces%n", computerMove);
            //print cars
            user.print();
            computer.print();
            yay = false;
            boo = false;
        }
        
        //print function       
        if (user.getPosition() >= 20 && computer.getPosition() < 20) {
            System.out.print("Congratulations, you win!");
            
        } else if (computer.getPosition() >= 20 && user.getPosition() < 20) {
            System.out.print("Sorry, you lose");
            
        } else if (user.getPosition() >= 20 && computer.getPosition() >= 20) {
            System.out.print("It's a tie");
        }
    }
}
