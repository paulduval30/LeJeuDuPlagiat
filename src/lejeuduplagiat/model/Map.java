package lejeuduplagiat.model;


import java.io.IOException;
import java.util.ArrayList;

public interface Map
{
    /**
     * Nombre de colonnes
     * @return colonne
     */
    public int getNbColonne();

    /**
     * Nombre de ligne
     * @return ligne
     */
    public int getNbLigne();

    /**
     * Un tableau contenant la ligne demandée
     * @param ligne la ligne souhaitée
     * @return tabLigne
     */
    public int[] getLigne(int ligne);

    /**
     * Un tableau contenant la colonne demandée
     * @param colonne la ligne souhaitée
     * @return tabColonne
     */
    public int[] getColonne(int colonne);

    public int getCase(int ligne, int colonne);

    public int getOldCase(int ligne, int colonne);

    public int setCase(int ligne, int colonne, int v);

    public int[][] getGrille();

    public int[][] getGrillePersonnage();

    int getIncice(int i, int j);

    ArrayList<int[]> getChemin(int ligneDep, int colDep, int ligneArr, int colArr, int pm);

    int[][] genererMatriceCoup(int[][] matriceCoup, int id, int ligneArr, int colArr);

    int getDistance(int iDep, int jDep, int iArr, int jArr);


}
