package lejeuduplagiat.network.serveur;

import lejeuduplagiat.model.Equipement;
import lejeuduplagiat.model.Personnage;
import lejeuduplagiat.model.Sort;
import lejeuduplagiat.network.client.Client;

public class Paquet
{
    public static void envoyerJoueurAClient(Personnage p)
    {
        String paquet = "1->" + p.getLigne() + "," + p.getColonne() + "," + p.getVie() + "," + p.getNom()
                + "," + p.getForce() + "," + p.getArmure() + "," + p.getVitesse() + "," + p.getIntelligence()
                + "," + p.getChanceCritique() + "," + p.getPointMouvement() + "," + p.getPointAction() + ",";
        paquet+= ",";
        paquet += ",";
        paquet += p.getId();
        System.out.println("ENVOIE");
        Serveur.instance.sendAll(paquet);
    }

    public static void envoyerChangementTour()
    {
        Serveur.instance.sendAll("3->ChangementTour");
    }

    public static void envoyerCurrent()
    {
        int current = (int)(Math.random() *2 + 3);
        System.out.println(current);
        //Serveur.instance.sendAll("4->" + current);
    }
}
