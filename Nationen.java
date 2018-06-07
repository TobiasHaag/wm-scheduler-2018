import java.util.ArrayList;
import java.util.Iterator;
/**
 * Beschreiben Sie hier die Klasse Nationen.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Nationen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<Land>länder;
    
    /**
     * Konstruktor für Objekte der Klasse Nationen.
     */
    public Nationen()
    {
        länder = new ArrayList<Land>();
    }

    /**
     * Füge der Sammlung ein Land hinzu.
     * @param name der Name der Nation.
     * @param tore die Anzahl der Tore eines Landes.
     * @param punkte die Anzahl der Punkte eines Landes. 
     */
    public void landHinzufügen(String name, int tore, int punkte)
    {
        if (tore >=0 & punkte >=0) {
            länder.add(new Land(name, tore, punkte));
        }
        else {
            System.out.println("Die Anzahl der Tore und Punkte müssen positiv sein!");
        }
    }
    
    /**
     * 
     */
    public void erstelleTestLänder()
    {
        //GruppeA
        länder.add(new Land("Russland", 0, 0));
        länder.add(new Land("Saudi-Arabien", 0, 0));
        länder.add(new Land("Ägypten", 0, 0));
        länder.add(new Land("Uruguay", 0, 0));
        //GruppeB
        länder.add(new Land("Marokko", 0, 0));
        länder.add(new Land("Iran", 0, 0));
        länder.add(new Land("Portugal", 0, 0));
        länder.add(new Land("Spanien", 0, 0));
        //GruppeC
        länder.add(new Land("Frankreich", 0, 0));
        länder.add(new Land("Australien", 0, 0));
        länder.add(new Land("Peru", 0, 0));
        länder.add(new Land("Dänemark", 0, 0));
        //GruppeD
        länder.add(new Land("Argentien", 0, 0));
        länder.add(new Land("Island", 0, 0));
        länder.add(new Land("Kroatien", 0, 0));
        länder.add(new Land("Nigeria", 0, 0));
        //GruppeE
        länder.add(new Land("Costa Rica", 0, 0));
        länder.add(new Land("Serbien", 0, 0));
        länder.add(new Land("Brasilien", 0, 0));
        länder.add(new Land("Schweiz", 0, 0));
        //GruppeF
        länder.add(new Land("Deutschland", 0, 0));
        länder.add(new Land("Mexiko", 0, 0));
        länder.add(new Land("Schweden", 0, 0));
        länder.add(new Land("Südkorea", 0, 0));
        //GruppeG
        länder.add(new Land("Belgien", 0, 0));
        länder.add(new Land("Panama", 0, 0));
        länder.add(new Land("Tunesien", 0, 0));
        länder.add(new Land("England", 0, 0));
        //GruppeH
        länder.add(new Land("Polen", 0, 0));
        länder.add(new Land("Senegal", 0, 0));
        länder.add(new Land("Kolumbien", 0, 0));
        länder.add(new Land("Japan", 0, 0));
    }

    /**
     * Liefere die Anzahl der Länder in dieser Sammlung.
     * @return die Anzahl der länder in dieser Sammlung.
     */
    public int gibAnzahlLänder()
    {
        return länder.size();
    }

    public String gibLandDetails(int index)
    {
        Land land = länder.get(index);
        return land.gibDetails();
    }

    /**
     * Gib eine Liste aller Länder in der Sammlung aus.
     */
    public void alleLänderAusgeben()
    {
        System.out.println("Nationen-Liste: ");

        for (Land land : länder) {
            System.out.println(land.gibDetails());
        }
        System.out.println();
    }

    /**
     * Entferne ein Land aus der Sammlung.
     */
    public void entferneLand (String name)
    {
        Iterator<Land> it = länder.iterator();
        while (it.hasNext()) {
            Land l = it.next();
            if (l.gibName().contains(name)) {
                it.remove();
            }
        }
    }
}
