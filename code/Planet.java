import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class Planet - a planet inside a universe
 * 
 * @author up769535
 * @version 2016.3.14
 */
public class Planet extends Space_Object
{
    private double angle = 0;
    private int orbitSpeed;
    private int orbitInitialX;
    private int orbitInitialY;
    /**
    * Constructor for objects of class Planet
    *
    * @param xPos  the horizontal coordinate of the object
    * @param yPos  the vertical coordinate of the object
    * @param xVel  the horizontal speed of the object
    * @param yVel  the vertical speed of the object
    * @param objectDiameter  the diameter (in pixels) of the object
    * @param objectColor  the color of the object
    * @param theUniverse  the universe this object is in
    * @param objLife  the lifetime of the object 
    * @param speedOfOrbit  the speed of which the planet orbits the star
    * @param orbitX the x orbit position of the planet
    * @param orbitY the y orbit position of the planet
    * 
    */
    public Planet(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse, int speedOfOrbit, int orbitX, int orbitY)
    {
       super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, objLife, theUniverse);
       orbitSpeed = speedOfOrbit;
       orbitInitialX = orbitX;
       orbitInitialY = orbitY;       
    }
    
    /**
     * Move this object according to its position and speed and redraw.
     * 
    **/
    public void move() {  
       universe.erase(this);
       
       double distance = Math.sqrt((xPosition - orbitInitialX) * (xPosition - orbitInitialX) + (yPosition - orbitInitialY) * (yPosition - orbitInitialY)); // works out distance between planet and star
       angle += orbitSpeed;      
       
       double orbitXPos = orbitInitialX + distance * Math.cos(angle);
       double orbitYPos = orbitInitialY + distance * Math.sin(angle);
      
       int newXPos = (int) orbitXPos;
       int newYPos = (int) orbitYPos;
        
       xPosition = newXPos;
       yPosition = newYPos;
       universe.draw(this);
    }
}
