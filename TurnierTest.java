import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse TurnierTest.
 *
 * Prüfung Programmiersprachen2
 * @author Tobias Haag | HfG | IoT3
 * @version 30.06.2018
 */
public class TurnierTest
{
    /**
     * Konstruktor fuer die Test-Klasse TurnierTest
     */
    public TurnierTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void fügeGruppeHinzu()
    {
        Turnier turnier1 = new Turnier();
        turnier1.fügeGruppeHinzu("I");
    }

    @Test
    public void fügeNationMitWertenInGruppeHinzu()
    {
        Turnier turnier1 = new Turnier();
        turnier1.fügeNationMitWertenInGruppeHinzu("A", "China", 3, 4);
    }

    @Test
    public void fügeNeueNationInGruppeHinzu()
    {
        Turnier turnier1 = new Turnier();
        turnier1.fügeNeueNationInGruppeHinzu("I", "Australien");
    }

    @Test
    public void zeigeAlleGruppen()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeAlleGruppen();
    }

    @Test
    public void zeigeAlleNationenSchlüssel()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeAlleNationenSchlüssel();
    }

    @Test
    public void zeigeAlleNationenWerte()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeAlleNationenWerte();
    }

    @Test
    public void zeigeAlleTurnierPaarungen()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeAlleTurnierPaarungen();
    }

    @Test
    public void zeigeNationDetails()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeNationDetails("A", "Russland");
    }

    @Test
    public void zeigeNationPunkte()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeNationPunkte("F", "Deutschland");
    }

    @Test
    public void zeigeNationTore()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeNationTore("F", "Deutschland");
    }

    @Test
    public void zeigeTurnierPaarungenfürGruppe()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeTurnierPaarungenFürGruppe("A");
    }

    @Test
    public void Spielergebnis()
    {
        Turnier turnier1 = new Turnier();
        turnier1.Spielergebnis("F", "Deutschland", 2, "Schweden", 0);
    }
}


















