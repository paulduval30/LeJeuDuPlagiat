package lejeuduplagiat.network.serveur;

import lejeuduplagiat.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reception
{
    public static void passerTour()
    {
        Game g = Serveur.instance.getGameModel();
        g.getCurrent().endTurn();;
        g.nextTurn();
    }

    public static void deplacement(String message)
    {
        String[] data = message.split(",");
        int ligne = Integer.parseInt(data[0]);
        int colonne = Integer.parseInt(data[1]);

        Game g = Serveur.instance.getGameModel();
        g.deplacer(g.getCurrent(),ligne, colonne);
    }

    /**
     * ligne, colonne, nom, id, force, armure, vitesse, intell, chanceCrit, ptsMouvements, ptsActions, avatar, lSort, lEquipement, id;
     * @param message
     */
    public void recevoirJoueur(String message)
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
        Map map = Serveur.instance.getGameModel().getMap();

        int id = Integer.parseInt(data[13]);

        new PersonnageServeur(ligne, colonne, vie, nom, force, armure,
                vitesse, intell, chanceCrit, ptsMouvement, ptsAction, "",
                lEquipement, lSort, map, id);
    }
}
