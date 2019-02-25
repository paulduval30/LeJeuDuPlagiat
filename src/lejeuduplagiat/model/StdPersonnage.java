package lejeuduplagiat.model;

import lejeuduplagiat.network.client.Client;
import lejeuduplagiat.network.client.Paquet;

import java.util.ArrayList;
import java.util.List;

public class StdPersonnage implements Personnage {

    private int[][] matriceCoup;

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
    private Client client;
    int id;

    public StdPersonnage(String nom, Map map){
        this.map = map;
        this.ligne = map.getGrillePersonnage()[1][1] == Valeur.caseVide.getValue() ? 1 :
                map.getGrillePersonnage().length - 2;
        this.colonne = map.getGrillePersonnage()[1][1] == Valeur.caseVide.getValue() ? 1 :
                map.getGrillePersonnage()[0].length - 2;
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
        this.matriceCoup = new int[this.map.getGrille().length][this.map.getGrille().length];
        this.nom = nom;
        for(int i = 0; i < matriceCoup.length; i++)
        {

            for(int j = 0; j < matriceCoup.length; j++)
            {
                matriceCoup[i][j] = 100;
            }
        }

        this.matriceCoup = this.map.genererMatriceCoup(this.matriceCoup, 0, this.ligne, this.colonne);

    }

    public StdPersonnage(int ligne, int colonne, int vie, String nom, int force, int armure, int vitesse,
                         int intell, int chanceCrit, int ptsMouvement, int ptsAction,
                         String s, ArrayList<Equipement> lEquipement, ArrayList<Sort> lSort, Map map, int id)
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
        this.matriceCoup = new int[this.map.getGrille().length][this.map.getGrille().length];
        for(int i = 0; i < matriceCoup.length; i++)
        {

            for(int j = 0; j < matriceCoup.length; j++)
            {
                matriceCoup[i][j] = 100;
            }
        }

        this.matriceCoup = this.map.genererMatriceCoup(this.matriceCoup, 0, this.ligne, this.colonne);
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
            int dist = this.matriceCoup[ligne][colonne];
            int v = this.map.getCase(this.ligne, this.colonne);
            this.map.setCase(this.ligne, this.colonne, this.map.getGrille()[ligne][colonne]);
            this.map.setCase(ligne, colonne, v);
            this.ptsMouvement -= (dist >= 0 ? 1 : -1) * dist;
            this.colonne = colonne;
            this.ligne = ligne;
            for(int i = 0; i < matriceCoup.length; i++)
            {

                for(int j = 0; j < matriceCoup.length; j++)
                {
                    matriceCoup[i][j] = 100;
                }
            }

            this.matriceCoup = this.map.genererMatriceCoup(this.matriceCoup, 0, this.ligne, this.colonne);

            for(int i[] : matriceCoup)
            {
                for(int j : i)
                {
                    System.out.print(String.format("|%3s|", j));
                }
            }
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
        return this.map.getGrillePersonnage()[ligne][colonne] < 1 &&  this.matriceCoup[ligne][colonne] <= this.ptsMouvement;
    }

    @Override
    public void endTurn()
    {
        this.ptsMouvement = 6;
        this.ptsAction = 3;
    }

    public int[][] getMatriceCoup()
    {
        return this.matriceCoup;
    }


    public ArrayList<int[]> getChemin(int ligneArr, int colArr)
    {
        int ligne = ligneArr;
        int colonne = colArr;
        int coup = 100;

        ArrayList<int[]> chemin = new ArrayList<>();

        while(ligne != this.ligne && colonne != this.colonne)
        {
            if ((ligneArr - 1) > 0 && this.map.getGrille()[ligneArr - 1][colArr] < 1
                    && matriceCoup[ligneArr - 1][colArr]< coup)
            {
                ligne = ligne - 1;
                coup = matriceCoup[ligne - 1][colonne];
            }

            if ((ligneArr + 1) > 0 && this.map.getGrille()[ligneArr + 1][colArr] < 1
                    && matriceCoup[ligneArr + 1][colArr]< coup)
            {
                ligne = ligne - 1;
                coup = matriceCoup[ligne + 1][colonne];
            }

            if ((colArr - 1) > 0 && this.map.getGrille()[ligneArr][colArr - 1] < 1
                    && matriceCoup[ligneArr][colArr - 1]< coup)
            {
                colonne = colArr - 1;
                coup = matriceCoup[ligne][colArr];
            }
            if ((colArr + 1) > 0 && this.map.getGrille()[ligneArr][colArr + 1] < 1
                    && matriceCoup[ligneArr][colArr + 1]< coup)
            {
                colonne = colonne + 1;
                coup = matriceCoup[ligne][colonne + 1];
            }

            chemin.add(new int[]{ligne, colonne});
        }
        chemin.add(new int[]{this.ligne, this.colonne});
        return chemin;
    }

    public static void main(String[] argv)
    {

    }
}
