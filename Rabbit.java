import greenfoot.*;
/**
 * A superclass for the Rabbits. 
 * 
 * @author Daniel Bark  
 * @version 1.0
 */
public class Rabbit extends Mover
{
    protected int mThrowCooldown;
    protected int mSuperProjectileCooldown = 200;
    protected int mInvulnerableTimer;
    protected boolean mHasThrowableObject = true;
    protected boolean mHasSuperProjectile = false;
    protected int mNumOfHearts = 3;
       
    /**
     * Checks if the rabbit is being hit by a projectile and removes a life if it is.
     * If it is a superprojectile it removes 2 lives
     */
    protected void checkForDamage(){
        if(mInvulnerableTimer < 0){
            if(mNumOfHearts > 0){
                Carrot damagingCarrot = (Carrot)getOneIntersectingObject(Carrot.class);
                if(damagingCarrot != null){
                    if(damagingCarrot.mDamage == 2){
                        mSuperProjectileCooldown = 0;
                    }    
                    mNumOfHearts -= damagingCarrot.mDamage;
                    getWorld().removeObject(damagingCarrot);
                }
                Bat damagingBat = (Bat)getOneIntersectingObject(Bat.class);
                if(damagingBat != null){
                    if(damagingBat.mDamage == 2){
                        mSuperProjectileCooldown = 0;
                    }    
                    mNumOfHearts -= damagingBat.mDamage;
                    getWorld().removeObject(damagingBat);
                }
                Rocket damagingRocket = (Rocket)getOneIntersectingObject(Rocket.class);
                if(damagingRocket != null){
                    if(damagingRocket.mDamage == 2){
                        mSuperProjectileCooldown = 0;
                    }    
                    mNumOfHearts -= damagingRocket.mDamage;
                    getWorld().removeObject(damagingRocket);
                }
            }
        }
    }
    
    /**
     * Gets the number of hearts.
     * @return numOfHearts The number of hearts that the rabbit has.
     */
    public int getNumOfHearts(){
        return mNumOfHearts;
    }
    
    
    /**
     * Returns true if the rabbit has an object to throw.
     * @return hasThrowableObject the variable is true when the rabbit has an object to throw.
     */
    public boolean hasThrowableObject(){
        return mHasThrowableObject;
    }
    
    /**
     * Returns true if the rabbit has a superprojectile to throw.
     */
    public boolean hasSuperProjectile(){
        return mHasSuperProjectile;
    }
    
    
    /**
     * Starts the time period in which the Rabbit is invulnerable
     */
    public void makeInvulnerable(){
        mInvulnerableTimer = 150;
    }
}
