import greenfoot.*;
import java.util.List;
/**
 * The world used for round 1 with rabbits and carrots
 * 
 * @author Daniel Bark
 * @version 1.0
 */
public class RabbitWorld1 extends RabbitWorld
{
    private CarrotIcon carrotIcon1 = new CarrotIcon();
    private CarrotIcon carrotIcon2 = new CarrotIcon();
   
    /**
     * Constructs the first rabbitworld
     */
    public RabbitWorld1()
    {
        populateWorld();
        rabbit1.setGravity(3);
        rabbit2.setGravity(3);
    }
    
    /**
     * Populates the rabbitworld
     */
    private void populateWorld(){        
        addObject(rabbit1, 100, 400);
        addObject(rabbit2, 900, 400);
        addObject(heart1, 35, 35);
        addObject(heart2, 70, 35);
        addObject(heart3, 105, 35);
        addObject(heart4, getWidth()-35, 35);
        addObject(heart5, getWidth()-70, 35);
        addObject(heart6, getWidth()-105, 35);
        showText("Round 1/3", 500, 50);
        showText(score, 500, 100);
    }
    
    @Override
    public void act(){
        updateHearts();
        updateCarrots();
        addTarget();
        checkGameOver();
    }
    
    @Override
    public void nextLevel(){
        Greenfoot.setWorld(new RabbitWorld2());
    }

    /**
     * Displays a carroticon if the rabbit has a carrot to throw
     */
    private void updateCarrots(){
        if(rabbit1.hasThrowableObject()){
            addObject(carrotIcon1, 175, 35);
            if(rabbit1.hasSuperProjectile()){
                carrotIcon1.turnIntoSuperProjectile();
            }
            else{
                carrotIcon1.turnIntoNormalProjectile();
            }
        }
        else{
            removeObject(carrotIcon1);
        }
        
        if(rabbit2.hasThrowableObject()){
            addObject(carrotIcon2, 825, 35);
            if(rabbit2.hasSuperProjectile()){
                carrotIcon2.turnIntoSuperProjectile();
            }
            else{
                carrotIcon2.turnIntoNormalProjectile();
            }
        }
        else{
            removeObject(carrotIcon2);
        }
    }    
}
