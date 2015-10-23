import greenfoot.*;

/**
 * A dangerous rocket that gets thrown by the rabbits
 * 
 * @author Daniel Bark 
 * @version 1.0
 */
public class Rocket extends Projectile
{
    /**
     * Constructs a rocket
     * @param direction The parameter decides if the rocket is thrown to the left or the right
     * @param isSuperRocket decides if the Rocket is a superrocket or not
     * @param thrownBy the Actor who threw the rocket
     */
    Rocket(boolean direction, boolean isSuperRocket, Actor thrownBy){
        mImage = getImage();
        mDirection = direction;
        isSuperProjectile = isSuperRocket;
        mThrownBy = thrownBy;
        if(isSuperProjectile){
            mImage.scale(60, 60);
            mDamage = 2;
        }
        if(direction){
            setRotation(180);
        }
    }
    
    @Override
    public void act(){
        move(8);
        randomTurn();
        removeAtCollision(); 
        hittingTarget();
    } 
    
    /**
     * Removes a rocket if it reaches the edge of the world
     */
    private void removeAtCollision(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    } 
    
    /**
     * Randomizes the flight path of the rocket
     */
    private void randomTurn(){
        if(Greenfoot.getRandomNumber(5) == 0){
            if(Greenfoot.getRandomNumber(2) == 0){
                turn(5);
            }
            else{
                turn(-5);
            }
        }
    }
}
