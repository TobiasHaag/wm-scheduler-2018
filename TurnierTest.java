

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse TurnierTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
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
        turnier1.zeigeAlleNationenWerte();
    }

    @Test
    public void zeigeAlleGruppen()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeAlleGruppen();
    }

    @Test
    public void prüfeNationenInGruppe()
    {
        Turnier turnier1 = new Turnier();
        assertEquals("F", turnier1.prüfeNationenInGruppe("Deutschland", "Mexiko"));
    }

    @Test
    public void zeigeNationTore()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeNationTore("A", "Russland");
    }

    @Test
    public void zeigeNationPunkte()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeNationPunkte("A", "Russland");
    }

    @Test
    public void zeigeNationDetails()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeNationDetails("A", "Russland");
    }

    @Test
    public void zeigeAlleTurnierPaarungen()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeAlleTurnierPaarungen();
    }

    @Test
    public void zeigeTurnierPaarungengruppenname()
    {
        Turnier turnier1 = new Turnier();
        turnier1.zeigeTurnierPaarungenFürGruppe("A");
    }

    @Test
    public void fügeGruppeHinzu()
    {
        Turnier turnier1 = new Turnier();
        turnier1.fügeGruppeHinzu("I");
    }

    @Test
    public void fügeNeueNationInGruppeHinzu()
    {
        Turnier turnier1 = new Turnier();
        turnier1.fügeNeueNationInGruppeHinzu("A", "China");
    }

    @Test
    public void fügeNationMitWertenInGruppeHinzu()
    {
        Turnier turnier1 = new Turnier();
        turnier1.fügeNationMitWertenInGruppeHinzu("F", "Australien", 3, 3);
    }

    @Test
    public void Spielergebnis()
    {
        Turnier turnier2 = new Turnier();
        turnier2.Spielergebnis("F", "Deutschland", 2, "Schweden", 1);
    }

    @Test
    public void gibGruppen()
    {
        Turnier turnier1 = new Turnier();
        assertNotNull(turnier1.gibGruppen());
    }

    @Test
    public void gibGruppeÜberNation()
    {
        Turnier turnier1 = new Turnier();
        assertNotNull(turnier1.gibGruppeÜberNation("Russland"));
    }
}



















