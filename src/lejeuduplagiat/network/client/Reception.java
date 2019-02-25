package lejeuduplagiat.network.client;

import lejeuduplagiat.model.*;
import lejeuduplagiat.network.serveur.Serveur;

import java.util.ArrayList;

public class Reception
{
    public static void recevoirJoueurDeServeur(String message, GameModel m)
    {
        String[] data = message.split(",");
        int ligne = Integer.parseInt(data[0]);
        int colonne = Integer.parseInt(data[1]);
        int vie = Integer.parseInt(data[2]);
        String nom = data[3];
        int force = Integer.parseInt(data[4]);
        int armure = Integer.parseInt(data[5]);
        int vitesse = Integer.parseInt(data[6]);
        int intell = Integer.parseInt(data[7]);
        int chanceCrit = Integer.parseInt(data[8]);
        int ptsMouvement = Integer.parseInt(data[9]);
        int ptsAction = Integer.parseInt(data[10]);
        ArrayList<Equipement> lEquipement = new ArrayList<>();
        for(String s : data[11].split("/"))
            lEquipement.add(Equipement.getEquipement(s));


        ArrayList<Sort> lSort = new ArrayList<>();
        for(String s : data[12].split("/"))
            lSort.add(Sort.getSort(s));
        Map map = m.getMap();

        int id = Integer.parseInt(data[13]);

        Personnage p = new StdPersonnage(ligne, colonne, vie, nom, force, armure,
                vitesse, intell, chanceCrit, ptsMouvement, ptsAction, "",
                lEquipement, lSort, map, id);
        m.ajouterPersonnage(p);

    }

    public static void recevoirDeplacement(String message, GameModel m)
    {
        String[] data = message.split(",");
        int ligne = new Integer(data[0]);
        int colonne = new Integer(data[1]);
        int id = new Integer(data[3]);

        m.deplacer(Serveur.instance.getGameModel().getPersonnage(id - 3), ligne, colonne);
    }

    public static void recevoirFinTour(GameModel m)
    {
        m.nextTurn();
    }

    public static void recevoirCurrent(String message, GameModel m)
    {
        int current = Integer.parseInt(message);
        m.setCurrent(current);
    }
}
