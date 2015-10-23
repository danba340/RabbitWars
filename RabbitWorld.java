import greenfoot.*;

/**
 * An abstract class that the other worlds inherit from
 * 
 * @author Daniel Bark  
 * @version 1.0
 */
public abstract class RabbitWorld extends World
{ 
    protected Rabbit1 rabbit1 = new Rabbit1();
    protected Rabbit2 rabbit2 = new Rabbit2();
    protected Target target;
    protected Heart heart1 = new Heart();
    protected Heart heart2 = new Heart();
    protected Heart heart3 = new Heart();
    protected Heart heart4 = new Heart();
    protected Heart heart5 = new Heart();
    protected Heart heart6 = new Heart();
    protected int newWorldCountdown = 100;
    protected String score = String.format("Score:\n%s - %2d", rabbit1.getNumOfWins(), rabbit2.getNumOfWins());
    
    /**
     * Constructs the Rabbitworld
     */
    public RabbitWorld(){    
        super(1000, 500, 1);
    } 
    
    /**
     * Go to next level.
     */
    protected abstract void nextLevel();
    
    /**
     * Uppdates the hearts to display current rabbit lives
     */
    protected void updateHearts(){
        if(rabbit1.getNumOfHearts() <= 2){
            removeObject(heart3);
        }
        if(rabbit1.getNumOfHearts() <= 1){
            removeObject(heart2);
        }
        if(rabbit1.getNumOfHearts() <= 0){
            removeObject(heart1);
        }
        
        if(rabbit2.getNumOfHearts() <= 2){
            removeObject(heart4);
        }
        if(rabbit2.getNumOfHearts() <= 1){
            removeObject(heart5);
        }
        if(rabbit2.getNumOfHearts() <= 0){
            removeObject(heart6);
        }
    }
    
    /**
     * Adds a Target in the air at a random X location
     */
    protected void addTarget(){
        if(getObjects(Target.class).isEmpty()){
            if(Greenfoot.getRandomNumber(200) > 198){
                target = new Target();
                addObject(target, Greenfoot.getRandomNumber(700)+150, 150);
            }
        }
    }
        
    /**
     * Checks if round is over, gives one rabbit a win and starts the next level
     */
    protected void checkGameOver(){
        if(rabbit1.getNumOfHearts() <= 0){
            if(newWorldCountdown < 0){
            rabbit2.addWin();
            nextLevel();
            }
            newWorldCountdown--;
        }
        else if(rabbit2.getNumOfHearts() <= 0){
            
            if(newWorldCountdown < 0){
            rabbit1.addWin();
            nextLevel();
            }
            newWorldCountdown--;
        }
    }
}

