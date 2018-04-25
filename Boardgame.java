import java.util.ArrayList;
import java.util.Scanner;

public class Boardgame
{

    public static void main(String[] args)
    {
            Scanner input = new Scanner(System.in);

            // The number of sides on the custom dice
            int sides = 0;
            boolean sidesInitialized = false;
            int numDice;
            
            Coin newCoin = new Coin();
            Dice newDice = new Dice(6);
            String kb = "";
            Dice customDice = null;
            
            boolean coinLastFlipFlag = false; 
            boolean diceLastRollFlag = false;
            boolean customDiceAlreadyCreated = false;
            // Checks to see if coin and dice and wheel has already been flipped for last flip
            System.out.println("Manual");
            System.out.println("Input - Effect");
            System.out.println("manual - Input manual");
            System.out.println("quit - Quit Game");
            System.out.println("custom dice - Creates a custom dice with input number of sides");
            System.out.println("flip - Flip coin");
            System.out.println("last flip - Gets last coin flip");
            System.out.println("roll - Rolls dice");
            System.out.println("roll custom - Rolls the custom dice");
            System.out.println("last roll - Gets last dice roll");
            System.out.println("set sides - Sets number of sides on custom dice");
            System.out.println("get sides - Gets number of sides on custom dice\n");
                
            while (kb != "quit") {
                System.out.print("Input: ");
                kb = input.nextLine();
                if (kb.toLowerCase().equals("quit")) {
                    break;
                } else if (kb.toLowerCase().equals("manual")) {
                    System.out.println("Manual");
                    System.out.println("Input - Effect");
                    System.out.println("manual - Input manual");
                    System.out.println("quit - Quit Game");
                    System.out.println("custom dice - Creates a custom dice with input number of sides");
                    System.out.println("flip - Flip coin");
                    System.out.println("last flip - Gets last coin flip");
                    System.out.println("roll - Rolls dice");
                    System.out.println("roll custom - Rolls the custom dice");
                    System.out.println("last roll - Gets last dice roll");
                    System.out.println("set sides - Sets number of sides on custom dice");
                    System.out.println("get sides - Gets number of sides on custom dice");
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
                    newDice.getLastRoll();
                } else if (kb.toLowerCase().equals("last roll") && diceLastRollFlag == false) {
                    System.out.println("No previous roll, this is the first roll.");
                    diceLastRollFlag = true;
                    System.out.println(newDice.Roll());
                } else if (kb.toLowerCase().equals("set sides")) {
                    System.out.println("How many sides would you like to change your dice to?");
                    sides = input.nextInt();
                    customDice.setSides(sides);
                } else if (kb.toLowerCase().equals("get sides") && sidesInitialized == true) {
                    System.out.println(sides);
                } else if (kb.toLowerCase().equals("get sides") && sidesInitialized == false) {
                    System.out.println("No custom dice create, how about create one now? Enter a number of sides.");
                    sides = input.nextInt();
                    customDice = new Dice(sides);
                    System.out.println(sides);
                } else if (kb.toLowerCase().equals("custom dice") && customDiceAlreadyCreated == false) {
                    customDiceAlreadyCreated = true;
                    System.out.println("How many sides do you want to the dice?");
                    sides = input.nextInt();
                    customDice = new Dice(sides);
                } else if (kb.toLowerCase().equals("custom dice") && customDiceAlreadyCreated == true) {
                    System.out.println("You already have a custom dice, are you sure you want to overwrite it? Y or N");

                    if (input.nextLine().toLowerCase().equals("y")) {
                    System.out.println("How many sides do you want to the dice?");
                    sides = input.nextInt();
                    customDice = new Dice(sides);
                } else if (input.nextLine().toLowerCase().equals("n")){
                    customDice = new Dice(sides);
                }

                } else if (kb.toLowerCase().equals("roll custom")) {
                    System.out.println(customDice.Roll());
                } else {
                    System.out.println("Invalid input, please enter something else.");
                }
            }
            System.out.println("Thanks for playing!");
    }
}


