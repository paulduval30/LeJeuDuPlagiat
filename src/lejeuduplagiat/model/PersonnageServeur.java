package lejeuduplagiat.model;

import lejeuduplagiat.network.client.Client;

import java.util.ArrayList;
import java.util.List;

public class PersonnageServeur implements Personnage
{
    private int colonne;
    private int ligne;
    private int vie;
    private String nom;
    private int force;
    private int armure;
    private int vitesse;
    private int intell;
    private int chanceCrit;
    private int ptsMouvement;
    private int ptsAction;
    private String avatar;
    private List lEquipement;
    private List lSort;
    private Map map;



    int id;

    public PersonnageServeur(int ligne, int colonne, int vie, String nom,
                             int force, int armure, int vitesse, int intell,
                             int chanceCrit, int ptsMouvement, int ptsAction,
                             String avatar, List lEquipement, List lSort,
                             Map map, int id)
    {
        this.ligne = map.getGrillePersonnage()[1][1] == Valeur.caseVide.getValue() ? 1 :
                map.getGrillePersonnage().length - 2;
        this.colonne = map.getGrillePersonnage()[1][1] == Valeur.caseVide.getValue() ? 1 :
                map.getGrillePersonnage()[0].length - 2;
        this.vie = vie;
        this.nom = nom;
        this.force = force;
        this.armure = armure;
        this.vitesse = vitesse;
        this.intell = intell;
        this.chanceCrit = chanceCrit;
        this.ptsMouvement = ptsMouvement;
        this.ptsAction = ptsAction;
        this.avatar = avatar;
        this.lEquipement = lEquipement;
        this.lSort = lSort;
        this.map = map;
        this.id = id;


    }

    @Override
    public int getColonne()
    {
        return this.colonne;
    }

    @Override
    public int getLigne()
    {
        return this.ligne;
    }

    @Override
    public String getNom()
    {
        return this.nom;
    }

    @Override
    public int getVie()
    {
        return this.vie;
    }

    @Override
    public int getForce()
    {
        return this.force;
    }

    @Override
    public int getArmure()
    {
        return this.armure;
    }

    @Override
    public int getVitesse()
    {
        return this.vitesse;
    }

    @Override
    public int getIntelligence()
    {
        return this.intell;
    }

    @Override
    public int getChanceCritique()
    {
        return this.chanceCrit;
    }

    @Override
    public int getPointMouvement()
    {
        return this.ptsMouvement;
    }

    @Override
    public int getPointAction()
    {
        return this.ptsAction;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    @Override
    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public boolean deplacer(int ligne, int colonne)
    {
        return false;
    }

    @Override
    public String getAvatar()
    {
        return this.avatar;
    }

    @Override
    public List<Equipement> getEquipements()
    {
        return this.lEquipement;
    }

    @Override
    public List<Sort> getSorts()
    {
        return this.lSort;
    }

    @Override
    public boolean canWalk(int ligne, int colonne)
    {
        return false;
    }

    @Override
    public void endTurn()
    {

    }


    @Override
    public ArrayList<int[]> getChemin(int ligneArr, int colArr)
    {
        return null;
    }
}
