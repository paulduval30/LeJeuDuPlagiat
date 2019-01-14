package lejeuduplagiat.model;


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

    public int[][] genererMatrice();


}
