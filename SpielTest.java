
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TurnierTest.
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SpielTest
{
    /**
     * Default constructor for test class TurnierTest
     */
    public SpielTest()
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

    @Test
    public void spielergebnisEingabe()
    {
        Turnier gruppenp1 = new Turnier();
        gruppenp1.updateSpielergebnis("Deutschland", 4, "Mexiko", 2);
    }

     @Test
    public void spielergebnisEingabeRück()
    {
        Turnier gruppenp1 = new Turnier();
        gruppenp1.updateSpielergebnis("Mexiko", 2, "Deutschland", 4);
    }
}
