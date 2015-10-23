import greenfoot.*;
import java.util.List;
/**
 * A superclass for all projectiles
 * 
 * @author Daniel Bark  
 * @version 1.0
 */
public class Projectile extends Mover
{
    protected Actor mThrownBy;
    public int mDamage = 1;
    protected boolean isSuperProjectile;
    protected boolean mDirection;
    protected Target target;
    protected Rabbit1 rabbit1;
    protected Rabbit2 rabbit2;
    protected GreenfootImage mImage; 
    
    /**
     * Checks if the Projectile is hitting a target and makes the Rabbit who threw the Projectile invulnerable
     */
    protected void hittingTarget(){
        if(getWorld() != null){
            Rabbit1 rabbit1 = (Rabbit1)getWorld().getObjects(Rabbit1.class).get(0);
            Rabbit2 rabbit2 = (Rabbit2)getWorld().getObjects(Rabbit2.class).get(0);
            Actor target = getOneIntersectingObject(Target.class);
        
            if(isTouching(Target.class)){
                if(mThrownBy == rabbit1){
                    rabbit1.makeInvulnerable();
                }
                if(mThrownBy == rabbit2){
                    rabbit2.makeInvulnerable();
                }
                getWorld().removeObject((Actor)target);
            }
        }
    }
}
