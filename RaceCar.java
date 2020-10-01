/**
 * Program to Race Cars
 * 
 * @author      Cody Stone
 * @version 1.0, February 6, 2020
 */
package hmwk03_04;

import java.util.Random;

public class RaceCar {
        
    //create random number generator variable
    Random rand = new Random();
    
    //Instance variables for RaceCar
    private int number;
    private int position;
    
    /**
     * RaceCar Constructor
     * 
     * @param number
     * @param position 
     * @return nothing
     */
    RaceCar(int number, int position){
        this.number = number;
        this.position = position;
    }
    
    /**
     * Get the number for Racecar
     * 
     * @return nothing
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * Set the number for raceCar
     * 
     * @param number
     * @return number
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * get the position for raceCar
     * 
     * @return nothing
     */
    public int getPosition() {
        return position;
    }
    
    /**
     * set the position for raceCar
     * 
     * @param position
     * @return nothing
     */
    public void setPosition(int position) {
        this.position = position;
    }
    
    /**
     * print function for raceCar
     * 
     * @return nothing
     */
    public void print() {       
        
        //for loop to position car
        for (int i = 0; i < this.position; i++) {
            System.out.print(" ");
        }
        
        System.out.printf("__/%d\\__%n", this.number);
        for (int i = 0; i < this.position; i++) {
            System.out.print("_");
        }
        System.out.println("-O---O-");
        if (this.number == 2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }       
    }
}
