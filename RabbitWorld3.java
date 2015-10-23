import greenfoot.*;

/**
 * The world used for round 2 with rabbits and rockets
 * 
 * @author Daniel Bark
 * @version 1.0
 */
public class RabbitWorld3 extends RabbitWorld
{
    private RocketIcon rocketIcon1 = new RocketIcon();
    private RocketIcon rocketIcon2 = new RocketIcon();
    
    /**
     * Constructs the third rabbitworld
     */
    public RabbitWorld3()
    {
        populateWorld();
        rabbit1.setGravity(1);
        rabbit2.setGravity(1);
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
        showText("Round 3/3", 500, 50);
        showText(score, 500, 100);
    }
    
    @Override
    public void act(){
        checkGameOver();
        updateHearts();
        updateRockets();
        addTarget();
    }
    
    @Override
    public void nextLevel(){
        Greenfoot.setWorld(new EndScreen());
    }
    
    /**
     * Displays a rocketicon if the rabbit has a rocket to throw
     */
    private void updateRockets(){
        if(rabbit1.hasThrowableObject()){
            addObject(rocketIcon1, 175, 35);
            if(rabbit1.hasSuperProjectile()){
                rocketIcon1.turnIntoSuperProjectile();
            }
            else{
                rocketIcon1.turnIntoNormalProjectile();
            }
        }
        else{
            removeObject(rocketIcon1);
        }
        
        if(rabbit2.hasThrowableObject()){
            addObject(rocketIcon2, 825, 35);
            if(rabbit2.hasSuperProjectile()){
                rocketIcon2.turnIntoSuperProjectile();
            }
            else{
                rocketIcon2.turnIntoNormalProjectile();
            }
        }
        else{
            removeObject(rocketIcon2);
        }
    }  
}
