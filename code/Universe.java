import java.awt.Color;
import java.util.ArrayList;

/**
 * Class Universe - a universe which contains several objects  
 *
 * @author Robert Topp and up769535
 * @version 2016.3.14
 */

public class Universe  
{
    private Canvas universe;
    
    // coordinates of the edges of the universe
    private int leftEdge = 0;     
    private int topEdge = 0;      
    private int rightEdge;
    private int bottomEdge;
    
    private ArrayList<Space_Object> spaceObject;    // array for space objects
    private ArrayList<Integer> eraseObject;         // array for erasing objects       
    /**
     * Create a universe with default name and size. Creates a fresh canvas to display the universe 
     */
    public Universe()
    {
        universe = new Canvas("Universe Demo", 600, 500);
        rightEdge = 600;
        bottomEdge = 500;
        
        spaceObject = new ArrayList<Space_Object>();     
        eraseObject = new ArrayList<Integer>();          
    }
    
    /**
     *  Create a universe with given name and size
     *  @param name The name to give the universe
     *  @param rightEdge The maximum x coordinate
     *  @param bottomEdge The maximum y coordinate
     */
     public Universe(String name, int rightEdge, int bottomEdge)
    {
        universe = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
    }
    
    /**
     * Erase an object from the view of the universe
     * 
     * @param spaceObj The object to be erased
     */
    public void erase(Space_Object spaceObj)
    {
        universe.eraseCircle(spaceObj.xPosition - (spaceObj.diameter / 2), spaceObj.yPosition - (spaceObj.diameter / 2), spaceObj.diameter);
    }
    
     /**
     * Draw an object at its current position onto the view of the universe.
     * 
     * @param spaceObj The object to be drawn
     */
    public void draw(Space_Object spaceObj)
    {
        universe.setForegroundColor(spaceObj.objColor);
        universe.fillCircle(spaceObj.xPosition - (spaceObj.diameter / 2), spaceObj.yPosition - (spaceObj.diameter / 2), spaceObj.diameter);
    }
    
    /**
     * Return the y cordinate of the bottom of the universe
     */
    public int getGround()
    {
        return bottomEdge;
    }
    
    /**
     * Return the x coordinate of the right of the universe
     */
    public int getRight()
    {
        return rightEdge;
    }
    
    /**
     * Add all objects
     */
    public void demoAll()
    {   
      spaceObject.add(new Comet_5_V2(500, 500, -8, -5, 13, Color.CYAN, 20000, this));
      spaceObject.add(new Comet_6(10, 10, 5, 6, 12, Color.RED, 60000, this));
      spaceObject.add(new Comet_5_V2(100, 400, 7, 5, 10, Color.GREEN, 10000, this));
      spaceObject.add(new Comet_6(300, 400, 5, 6, 12, Color.RED, 60000, this));
        
      spaceObject.add(new Star(350, 350, 0, 0, 35, Color.YELLOW, 25000, this)); 
      spaceObject.add(new Star(150, 150, 0, 0, 40, Color.YELLOW, 25000, this)); 
       
      spaceObject.add(new Planet(350, 400, 0, 0, 15, Color.BLUE, 25000, this, 25, 350, 350));
      spaceObject.add(new Planet(350, 450, 0, 0, 15, Color.BLUE, 25000, this, 50, 350, 350));
      spaceObject.add(new Planet(150, 225, 0, 0, 15, Color.BLUE, 25000, this, 75, 150, 150));
        
      spaceObject.add(new Black_Hole(400, 50, 0, 0, 35, Color.BLACK, 99999, this, 300));
      
      demo();
    }
    
    /**
     * Show comet 5's behaviour
     */
    public void demoComet5BehaviourDemo()
    {
        spaceObject.add(new Comet_5_V2(500, 500, -8, -5, 13, Color.CYAN, 20000, this));
        
        demo();        
    }
    
    /**
     * Show comet 6's behaviour
     */
    public void demoComet6BehaviourDemo()
    {        
        spaceObject.add(new Comet_6_V2(500, 500, -8, -5, 13, Color.CYAN, 10000, this));
        
        demo();       
    }
    
    /**
     * Show collisions between the same type of comets
     */
    public void demoSameCometCollisionDemo()
    {
        spaceObject.add(new Comet_5(100, 200, 0, -8, 20, Color.GREEN, 20000, this));
        spaceObject.add(new Comet_5(100, 400, 0, -12, 20, Color.GREEN, 20000, this));        
        
        spaceObject.add(new Comet_6(500, 200, 0, 8, 20, Color.RED, 20000, this));
        spaceObject.add(new Comet_6(500, 400, 0, 8, 15, Color.RED, 20000, this));
        
        demo(); 
    }
    
    /**
     * Show collisions between the different type of comets
     */
    public void demoDifferentCometCollisionDemo()
    {
        spaceObject.add(new Comet_5(500, 150, 10, 0, 20, Color.GREEN, 20000, this));
        spaceObject.add(new Comet_6(100, 150, 10, 0, 20, Color.CYAN, 20000, this));
        
        spaceObject.add(new Comet_5(500, 300, 8, 0, 15, Color.RED, 20000, this));
        spaceObject.add(new Comet_6(100, 300, 8, 0, 20, Color.RED, 20000, this));        
        
        spaceObject.add(new Comet_5(100, 450, -4, 0, 20, Color.CYAN, 20000, this));
        spaceObject.add(new Comet_6(500, 450, -6, 0, 20, Color.GREEN, 20000, this));
                
        demo();     
    }
     
    /**
     * Show stars and planets orbiting and collisions with comets
     */
    public void demoStarAndPlanetDemo()
    {
        spaceObject.add(new Star(350, 350, 0, 0, 35, Color.YELLOW, 25000, this)); 
        spaceObject.add(new Star(150, 150, 0, 0, 40, Color.YELLOW, 25000, this)); 
       
        spaceObject.add(new Planet(350, 400, 0, 0, 15, Color.BLUE, 25000, this, 25, 350, 350));
        spaceObject.add(new Planet(350, 450, 0, 0, 15, Color.BLUE, 25000, this, 50, 350, 350));
        spaceObject.add(new Planet(150, 225, 0, 0, 15, Color.BLUE, 25000, this, 75, 150, 150));
           
        spaceObject.add(new Comet_6(10, 10, 5, 5, 12, Color.RED, 60000, this));
        spaceObject.add(new Comet_5_V2(100, 400, 7, 5, 10, Color.GREEN, 10000, this));   
        spaceObject.add(new Comet_6(100, 300, 8, 0, 20, Color.RED, 20000, this)); 
        
        demo();         
    }
    
    /**
     * Show black hole sucking in comets
     */
    public void demoBlackHole()
    {
        spaceObject.add(new Comet_5_V2(500, 500, -8, -5, 13, Color.CYAN, 20000, this));
        spaceObject.add(new Comet_6(100, 100, -5, 6, 12, Color.RED, 60000, this));
        spaceObject.add(new Comet_6(100, 400, 7, 5, 10, Color.GREEN, 10000, this));          
        
        spaceObject.add(new Black_Hole(400, 50, 0, 0, 35, Color.BLACK, 99999, this, 300));
        
        demo();        
    }
    
    /**
     * Main program loop - calls other methods in other classes and erases objects from the errays
     */
    public void demo()
    {        
        boolean finished =  false;
            while(!finished) { // main loop
                universe.wait(100); // small delay            
                for(Space_Object obj : spaceObject){ // loops through the array and calls move and check life time method depending on the object in the array             
                obj.move();     
                obj.checkLifeTime();
            }
                  
            for(int arrayIndex = 0; arrayIndex < eraseObject.size(); arrayIndex++ ){  // removes objects from array
                try {
                    int eraseIndex = (int)eraseObject.get(arrayIndex); 
                    Space_Object remove = spaceObject.get(eraseIndex);             
                    
                    
                    erase(remove);  // remove object from canvas
                    
                    spaceObject.remove(eraseIndex);  // remove given object from array
                    eraseObject.remove(0);  // always remove first object, so can't be erased again
                    arrayIndex --;  // keeps checking the first object in array
                    
                    if(arrayIndex < 0){  // if no more objects, break loop
                        break;
                    } 
 
                        
                } catch (java.lang.IndexOutOfBoundsException remove) {
                    // This catches an error when there is nothing left to delete
                    System.out.println("Error: No more objects in the Universe!");
                    try {
                        Thread.sleep(2000); 
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    System.exit(1);
                }
            }
        }    
        // clear list of objects 
        eraseObject.clear();
    }
    
    /**
     * Return the spaceObject array size
     */
    public int getNumberOfSpaceObjects()
    {
        return spaceObject.size();
    }
    
    /**
     * Return the spaceObject index
     * 
     * Draw an object at its current position onto the view of the universe.
     * 
     * @param index The index to get from spaceObject array
     */
    public Space_Object getSpaceObjectIndex(int index)
    {
        return spaceObject.get(index);
    }
    
    /**
     * Add an index to the eraseObject array
     * 
     * @param eraseIndex The index to add to eraseObject array
     */
    public void setEraseObject(int eraseIndex)
    {
        eraseObject.add(eraseIndex);        
    }
}
