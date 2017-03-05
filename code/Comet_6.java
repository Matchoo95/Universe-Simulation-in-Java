import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Comet 6 - a type of comet that has the properties
 * of changing diameter when hitting an edge and randomly 
 * decreasing in lifetime when moving
 * 
 * @author up769535
 * @version 2016.3.14
 */
public class Comet_6 extends Comet
{    
    Random random = new Random();
    /**
    * Constructor for objects of class Comet_6
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
    public Comet_6(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse)
    {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, objLife, theUniverse);         
    }
    
    /**
     * Change behaviours of object when it hits an edge
     * 
    **/
    public void changeEdge()
    {        
        if(diameter <= 11){  // prevents comet from becoming too small
            diameter += 10;
        }
        diameter = random.nextInt(10-(-10) +1) + (10);  
    }
    
    /**
     * Change behaviours of object while it moves
     * 
    **/
    public void changeMove()
    {        
        if(lifeTime > 0){
            lifeTime *= 0.50;     // gets rid of 50% of the comets life time
        } 
    }
}
  