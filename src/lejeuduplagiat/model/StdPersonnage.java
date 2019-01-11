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

    public StdPersonnage(Map map){
        this.map = map;
        this.ligne = 0;
        this.colonne = 0;
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
    public boolean deplacer(int colonne, int ligne) {
        if(this.map.getCase(ligne, colonne) < 1){
            int v = this.map.getCase(this.ligne, this.colonne);
            this.map.setCase(this.ligne, this.colonne, this.map.getOldCase(this.ligne, this.colonne));
            this.map.setCase(ligne, colonne, v);
            this.colonne = colonne;
            this.ligne = ligne;
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
}
