import java.awt.Color;
/**
 * Class Star - a star within the universe 
 *
 * @author up769535
 * @version 2016.3.14
 */
public class Star extends Space_Object
{   
    /**
    * Constructor for objects of class Star
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
    public Star(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse)
    {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, objLife, theUniverse);            
    }
    
    /**
     * Draw this object so it stays on the canvas
    **/
    public void move(){       
        universe.draw(this);
    }    
}