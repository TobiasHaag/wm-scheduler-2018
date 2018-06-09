import java.util.HashSet;
/**
 * Beschreiben Sie hier die Klasse Spielplan.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Spielplan
{
    private Gruppenphase gruppenphase;
    private Gruppen gruppe;
    private Paarungen paarung;
    private Eingabe leser;

    /**
     * Konstruktor für Objekte der Klasse Spielplan
     */
    public Spielplan()
    {
        gruppenphase = new Gruppenphase();
        gruppe = new Gruppen();
        paarung = new Paarungen();
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
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void fügeLandHinzu(String name, int tore, int punkte)
    {
        gruppe.landHinzufügen(name, tore, punkte);
    }

    public void fügeSpielHinzu(String landX, String landY, int torX, int torY, String beschreibung)
    {
        paarung.spielHinzufügen(landX, landY, torX, torY, beschreibung);
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void leseGruppenEin()
    {
        gruppenphase.setzeGruppen();
    }

    public void gibLänderDetails()
    {
        System.out.println("Liste der Länder: ");
        for(int i = 0; i < gruppe.gibAnzahlLänder(); i++) {
            System.out.println(gruppe.gibLandDetails(i));
        }
        System.out.println();
    }
    
    public void gibSpieleDetails()
    {
        System.out.println("Liste der Spiele: ");
        for(int i = 0; i < paarung.gibAnzahlSpiele(); i++) {
            System.out.println(paarung.gibSpielDetails(i));
        }
        System.out.println();
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
