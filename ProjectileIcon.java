import greenfoot.*;

/**
 * A superclass for all projectile icons. Has methods to scale the images to indicate when the projectile 
 * is a superprojectile or a normal projectile
 * 
 * @author Daniel Bark  
 * @version 1.0
 */
public class ProjectileIcon extends Actor
{
    protected boolean isSuperProjectile = false; 
    
    /**
     * Enlarges the image to indicate that its a super projectile
     */
    protected void turnIntoSuperProjectile(){
        getImage().scale(60, 60);
    }
    
    /**
     * Shrinks the image to normal to indicate that its a normal projectile
     */
    protected void turnIntoNormalProjectile(){
        getImage().scale(40, 40);
    }
}
