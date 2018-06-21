import java.util.HashMap;
import java.util.ArrayList;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 19.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppen;
    private HashMap<String, Nation> nationen;
    private ArrayList<Gruppe> alleGruppen;
    private ArrayList<Nation> alleNationen;
    /**
     * 
     */
    public Turnier()
    {
        gruppen = new HashMap<>();
        alleGruppen = new ArrayList<>();
        alleNationen = new ArrayList<>();
        erstelleGruppenMap();
    }

    /**
     *
     */
    private void erstelleGruppenMap()
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
    
    /**
     * 
     */
    public ArrayList<String> gibGruppen()
    {
        ArrayList <String> daten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            daten.add(key);
        }
        return daten;
    }
    
    /**
     * 
     */
    public Gruppe gibGruppe (String nation)
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
    public String prüfeNationenInGruppe(String nation1, String nation2)
    {
        String gruppe1 = "";
        String gruppe2 = "";
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
            if(gruppe.prüfeNation(nation1) == true){
                gruppe1 = key;
            }
            if(gruppe.prüfeNation(nation2) == true){
                gruppe2 = key;
            }
        }

        if(gruppe1 == gruppe2){
            return gruppe1;
        }
        else{
            return null;
        }
    }
    
    /**
     * 
     */
    public ArrayList<String> gibAlleNationenSchlüssel (String name)
    {
        Gruppe gruppe = gruppen.get(name);
        return gruppe.gibAlleNationen();
    }
    
    /**
     * 
     *
    private ArrayList<String> gibAlleNationenWerte (String name)
    {
        Gruppe gruppe = gruppen.get(name);
        return gruppe.gibAlleNationen();
        gruppe.get
    }
    */
    
    /**
     * 
     */
    private String[] gibDatenSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppeWennLand(land);
        return gruppe.gibUpdatedInfoLand(land, tore, punkte);
    }
       
    /*public void updateSpielergebnis(String nation1, int tore1, String nation2, int tore2)
    {
        int punkte1 = 0;
        int punkte2 = 0;

        if(tore1 > tore2){
            punkte1 = 3;
        }
        if(tore1 < tore2){
            punkte2 = 3;
        }
        if(tore1 == tore2){
            punkte1 = 1;
            punkte2 = 1;
        }

        String daten = nation1 + ":" + nation2 + "-" + tore1 + ":" + tore2;
        String datenSpieler = nation1 + ":" + nation2;
        String datenSpielerRück = nation2 + ":" + nation1;
        String gruppe = prüfeNationenInGruppe(nation1, nation2);

        if(prüfeNationenInGruppe(nation1, nation2) != null){
            Gruppe gruppeEins = gruppen.get(gruppe);
            if(gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpielerRück) == false){

                if(speichereNation(nation1, tore1, punkte1) && speichereNation(nation2, tore2, punkte2)== true){
                    try{
                        rw.hinzufügenGruppe(gruppe, daten);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    gruppeEins.ladeGruppeninfo(gruppe);
                }
            }
            else{System.out.println("Das Ergebnis wurde bereits eingegeben!");}
        }
        else{System.out.println("Die Nationen sind nicht in einer Gruppe!");}
    }*/
}
