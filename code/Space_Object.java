import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class Space_Object - objects that exists in a finite Universe.
 * 
 * Movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Robert Topp and up769535
 * @version 2016.3.14
 */

abstract class Space_Object 
{    
   protected Color objColor;
   protected int diameter;              // diameter of an object
   protected int xPosition;             // x position of an object
   protected int yPosition;             // y position of an object
   protected final int groundPosition;  // y position of the bottom of the Universe
   protected final int topPosition;     // y position of the top of the Universe
   protected final int leftPosition;    // x position of the left of the Universe
   protected final int rightPosition;   // x position of the right of the Universe
   protected Universe universe;         // set universe
   protected int xSpeed;                // current horizontal speed   (+  moving left to right, - right to left
   protected int ySpeed;                // current vertical speed ( + moving down, - moving up)
   protected int lifeTime;              // time for object to exist
   protected int radius = diameter / 2; // set radius
   protected int timeElapsed = 0;       // time between movement change of an object
   protected boolean attraction = false;// check for if a comet is being sucked into a black hole
     
   /**
    * Constructor for objects of class Space_Object
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
   public Space_Object(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse)
   {
       xPosition = xPos;
       yPosition = yPos;
       xSpeed = xVel;
       ySpeed = yVel;
       objColor = objectColor;
       diameter = objectDiameter;
       universe = theUniverse;
       groundPosition = universe.getGround();
       topPosition = 0;
       rightPosition = universe.getRight();
       leftPosition = 0;        
       lifeTime = objLife;   
   }
    
    /**
     * Move this object according to its position and speed and redraw.
    **/
   abstract void move();    // calls move method in comets
   
   /**
     * Check an objects lifetime and deletes the object from the array if it is less than 1
    **/ 
   public void checkLifeTime(){  // checks object life time
      if(lifeTime < 1){  // check if life time is less than 1 and if so, delete, if not -1
          universe.erase(this);  
          Comet obj = (Comet)this;  
          universe.setEraseObject(obj.getIndex());
      }else {
       lifeTime--;
      }
      //System.out.println("Lifetime = " + lifeTime);
   }
}
