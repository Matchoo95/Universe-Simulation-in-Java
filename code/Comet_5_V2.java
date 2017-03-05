import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Comet_5_V2 - a type of comet that has the properties
 * of changing colour when hitting an edge and randomly 
 * changing direction when moving
 * 
 * @author up769535
 * @version 2016.3.14
 */
public class Comet_5_V2 extends Comet
{
    private ArrayList<Color> colour;
    Random random = new Random();
    /**
    * Constructor for objects of class Comet_5_V2
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
    public Comet_5_V2(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse)
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
     * Change behaviours of object while it moves
     * 
    **/
    public void changeMove()
    {
        Random checker = new Random();
        int rnd = checker.nextInt((3)+1); 
        if(rnd == 0){  // randomly move the comet up, down, left or right
             ySpeed = random.nextInt(10-(-10) +1) + (-10);              
         }else if(rnd == 1){
             ySpeed = random.nextInt(10+(-10) +1) + (-10);           
         }else if(rnd == 2){
              xSpeed = random.nextInt(10+(-10) +1) + (-10); 
         }else{
             xSpeed = random.nextInt(10-(-10) +1) + (-10);
         }
        //  System.out.println(rnd);        
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