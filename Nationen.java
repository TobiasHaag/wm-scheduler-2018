import java.util.ArrayList;
import java.util.Iterator;
/**
 * Beschreiben Sie hier die Klasse Nationen.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 03.06.2018
 */
public class Nationen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<Land> länder;

    /**
     * Konstruktor für Objekte der Klasse Nationen.
     */
    public Nationen()
    {
        länder = new ArrayList<>();
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
    public void erstelleTestLand()
    {
        String name = "Russland";
        int tore = 0;
        int punkte = 0;
        länder.add(new Land(name, tore, punkte));
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
