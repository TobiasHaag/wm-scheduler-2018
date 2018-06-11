import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Gruppenphase.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Gruppenphase
{
    private ArrayList<Gruppen> gruppe;
    private EA ea;
    /**
     * Konstruktor für Objekte der Klasse Land.
     * @param name der Name der Nation.
     * @param tore die Anzahl der geschossenen Tore.
     * @param punkte die Anzahl der erreichten Punkte.
     */
    public Gruppenphase()
    {
        gruppe = new ArrayList<>();
        setzeGruppe();
        ea = new EA();
    }
    
    /**
     *
     */
    public void setzeGruppe()
    {
        gruppe.add(new Gruppen("A"));
        gruppe.add(new Gruppen("B"));
        gruppe.add(new Gruppen("C"));
        gruppe.add(new Gruppen("D"));
        gruppe.add(new Gruppen("E"));
        gruppe.add(new Gruppen("F"));
        gruppe.add(new Gruppen("G"));
        gruppe.add(new Gruppen("H"));
    }
    
    /**
     * 
     */
    private String gibDatenSpielergebnis(String land, int tore, int punkte)
    {
        boolean check = false;
        String daten = "";
        for (int i = 0; i < gruppe.size(); i++) {
            Gruppen gruppen = gruppe.get(i);

            if(gruppen.prüfeLand(land) == true){
                check = true;      
                daten = gruppen.gibInfoLand(land, tore, punkte);
            }
        }

        if(check == false){
            return null;
        }

        return daten;
    }

    public void updateSpielergebnis(String land1, int tore1, String land2, int tore2)
    {
        Integer gruppe1 = 0;
        Integer gruppe2 = 0;
        int punkte1 = 0;
        int punkte2 = 0;

        if(tore1 > tore2){punkte1 = 3;}
        if(tore1 < tore2){punkte2 = 3;}
        if(tore1 == tore2){punkte1 = 1; punkte2 = 1;}

        for (int i = 0; i < gruppe.size(); i++) {
            Gruppen gruppen = gruppe.get(i);
            if(gruppen.prüfeLand(land1) == true){
                gruppe1 = i;
            }
        }
        for (int i = 0; i < gruppe.size(); i++) {
            Gruppen gruppen = gruppe.get(i);
            if(gruppen.prüfeLand(land2) == true){
                gruppe2 = i;
            }
        }

        if(gruppe1 == gruppe2){
            Gruppen gruppeEins = gruppe.get(gruppe1);
            
            if(speichereLand(land1, tore1, punkte1) && speichereLand(land2, tore2, punkte2)== true){
                gruppeEins.speichereErgebnis(land1, land2, tore1, tore2);
                // hier kommt io.appendGruppe
            }
           
        }
        else{System.out.println("Die Länder sind nicht in einer Gruppe!");}
    }

    /**
     * 
     */
    public boolean speichereLand(String land, int tore, int punkte)
    {
        if(gibDatenSpielergebnis(land, tore, punkte) == null){
            System.out.println("Das Land " + land + " existiert nicht");
            return false;
        }
        else{
            try{
                ea.speichereLand(gibDatenSpielergebnis(land, tore, punkte));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }
    
}
