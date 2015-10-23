import greenfoot.*;

/**
 * The world used for round 2 with rabbits and bats
 * 
 * @author Daniel Bark
 * @version 1.0
 */
public class RabbitWorld2 extends RabbitWorld
{
    private BatIcon BatIcon1 = new BatIcon();
    private BatIcon BatIcon2 = new BatIcon();
    
    /**
     * Constructs the second rabbitworld
     */
    public RabbitWorld2()
    {
        populateWorld();
        rabbit1.setGravity(2);
        rabbit2.setGravity(2);
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
        showText("Round 2/3", 500, 50);
        showText(score, 500, 100);
    }
    
    @Override
    public void act(){
        updateHearts();
        updateBats();
        addTarget();
        lowerTargets();
        checkGameOver();
    }
    
    @Override
    public void nextLevel(){
        Greenfoot.setWorld(new RabbitWorld3());
    }

    /**
     * Displays a baticon if the rabbit has a bat to throw
     */
    private void updateBats(){
        if(rabbit1.hasThrowableObject()){
            addObject(BatIcon1, 175, 35);
            if(rabbit1.hasSuperProjectile()){
                BatIcon1.turnIntoSuperProjectile();
            }
            else{
                BatIcon1.turnIntoNormalProjectile();
            }
        }
        else{
            removeObject(BatIcon1);
        }
        
        if(rabbit2.hasThrowableObject()){
            addObject(BatIcon2, 825, 35);
            if(rabbit2.hasSuperProjectile()){
                BatIcon2.turnIntoSuperProjectile();
            }
            else{
                BatIcon2.turnIntoNormalProjectile();
            }
        }
        else{
            removeObject(BatIcon2);
        }
    } 
    
    /**
     * Lowers the target so that rabbits can reach it with a bat
     */
    private void lowerTargets(){
        if(!getObjects(Target.class).isEmpty()){
            if(target.getY() == 150){
                target.setLocation(target.getX(), 250);
            }
        }
    }
}
