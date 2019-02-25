package lejeuduplagiat.network.client;

import lejeuduplagiat.model.Equipement;
import lejeuduplagiat.model.Game;
import lejeuduplagiat.model.Personnage;
import lejeuduplagiat.model.Sort;
import lejeuduplagiat.network.serveur.Serveur;

import java.util.List;

public class Paquet
{
    public static void envoyerJoueurAServeur(Personnage p, Client c)
    {
        String paquet = "1->" + p.getLigne() + "," + p.getColonne() + "," + p.getVie() + "," + p.getNom()
                + "," + p.getForce() + "," + p.getArmure() + "," + p.getVitesse() + "," + p.getIntelligence()
                + "," + p.getChanceCritique() + "," + p.getPointMouvement() + "," + p.getPointAction() + ",";

       /* for(Equipement e : p.getEquipements())
            paquet += e.getNom() + "/";*/

        paquet+= ",";
        /*for(Sort s : p.getSorts())
            paquet += s.getNom() +"/";*/
        c.send(paquet);
    }

    public static void envoyerDeplacement(int ligne, int colonne, Personnage p, Client c)
    {
        String paquet = "2->" + ligne + "," + colonne + "," + p.getId();
        c.send(paquet);
    }

    public static void envoyerFinTour(Client c)
    {
        c.send("3->Fin tour");
    }
}
