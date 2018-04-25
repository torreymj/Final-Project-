public class Dice
{
    
    int sides;
    int lastRoll;
  
    /**
     * A dice constructor with the entered number of sides
     * @param sides - Number of sides the dice has
     * @throws Exception - If it goes under the valid number of sides
     */
    public Dice(int sides)  {
        this.sides = sides;
    }
    
    /**
     * Rolls the dice and returns the value it lands on. 
     * @return Value of side landed on
     */
    public int Roll() {
      int roll = (int) (Math.random() * this.sides) + 1;
      this.lastRoll = roll;
      return roll;
    }

    /**
     * Returns the value of the last roll without a new roll
     * @return lastRoll
     */
    public int getLastRoll() {
            return this.lastRoll;
    }
    
    public void setSides(int newSides) {
        this.sides = newSides;
    }
    
    //public int getSides() {
      //  return this.sides;
    //}
}