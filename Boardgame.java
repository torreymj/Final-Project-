import java.util.ArrayList;
import java.util.Scanner;

/**
 * The mainclass for the boardgame. Allows the used to roll a dice, a custom dice, or flip a coin
 * if they do not have one nearby. Written by Henry Roberts, Faisal Karnib, and Mick Torrey
 */

public class Boardgame
{

    public static void main(String[] args)
    {
            Scanner input = new Scanner(System.in);
            Scanner sidesInput = new Scanner(System.in);

             // All the variables initialized when the program is first launched.
              
             // sides - the number of sides on the custom dice
             // sidesInitialized - checks to see whether a custom dice already exists or not
             // newCoin - Creates a default coin object
             // newDice - Creates a default 6 sided dice
             // kb - the string used to track inputs
             // customDice - initializes a custom dice object
             // coinLastFlipFlag - checks to see if the coin has already been flipped or not
             // diceLastRollFlag - checks to see if the dice has already been rolled or not
             // customLastRollFlag - checks to see if the custom dice has already been rolled or not
            int sides = 0; 
            boolean sidesInitialized = false;
            Coin newCoin = new Coin();
            Dice newDice = new Dice(6);
            String kb = "";
            Dice customDice = null;
            boolean coinLastFlipFlag = false; 
            boolean diceLastRollFlag = false;
            boolean customLastRollFlag = false;
            
            
            // Outputs the manual when the game first launches so the user immediatly can see
            // the directions
            System.out.println("Manual");
            System.out.println("Example: Input - Effect");
            System.out.println("manual - Input manual");
            System.out.println("quit - Quit Game");
            System.out.println("custom dice - Creates a custom dice with input number of sides");
            System.out.println("flip - Flip coin");
            System.out.println("last flip - Gets last coin flip");
            System.out.println("roll - Rolls dice");
            System.out.println("roll custom - Rolls the custom dice");
            System.out.println("last roll - Gets last dice roll");
            System.out.println("last roll custom - Gets last custom dice roll");
            System.out.println("set sides - Sets number of sides on custom dice");
            System.out.println("get sides - Gets number of sides on custom dice\n");
                
            while (kb != "quit") {
                System.out.print("Input: ");
                kb = input.nextLine();
                if (kb.toLowerCase().equals("quit")) {
                    break;
                } else if (kb.toLowerCase().equals("manual")) {
                    System.out.println("Manual");
                    System.out.println("Example: Input - Effect");
                    System.out.println("manual - Input manual");
                    System.out.println("quit - Quit Game");
                    System.out.println("custom dice - Creates a custom dice with input number of sides");
                    System.out.println("flip - Flip coin");
                    System.out.println("last flip - Gets last coin flip");
                    System.out.println("roll - Rolls dice");
                    System.out.println("roll custom - Rolls the custom dice");
                    System.out.println("last roll - Gets last dice roll");
                    System.out.println("last roll custom - Gets last custom dice roll");
                    System.out.println("set sides - Sets number of sides on custom dice");
                    System.out.println("get sides - Gets number of sides on custom dice\n");
                } else if (kb.toLowerCase().equals("flip")) {
                    coinLastFlipFlag = true;
                    System.out.println(newCoin.Flip());
                } else if (kb.toLowerCase().equals("last flip") && coinLastFlipFlag == true) {
                    System.out.println(newCoin.getLastFlip());
                } else if (kb.toLowerCase().equals("last flip") && coinLastFlipFlag == false) {
                    System.out.println("No previous flip, this is the first flip.");
                    coinLastFlipFlag = true;
                    System.out.println(newCoin.Flip());
                } else if (kb.toLowerCase().equals("roll")) {
                    diceLastRollFlag = true;
                    System.out.println(newDice.Roll());
                }  else if (kb.toLowerCase().equals("last roll") && diceLastRollFlag == true) {
                    System.out.println(newDice.getLastRoll());
                } else if (kb.toLowerCase().equals("last roll") && diceLastRollFlag == false) {
                    System.out.println("No previous roll, this is the first roll.");
                    diceLastRollFlag = true;
                    System.out.println(newDice.Roll());
                } else if (kb.toLowerCase().equals("last roll custom") && customLastRollFlag == true && customDice != null) {
                    System.out.println(customDice.getLastRoll());
                } else if (kb.toLowerCase().equals("last roll custom") && customLastRollFlag == false && customDice != null) {
                    System.out.println("No previous roll, this is the first roll.");
                    customLastRollFlag = true;
                    System.out.println(customDice.Roll());
                } else if (kb.toLowerCase().equals("last roll custom") && customLastRollFlag == true || customLastRollFlag == false && customDice == null) {
                    System.out.println("No custom dice created, how about create one now? Enter a number of sides.");
                    sides = sidesInput.nextInt();
                    customDice = new Dice(sides);
                    System.out.println("Sides: " + sides);
                } else if (kb.toLowerCase().equals("set sides")) {
                    System.out.println("How many sides would you like to change your dice to?");
                    sides = sidesInput.nextInt();
                    customDice.setSides(sides);
                    sidesInitialized = true;
                } else if (kb.toLowerCase().equals("get sides") && sidesInitialized == true) {
                    System.out.println(sides);
                } else if (kb.toLowerCase().equals("get sides") && sidesInitialized == false) {
                	System.out.println("No custom dice created, how about create one now? Enter a number of sides.");
                    sides = sidesInput.nextInt();
                    customDice = new Dice(sides);
                    System.out.println(sides);
                } else if (kb.toLowerCase().equals("custom dice") && customDice == null) {
                    System.out.println("How many sides do you want to the dice?");
                    sides = sidesInput.nextInt();
                    customDice = new Dice(sides);
                    sidesInitialized = true;
                    System.out.println(customDice.Roll());
                } else if (kb.toLowerCase().equals("custom dice") && customDice != null) {
                    System.out.println("You already have a custom dice, are you sure you want to overwrite it? Y or N");
                    if (input.nextLine().toLowerCase().equals("y")) {
                        System.out.println("How many sides do you want to the dice?");
                        sides = sidesInput.nextInt();
                        customDice = new Dice(sides);
                        sidesInitialized = true;
                   } else if (input.nextLine().toLowerCase().equals("n")) {
                       customDice = new Dice(sides);
                   }
                } else if (kb.toLowerCase().equals("roll custom") && customDice == null) {
                    System.out.println("No custom dice created, how about create one now? Enter a number of sides.");
                    sides = sidesInput.nextInt();
                    customDice = new Dice(sides);
                    sidesInitialized = true;
                    System.out.println(customDice.Roll());
                } else if (kb.toLowerCase().equals("roll custom") && customDice != null) {
                    System.out.println(customDice.Roll());
                } else {
                    System.out.println("Invalid input, please enter something else.");
                    }
                }
            System.out.println("Thanks for playing!");
    }
}





