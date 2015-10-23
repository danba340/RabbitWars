import greenfoot.*;

/**
 * A screen that displays the winner
 * 
 * @author Daniel Bark
 * @version 1.0
 */
public class EndScreen extends RabbitWorld
{
    private Rabbit1 rabbit1 = new Rabbit1();
    private Rabbit2 rabbit2 = new Rabbit2();
    
    /**
     * Constructs the Endscreen
     */
    public EndScreen()
    {
        populateWorld();
    }
    
    /**
     * Populates the Endscreen with the winner and text
     */
    public void populateWorld(){
        if(rabbit1.getNumOfWins() > rabbit2.getNumOfWins()){
            addObject(rabbit1, 500, 250);
        }
        else{
            addObject(rabbit2, 500, 250);   
        }
        showText("And the winner is...", 500, 100);
        showText("press spacebar to continue", 500, 50);
    }
    
    /**
     * Restarts the game
     */
    public void nextLevel(){
        if(Greenfoot.isKeyDown("space")){
            rabbit1.resetWins();
            rabbit2.resetWins();
            Greenfoot.setWorld(new RabbitWorld1());
        }
    }
    
    @Override
    public void act(){
        nextLevel();
    }
}
