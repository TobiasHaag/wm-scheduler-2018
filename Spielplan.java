import java.util.HashSet;
/**
 * Beschreiben Sie hier die Klasse Spielplan.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Spielplan
{
    private Eingabe leser;

    /**
     * Konstruktor für Objekte der Klasse Spielplan
     */
    public Spielplan()
    {
        leser = new Eingabe();
        systemStart();
    }
    
    /**
     * Starte das System für den WM Scheduler 2018.
     * Über die Konsole können verschiedene Informationen zu Nationen, Gruppen, Spiele aufgerufen werden.
     * Außerdem können auch Änderungen im Spielplan gemacht und danach gespeichert werden.
     * Das System kann ebenfalls beendet werden.
     */
    public void systemStart()
    {
        System.out.println("WM Scheduler 2018 ****");
        System.out.println("Ihr persönlicher, digitaler WM Planer der Fußball WM 2018.");
        System.out.println();
        System.out.println("Sie können ...");
        System.out.println("Bitte tippen Sie 'go, um das System zu starten.");  
        System.out.println();
        boolean fertig = false;

        while(!fertig) {
            HashSet<String> eingabe = leser.gibEingabe();
            if(eingabe.contains("go")) {
                fertig = true;
            }
            else {
                System.out.println("Bitte wiederholen Sie die Eingabe 'go' um das System zu beenden!");
            }
        }
        startAusgeben();
    }
    
    /**
     * Information für den Benutzer beim Beenden des Programms.
     */
    private void startAusgeben()
    {
        System.out.println("Das Programm ist start bereit.");
        System.out.println();
    }
}
