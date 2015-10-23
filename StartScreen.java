import greenfoot.*;

/**
 * An introductory screen that dislpays the controls
 * 
 * @author Daniel Bark 
 * @version 1.0
 */
public class StartScreen extends RabbitWorld
{
    /**
     * Constructs the startscreen
     */
    public StartScreen(){
        populateWorld();
    }
    
    /**
     * Populates the startscreen with text
     */
    public void populateWorld(){        
        showText("Prepare for 3 rounds of:", 500, 50);
        showText("RABBIT WARS", 500, 100);
        showText("press spacebar to start", 500, 150);
        showText("Pro tips:", 500, 350);
        showText("Throw projectiles at the targets\nand become invulnerable for a few seconds.", 500, 400);
        showText("Hold your fire for a few seconds\nand recieve a special projectile.", 500, 450);
        showText("Controls:\nLeft: A\nRight: D\n Jump: W\n Shoot: S", 150, 125);
        showText("Controls:\nLeft: Left arrow\nRight: Right arrow\n Jump: Up arrow\n Shoot: Down arrow", 850, 125);
    }
    
    @Override
    public void act(){
        nextLevel();
    }
    
    @Override
    public void nextLevel(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new RabbitWorld1());
        }
    }
}
