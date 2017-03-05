import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class - UniverseTest.
 *
 * @author up769535
 * @version 2016.1.22
 */
public class UniverseTest
{
    /**
     * Test Class UniverseTest Default Construct
     */
    public UniverseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**     
     * Check that the array is set to 0 before objects are inserted
     */
    @Test
    public void checkSpaceObjectsBeforeRun()
    {
        Universe universe1 = new Universe();
        assertEquals(0, universe1.getNumberOfSpaceObjects());
    }       

    @Test
    public void checkGetGround()
    {
        Universe universe1 = new Universe();
        assertEquals(500, universe1.getGround());
    }

    @Test
    public void checkGetRight()
    {
        Universe universe1 = new Universe();
        assertEquals(600, universe1.getRight());
    }
}






