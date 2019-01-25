package lejeuduplagiat.model;

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
        this.colonne = colonne;
        this.ligne = ligne;
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
        return 0;
    }

    @Override
    public int getLigne()
    {
        return 0;
    }

    @Override
    public String getNom()
    {
        return null;
    }

    @Override
    public int getVie()
    {
        return 0;
    }

    @Override
    public int getForce()
    {
        return 0;
    }

    @Override
    public int getArmure()
    {
        return 0;
    }

    @Override
    public int getVitesse()
    {
        return 0;
    }

    @Override
    public int getIntelligence()
    {
        return 0;
    }

    @Override
    public int getChanceCritique()
    {
        return 0;
    }

    @Override
    public int getPointMouvement()
    {
        return 0;
    }

    @Override
    public int getPointAction()
    {
        return 0;
    }

    @Override
    public int getId()
    {
        return 0;
    }

    @Override
    public void setId(int id)
    {

    }

    @Override
    public boolean deplacer(int ligne, int colonne)
    {
        return false;
    }

    @Override
    public String getAvatar()
    {
        return null;
    }

    @Override
    public List<Equipement> getEquipements()
    {
        return null;
    }

    @Override
    public List<Sort> getSorts()
    {
        return null;
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
}
