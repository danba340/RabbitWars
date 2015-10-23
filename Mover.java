import greenfoot.*;

/**
 * The Mover class has many methods that actors can implement to be able to move in different ways.
 * 
 * @author Daniel Bark
 * @version 1.0
 */
public class Mover extends Actor{
    protected int dy = 0;
    protected int prevX;
    private int mDx = 0;
    private int mGravity = 4;
    private int mXAcceleration = 1;
    private int mGroundY = 400; 
    
    /**
     * Stops the acceleration on the X-axis if the actor is standing still
     */
    protected void stopAccel(){
        if(prevX == getX()){
            mDx = 1;
        }
        prevX = getX();
    }
    
    /**
     * Implements gravity
     */
    protected void gravity(){
            setLocation(getX(), getY() + dy);
            dy = dy + mGravity;     
    }
    
    /**
     * Enables the actor to move left and right and to jump.
     * @param leftKey Sets which key that should move the actor to the left 
     * @param rightKey Sets which key that should move the actor to the right 
     * @param jumpKey Sets which key that should make the actor jump
     */
    protected void checkKeyPress(String leftKey, String rightKey, String jumpKey){
        
        if(getY() == mGroundY){
            if(Greenfoot.isKeyDown(jumpKey)){
                dy = -25;
            }
        }
        
        if(Greenfoot.isKeyDown(leftKey)){
            setLocation(getX() - mDx, getY());
            if(mDx < 20){
            mDx = mDx + mXAcceleration;
            }
        }
        
        if(Greenfoot.isKeyDown(rightKey)){
            setLocation(getX() + mDx, getY()); 
            if(mDx < 20){
            mDx = mDx + mXAcceleration;
            }
        }
        
    }
    
    /**
     * Makes sure that actors cant go lower than ground level.
     */
    protected void onGround(){
       if(getY() > mGroundY){
           setLocation(getX(), mGroundY);
       }
    }
    
    /**
     * Moves an actor at a constant speed along the X-axis
     * @param direction The direction on the X-axis which the actor should move
     */
    protected void xMover(boolean direction){
        mDx = 15;
        if(direction){
            setLocation(getX() - mDx, getY()); 
        }
        else{
            setLocation(getX() + mDx, getY()); 
        }
    }
    
    /**
     * Sets the force of gravity  
     * @param gravity The passed in parameter sets gravity of the Mover.
     */
    public void setGravity(int gravity){
          mGravity = gravity;  
    }

}