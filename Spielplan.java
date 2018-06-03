/**
 * Beschreiben Sie hier die Klasse Spielplan.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 03.06.2018
 */
public class Spielplan
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Nationen nation;
    private Paarungen paarung;

    /**
     * Konstruktor für Objekte der Klasse Spielplan
     */
    public Spielplan()
    {
        nation = new Nationen();
        paarung = new Paarungen();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void fügeLandHinzu(String name, int tore, int punkte)
    {
        nation.landHinzufügen(name, tore, punkte);
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
    public void leseLänderEin()
    {
        nation.erstelleTestLand();
    }

    public void gibLänderDetails()
    {
        System.out.println("Liste der Länder: ");
        for(int i = 0; i < nation.gibAnzahlLänder(); i++) {
            System.out.println(nation.gibLandDetails(i));
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
}
