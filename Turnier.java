import java.util.HashMap; // Import-Anweisung um die Bibliotheksklasse HashMap in dieser Klasse verfügbar zu machen.
import java.util.ArrayList; // Import-Anweisung um die Bibliotheksklasse ArrayList in dieser Klasse verfügbar zu machen.
import java.util.Arrays; // Import-Anweisung um die Bibliotheksklasse Arrays in dieser Klasse verfügbar zu machen.
/**
 * Klasse Turnier:
 * 
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 24.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppen;
    private HashMap<String, Nation> nationen;
    //private ArrayList<Gruppe> alleGruppen;
    //private ArrayList<Nation> alleNationen;
    private ArrayList<String> alleNationen;
    private int gruppenanzahl = 8;
    /**
     * 
     */
    public Turnier()
    {
        gruppen = new HashMap<>();
        alleNationen = new ArrayList<>();
        //alleNationen = new ArrayList<>();
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
    
    /**
     * Hier wird eine Übersicht von allen Nationen erstellt.
     */
    public void zeigeNationen(){
        //ArrayList <String> alleNationen = gruppe.gibNationen();
        for (String key : gruppen.keySet()) {
            String name = key;
            Gruppe gruppe = gruppen.get(key);
            ArrayList <String> alleNationen = gruppe.gibAlleNationen();
        }
    }
    
    /**
     * 
     */
    public ArrayList<String> gibGruppen()
    {
        ArrayList <String> elementdaten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            elementdaten.add(key);
        }
        return elementdaten;
    }
    
    /**
     * 
     */
    public void zeigeGruppen()
    {
        ArrayList <String> elementdaten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            elementdaten.add(key);
        }
        System.out.println(elementdaten);
    }
    
    /**
     * 
     */
    public Gruppe gibGruppeÜberNation (String nation)
    {
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
        }
        return null;
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
     */
    public ArrayList<String> gibAlleNationen ()
    {
        ArrayList elemente = new ArrayList<String> ();
        char[] firstLetter = new char[gruppenanzahl];
        for(int i = 0; i < gruppenanzahl; i++){
           firstLetter[i] = (char)(65 + i);
           Gruppe gruppe = gruppen.get(String.valueOf(firstLetter[i]));
           elemente.add (gruppe.gibAlleNationen());
        }
        return elemente;
    }
    
    /**
     * 
     */
    public void zeigeAlleNationen1 ()
    {
        ArrayList elemente = new ArrayList<String> ();
        char[] firstLetter = new char[gruppenanzahl];
        for(int i = 0; i < gruppenanzahl; i++){
           firstLetter[i] = (char)(65 + i);
           Gruppe gruppe = gruppen.get(String.valueOf(firstLetter[i]));
           //System.out.println (gruppe.gibNationTore().toString());
        }
    }
    
    /**
     * Hier wird eine Übersicht von allen Nationen erstellt.
    
    public void zeigeAlleNationen2(){
        ArrayList elemente = new ArrayList<String> ();
        for(int i = 0; i < gruppenanzahl; i++){
            // gruppen[i].getNationen();
            elemente.add (gruppe.gibAlleNationen());
            System.out.println(gruppen.getNation());
        }

    }
    */
    
    /**
     * 
     */
    public void zeigeAlleNationenTore ()
    {
           Gruppe gruppe = gruppen.get("F");
           System.out.println (gruppe.gibToreNation("Deutschland"));
    }
    
    /**
     * 
     */
    public void zeigeAlleNationenWerte()
    {
        ArrayList elemente = new ArrayList<String> ();
        char[] firstLetter = new char[gruppenanzahl];
        for(int i = 0; i < gruppenanzahl; i++){
           firstLetter[i] = (char)(65 + i);
           Gruppe gruppe = gruppen.get("A");
           System.out.println (gruppe.gibAlleNationen().toString());
        }
    }
    
    /**
     * 
     */
    public String gibDatenSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppeÜberNation(nation);
        String daten = gruppe.gibVeränderteDetailsNation(nation, tore, punkte);
        return daten;
    }
    
    
    /**
     * 
     */
    public int[] berechnePunkte(int tore1, int tore2)
    {
        int[] punkte = {0, 0};
        if(tore1 > tore2){
            punkte[0] = 3;
        }
        if(tore1 < tore2){
            punkte[1] = 3;
        }
        if(tore1 == tore2){
            punkte[0] = 1; punkte[1] = 1;
        }
        return punkte;
    }
    
    /**
     * 
    public void updateSpielergebnis(String nation1, int tore1, String nation2, int tore2)
    {
        int punkte1 = 0;
        int punkte2 = 0;
        String nationA = großSchreibung(nation1);
        String nationB = großSchreibung(nation2);
        
        if(tore1 > tore2){
            punkte1 = 3;
        }
        if(tore1 < tore2){
            punkte2 = 3;
        }
        if(tore1 == tore2){
            punkte1 = 1; punkte2 = 1;
        }
        
        String daten = nation1 + ":" + nation2 + "-" + tore1 + ":" + tore2;
        String datenSpieler = nation1 + ":" + nation2;
        String datenSpielerRück = nation2 + ":" + nation1;
        String gruppe = prüfeNationenInGruppe(nation1, nation2);

        if(prüfeNationenInGruppe(nation1, nation2) != null){
            Gruppe gruppeEins = gruppen.get(gruppe);
            if(gruppeEins.gibDetailsNation(gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDetailsNation(gruppe).contains(datenSpielerRück) == false){
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
