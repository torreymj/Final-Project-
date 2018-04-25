public class Coin
{

    String lastFlip;
    
    /**
     * Coin constructor 
     */
    public void Coin()
    {
        
    }
    
    /**
     * Flips the coin and returns the face the coin lands on.
     * @return face coin lands on
     */
    public String Flip() {
        int flip = (int) (Math.random() * 2) + 1;
        String flipResult;
        
        if (flip == 1) {
            flipResult = "Heads";
        } else {
            flipResult = "Tails";
        }
        this.lastFlip = flipResult;
        return flipResult;
    }
    
    /**
     * Returns the last flip of the coin without doing a new flip
     * @return lastFlip
     */
    public String getLastFlip() {
        return this.lastFlip;
    }
}

