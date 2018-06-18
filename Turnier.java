import java.util.HashMap;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 19.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppen;
    /**
     * 
     */
    public Turnier()
    {
        gruppen = new HashMap<>();
        erstelleGruppenMap();
    }

    /**
     *
     */
    public void erstelleGruppenMap()
    {
        gruppen.put("A", new Gruppe("A"));
        gruppen.put("B", new Gruppe("B"));
        gruppen.put("C", new Gruppe("C"));
        gruppen.put("D", new Gruppe("D"));
        gruppen.put("E", new Gruppe("E"));
        gruppen.put("F", new Gruppe("F"));
        gruppen.put("G", new Gruppe("G"));
        gruppen.put("H", new Gruppe("H"));
    }
    
    private Gruppe gibGruppeWennNation(String nation)
    {
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
            if(gruppe.prüfeNation(nation) == true){
                return gruppe;
            }
        }
        return null;
    }
    
    /**
     *
     */
    public void (String nation1, int tore1, String nation2, int tore2)
    {
        
    }
}
