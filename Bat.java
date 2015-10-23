import greenfoot.*;

/**
 * An angry bat that gets thrown by the rabbits
 * 
 * @author Daniel Bark 
 * @version 1.0
 */
public class Bat extends Projectile
{
    /**
     * Constructs a bat
     * @param direction The parameter decides if the carrot is thrown to the left or the right
     * @param isSuperBat decides if the Bat is a superbat or not
     * @param thrownBy the Actor who threw the bat
     */
    Bat(boolean direction, boolean isSuperBat, Actor thrownBy){
        mImage = getImage();
        mImage.scale(40, 40);
        mDirection = direction;
        isSuperProjectile = isSuperBat;
        mThrownBy = thrownBy;
        if(isSuperProjectile){
            mImage.scale(60, 60);
            mDamage = 2;
        }
    }
    
    @Override
    public void act(){
        xMover(mDirection);
        removeAtCollision(); 
        hittingTarget();
    } 
    
    /**
     * Removes the bat at the edge of the world
     */
    private void removeAtCollision(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
