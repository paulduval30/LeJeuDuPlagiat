package lejeuduplagiat.model;

import java.util.ArrayList;
import java.util.List;

public class StdPersonnage implements Personnage {

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

    public StdPersonnage(Map map, int id){
        this.id = id;
        this.map = map;
        this.ligne = map.getGrillePersonnage()[1][1] == Valeur.caseVide.getValue() ? 1 :
                map.getGrillePersonnage().length - 2;
        this.colonne = map.getGrillePersonnage()[1][1] == Valeur.caseVide.getValue() ? 1 :
                map.getGrillePersonnage()[0].length - 2;;
        this.nom = "Sans nom";
        this.vie = 20;
        this.force = 3;
        this.armure = 0;
        this.vitesse = 3;
        this.intell = 3;
        this.chanceCrit = 0;
        this.ptsMouvement = 6;
        this.ptsAction = 3;
        this.avatar = "default";
        this.lEquipement = new ArrayList();
        this.lSort = new ArrayList();
        System.out.println(id + " " + ligne +" " + colonne);
    }

    @Override
    public int getColonne() {
        return this.colonne;
    }

    @Override
    public int getLigne() {
        return this.ligne;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getVie() {
        return this.vie;
    }

    @Override
    public int getForce() {
        return this.force;
    }

    @Override
    public int getArmure() {
        return this.armure;
    }

    @Override
    public int getVitesse() {
        return this.vitesse;
    }

    @Override
    public int getIntelligence() {
        return this.intell;
    }

    @Override
    public int getChanceCritique() {
        return this.chanceCrit;
    }

    @Override
    public int getPointMouvement() {
        return this.ptsMouvement;
    }

    @Override
    public int getPointAction() {
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
    public boolean deplacer(int ligne, int colonne) {
        if(this.canWalk(ligne, colonne)){
            int dist = this.ligne + this.colonne - ligne - colonne;
            int v = this.map.getCase(this.ligne, this.colonne);
            this.map.setCase(this.ligne, this.colonne, this.map.getGrille()[ligne][colonne]);
            this.map.setCase(ligne, colonne, v);
            this.ptsMouvement -= (dist >= 0 ? 1 : -1) * dist;
            this.colonne = colonne;
            this.ligne = ligne;
            System.out.println("PM : " + this.ptsMouvement);
            return true;
        }
        return false;
    }

    @Override
    public String getAvatar() {
        return this.avatar;
    }

    @Override
    public List<Equipement> getEquipements() {
        return this.lEquipement;
    }

    @Override
    public List<Sort> getSorts() {
        return this.lSort;
    }

    @Override
    public boolean canWalk(int ligne, int colonne)
    {
        int deltaCurrent = this.ligne + this.colonne;
        int deltaNew = ligne + colonne;

        return !(deltaCurrent - deltaNew > this.ptsMouvement || deltaNew - deltaCurrent > this.ptsMouvement
                || this.map.getGrille()[ligne][colonne] > 0);
    }

    @Override
    public void endTurn()
    {
        this.ptsMouvement = 6;
        this.ptsAction = 3;
    }
}
