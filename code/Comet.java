import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Comets - Comets that have different properties
 *
 * @author up769535
 * @version 2016.3.14
 */

abstract class Comet extends Space_Object
{  
    private ArrayList<Space_Object> spaceObject;
    private int index;
    /**
    * Constructor for objects of class Comet
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
    public Comet(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, int objLife, Universe theUniverse)
    {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, objLife, theUniverse);
        spaceObject = new ArrayList<Space_Object>();        
    }
    
    /**
     * Move this object according to its position and speed and redraw.
     * Checks for various collisions between comets and other objects. 
     * 
    **/
    public void move()
    {
        universe.erase(this);
       
        yPosition += ySpeed;
        xPosition += xSpeed;
              
        int sizeOfArray = universe.getNumberOfSpaceObjects();
        
        Random random = new Random();
              
        spaceObject.clear();  
        for(int counter = 0; counter < sizeOfArray; counter++){
            spaceObject.add(universe.getSpaceObjectIndex(counter));                
        }   
        int radius = diameter / 2;        
        
        timeElapsed ++; 

        if(timeElapsed > random.nextInt((50-10) +1) + 10){ // uses timer to randomly call the following if statement         
            changeMove(); // calls the move method from each different comet depending on what comet it is
            timeElapsed = 0;
        }
                                
        // check if it has hit the ground edge             
        if(yPosition >= (groundPosition - radius) && ySpeed > 0) {            
            yPosition = groundPosition - radius;
            ySpeed = -ySpeed;
            changeEdge(); // calls the edge method depending on which comet it is
        }
                                               
        // check if it has hit the top edge
        if(yPosition <= (topPosition + radius) && ySpeed < 0) {
            yPosition = topPosition + radius;
            ySpeed = -ySpeed;      
            changeEdge();
        }
                             
        // check if it has hit the left edge
        if(xPosition <= (leftPosition + radius) && xSpeed < 0) {
            xPosition = leftPosition + radius;
            xSpeed = -xSpeed;
            changeEdge();                     
        }
        
        // check if it has hit the right edge
        if(xPosition >= (rightPosition - radius) && xSpeed > 0) {
            xPosition = rightPosition - radius;
            xSpeed = -xSpeed;
            changeEdge();                   
        }    
            
        int counter = 0;
        
        for(Space_Object obj : spaceObject){
            index = 0;  // reset index        
            int position = xPosition + yPosition;         
            for(Space_Object tempObj : spaceObject){ // gets index of current object           
              int tempPos = tempObj.xPosition + tempObj.yPosition;
              if(tempPos == position){
                  break; 
              }                
              index++;              
            }
            double area = Math.PI * radius * radius;
            
            // temp positions of colliding object
            int tempXPos = obj.xPosition;
            int tempYPos = obj.yPosition;
           
            int tempPos = tempXPos + tempYPos;  // temp position
                   
            // temp speeds of colliding object
            int tempXSpeed = obj.xSpeed;
            int tempYSpeed = obj.ySpeed;
        
            double tempSpeed = Math.sqrt((tempXSpeed * tempXSpeed) + (tempYSpeed * tempYSpeed)); //speed of other obj
            double currentSpeed = Math.sqrt((xSpeed * xSpeed) + (ySpeed * ySpeed)); //speed of current obj
        
            int tempDiameter = obj.diameter;   // temp diameter for colliding object
            
            int holeRadius = obj.diameter; // sets blackhole radius
        
            if(obj instanceof Black_Hole){  // set black hole diameter
                Black_Hole objH = (Black_Hole)obj;
                tempDiameter = objH.getDistance();             
            }
            double distance = Math.sqrt(((xPosition - tempXPos) * (xPosition - tempXPos)) 
            + ((yPosition - tempYPos) * (yPosition - tempYPos)));
            
            if(tempPos != position){  // check to see if not the same comet as itself
                if(distance <= ((tempDiameter / 1.5) + radius)){   // detects collision with radius' of circles
                    if((obj instanceof Comet_5 && this instanceof Comet_5) || (obj instanceof Comet_6 && this instanceof Comet_6)){
                        System.out.println("Two comets of the same type collided! " + this + " and " + obj + " collided!");
                        obj.xSpeed = -tempXSpeed;
                        obj.ySpeed = -tempYSpeed;
                        xSpeed = -xSpeed;
                        ySpeed = -ySpeed;                            
                    }else if((obj instanceof Comet_5 && this instanceof Comet_6) || (obj instanceof Comet_6 && this instanceof Comet_5)){
                        System.out.println("Two different comets collided!");
                        if(tempDiameter > diameter){ // deletes the current comet, size collision
                            System.out.println("'tmpDiameter > diameter' was triggered!");
                            universe.setEraseObject(index); // sends the index to the array remover
                        }else if(tempDiameter == diameter){                      
                            if(tempSpeed > currentSpeed) { // deletes the current comet, speed collision                                        
                                System.out.println("'tmpSpeed > currentSpeed' was triggered!");
                                universe.setEraseObject(index); // sends the index to the array remover
                            }else if(tempSpeed == currentSpeed) { // deletes both comets
                                System.out.println("'delete both' was triggered!");
                                universe.setEraseObject(counter); // sends the index to the array remover          
                                universe.setEraseObject(counter);
                            }                      
                        }
                    }else if(obj instanceof Star) { // star collision
                        System.out.println("A comet crashed into a star! The star's lifetime was " + obj.lifeTime);
                        int newLifeTime = obj.lifeTime;
                        newLifeTime += area;
                        obj.lifeTime = newLifeTime;   
                        System.out.println("The lifetime is now " + obj.lifeTime);
                        universe.setEraseObject(index); // sends the index to the array remover
                    }else if(obj instanceof Planet) { // planet collision
                        System.out.println("A comet crashed into a planet! The area was " + (obj.diameter * Math.PI));
                        int newDiameter = obj.diameter;
                        newDiameter += Math.sqrt(area / Math.PI);
                        obj.diameter = newDiameter; 
                        System.out.println("The area is now " + (obj.diameter * Math.PI));
                        universe.setEraseObject(index); // sends the index to the array remover
                    }else if(obj instanceof Black_Hole) {  // detects range of comet to blackhole
                        if(attraction == false){ // only iterate this once so that comet does go towards blackhole but does not get slower                                        
                            System.out.println("A comet is being sucked into a black hole!");
                            attraction = true;
                            xSpeed = (tempXPos - xPosition) / ((int)currentSpeed);  // moves x towards blackhole
                            ySpeed = (tempYPos - yPosition) / ((int)currentSpeed);  // moves y towards blackhole                                        
                        }
                        timeElapsed = 0; // reset time elapsed so that behaviours of comets dont occur while being pulled in
                        
                        // increase speed of comet towards blackhole per tick                        
                        xSpeed *= 1.1;
                        ySpeed *= 1.1;                                    
                        System.out.println("xSpeed = " + xSpeed + " ySpeed = " + ySpeed);
                        if(distance <= (radius + (holeRadius / 1.5))){ // deletes object that goes inside the blackhole                                            
                            System.out.println("A comet was destroyed by a black hole!");
                            universe.setEraseObject(index);
                        }
                    }
                }  
            }
            counter++;
        }  
        universe.draw(this);
    }
    
    /**
     * Change behaviours of object when it hits an edge
     * 
    **/
    protected abstract void changeEdge();
    
    /**
     * Change behaviours of object while it moves
     * 
    **/
    protected abstract void changeMove();
    
    /**
     * Return the current index
     * 
     */
    public int getIndex()
    {
        return index;
    }   
}



