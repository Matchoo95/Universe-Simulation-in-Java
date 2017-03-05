import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class black hole - a black hole within the universe
 *
 * @author up769535
 * @version 2016.3.14
 */
public class Black_Hole extends Space_Object
{
    private int hitDistance;
    /**
    * Constructor for objects of class Black_Hole
    *
    * @param xPos  the horizontal coordinate of the object
    * @param yPos  the vertical coordinate of the object
    * @param xVel  the horizontal speed of the object
    * @param yVel  the vertical speed of the object
    * @param objectDiameter  the diameter (in pixels) of the object
    * @param objectColor  the color of the object
    * @param theUniverse  the universe this object is in
    * @param objLife  the lifetime of the object 
    * 
    */
    public Black_Hole(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse, int hit)
    {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, objLife, theUniverse);
        hitDistance = hit;
    }
    
    /**
     * Return the hit distance
    **/
    public int getDistance(){ 
        return hitDistance;
    }
    
    /**
     * Draw this object so it stays on the canvas
    **/
    public void move(){ 
        universe.draw(this);
    }
}