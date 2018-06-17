import java.util.HashMap;
/**
 * Beschreiben Sie hier die Klasse Spiele.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiele
{
    private HashMap<String, String> spiele;
    private RW rw;
    private Gruppe gruppe;
    
    
    /**
     * 
     */
    public void ladeGruppeninfo(String name)
    {
        String[] element = gibDatenElemente("Gruppen", name);
        anzahlNationen = nationen.size();
        for (int i = 1; i <= anzahlNationen; i++) {
            ladeNation(element[i]);
        }

        if(element.length >= anzahlNationen+2){
            for (int i = anzahlNationen+1; i < element.length; i++) {
                String[] daten = element[i].split("-");
                spiele.put(daten[0], daten[1]);
            }
        }
    }

    
}
