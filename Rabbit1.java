import greenfoot.*;

/**
 * A rabbit that can run, jump and throw objects at other rabbits
 * 
 * @author Daniel Bark
 * @version 1.0
 */
public class Rabbit1 extends Rabbit
{
    private GreenfootImage mImageRight = new GreenfootImage("greyrabbitright.png");
    private GreenfootImage mImageLeft = new GreenfootImage("greyrabbitleft.png");
    private static int mNumOfWins;
    
    /**
     * Constructs a rabbit
     */
    Rabbit1(){
        setImage(mImageRight);
    }
    
    @Override
    public void act(){
        checkForDamage();
        prevX = getX();
        if(mNumOfHearts != 0){
        checkKeyPress("a", "d", "w");
        changePic();
        throwObject();
        }
        mThrowCooldown--;
        mSuperProjectileCooldown--;
        mInvulnerableTimer--;
        gravity();
        onGround();
        stopAccel();
        checkGameOver();
        endScreen();
    }
        
    /**
     * Sets the image according to how the rabbit is moving and if it is Invulnerable
     */
    private void changePic(){
        if(prevX > getX()){
            setImage(mImageLeft);
        }
        else if(prevX < getX()){
            setImage(mImageRight);   
        }
        if(mInvulnerableTimer > 0){
            getImage().setTransparency(150);
        }
        else{
            getImage().setTransparency(255);
        }
    }
    
    /**
     * Gets the number of wins.
     * @return numOfWins The number of wins that the rabbit has.
     */
    public int getNumOfWins(){
        return mNumOfWins;
    }
    
    /**
     * Adds a win to the rabbit.
     */
    public void addWin(){
        mNumOfWins++;
    }
    
    /**
     * Sets the number of wins to 0 for the rabbit.
     */
    public void resetWins(){
        mNumOfWins = 0;
    }
    
    /**
     * If the endscreen is shown, the rabbit is displayed the middle with a slight rotation.  
     */
    protected void endScreen(){
        if(getWorld() instanceof EndScreen){
            setLocation(500, 250);
            turn(3);
            mNumOfWins = 0;
        }    
    }
    
    /**
     * Allows the rabbit to throw carrots, bats and rockets.
     */
    private void throwObject(){
        if(mThrowCooldown < 0){
            mHasThrowableObject = true;
            if(mSuperProjectileCooldown < 0){
                    mHasSuperProjectile = true;
            }
            if(Greenfoot.isKeyDown("s")){
                
                if(getImage() == mImageLeft){
                    if(getWorld() instanceof RabbitWorld1){
                        getWorld().addObject(new Carrot(true, mHasSuperProjectile, this), getX()-75, getY()-50);
                    }
                    else if(getWorld() instanceof RabbitWorld2){
                        getWorld().addObject(new Bat(true, mHasSuperProjectile, this), getX()-75, getY());;
                    }
                    else if(getWorld() instanceof RabbitWorld3){
                        getWorld().addObject(new Rocket(true, mHasSuperProjectile, this), getX()-75, getY());
                    }
                }
                else if(getImage() == mImageRight){
                    if(getWorld() instanceof RabbitWorld1){
                        getWorld().addObject(new Carrot(false, mHasSuperProjectile, this), getX()+75, getY()-50);
                    }
                    else if(getWorld() instanceof RabbitWorld2){
                        getWorld().addObject(new Bat(false, mHasSuperProjectile, this), getX()+75, getY());
                    }
                    else if(getWorld() instanceof RabbitWorld3){
                        getWorld().addObject(new Rocket(false, mHasSuperProjectile, this), getX()+75, getY());
                    }
                }
                mHasThrowableObject = false;
                mHasSuperProjectile = false;
                mThrowCooldown = 75;
                mSuperProjectileCooldown = 200;
            }
        }
    }
    
    /**
     * Checks if the rabbit has died and changes the image if it has.
     */
    private void checkGameOver(){
        if(mNumOfHearts == 0){
        setImage(mImageLeft);
        setRotation(90);
        }
        
    }
    
}