import greenfoot.*;
import java.util.List;
/**
 * A sharp carrot that gets thrown by the rabbits
 * 
 * @author Daniel Bark 
 * @version 1.0
 */
public class Carrot extends Projectile
{    
    /**
     * Constructs a carrot
     * @param direction decides if the carrot is thrown to the left or the right
     * @param isSuperCarrot decides if the carrot is a supercarrot or not
     * @param thrownBy the Actor who threw the carrot
     */
    Carrot(boolean direction, boolean isSuperCarrot, Actor thrownBy){
        dy = -40;
        mImage = getImage();
        mDirection = direction;
        isSuperProjectile = isSuperCarrot;
        mThrownBy = thrownBy;
        if(isSuperProjectile){
            mImage.scale(60, 60);
            mDamage = 2;
        }
  
    }
    
    @Override
    public void act(){
        turn(5);
        gravity();
        xMover(mDirection);
        removeAtCollision(); 
        hittingTarget();
    } 
    
    /**
     * Removes the carrot at collision with the ground or the edge of the world
     */
    private void removeAtCollision(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if(getY() > 400){
           getWorld().removeObject(this);
        }
    }
}
