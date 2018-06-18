import java.util.HashMap;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 18.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> turnierGruppen;
    /**
     * 
     */
    public Turnier()
    {
        turnierGruppen = new HashMap<>();
        ladeGruppen();
    }

    /**
     *
     */
    public void ladeGruppen()
    {
        turnierGruppen.put("A", new Gruppe("A"));
        turnierGruppen.put("B", new Gruppe("B"));
        turnierGruppen.put("C", new Gruppe("C"));
        turnierGruppen.put("D", new Gruppe("D"));
        turnierGruppen.put("E", new Gruppe("E"));
        turnierGruppen.put("F", new Gruppe("F"));
        turnierGruppen.put("G", new Gruppe("G"));
        turnierGruppen.put("H", new Gruppe("H"));
    }
    
    /**
     *
     */
    public void gibPaarungen(String nation1, int tor1, String nation2, int tor2)
    {
        for ()
        }
    }
}
