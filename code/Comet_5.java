import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Comet 5 - a type of comet that has the properties
 * of changing colour when hitting an edge and randomly 
 * changing direction when moving
 * 
 * @author up769535
 * @version 2016.3.14
 */
public class Comet_5 extends Comet
{
    private ArrayList<Color> colour;
    Random random = new Random();
    /**
    * Constructor for objects of class Comet_5
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
    public Comet_5(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse)
    {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, objLife, theUniverse);
               
        colour = new ArrayList<Color>();
        
        colour.add(Color.BLUE);
        colour.add(Color.CYAN);
        colour.add(Color.GRAY);
        colour.add(Color.GREEN);   
        colour.add(Color.PINK);
        colour.add(Color.RED);    
    }
    
    /**
     * Change behaviours of object while it moves (removed for demo)
     * 
    **/
    public void changeMove()
    {        
    }   
    
    /**
     * Change behaviours of object when it hits an edge
     * 
    **/
    public void changeEdge()
    {        
        objColor = colour.get(random.nextInt(6)); 
    }    
}