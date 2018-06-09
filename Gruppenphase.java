
/**
 * Beschreiben Sie hier die Klasse Gruppenphase.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Gruppenphase
{
    private Gruppen gruppe;
    
    /**
     * Konstruktor für Objekte der Klasse Land.
     * @param name der Name der Nation.
     * @param tore die Anzahl der geschossenen Tore.
     * @param punkte die Anzahl der erreichten Punkte.
     */
    public Gruppenphase()
    {
        gruppe = new Gruppen();
    }
    
    /**
     * Lege die Details des Landes fest.
     * @param name der Name der Nation.
     * @param tore die Anzahl der Tore eines Landes.
     * @param punkte die Anzahl der Punkte eines Landes. 
     */
    public void setzeGruppen()
    {
        gruppe.erstelleGruppeA();
        gruppe.erstelleGruppeB();
        gruppe.erstelleGruppeC();
        gruppe.erstelleGruppeD();
        gruppe.erstelleGruppeE();
        gruppe.erstelleGruppeF();
        gruppe.erstelleGruppeG();
        gruppe.erstelleGruppeH();
    }
    
}
