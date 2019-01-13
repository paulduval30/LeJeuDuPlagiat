package lejeuduplagiat.model;

public class StdMap implements Map
{
    private int[][] grille;
    private int[][] grillePersonnage;

    public StdMap(int[][] grille){
        this.grille = grille;
        this.grillePersonnage = grille.clone();
    }

    public StdMap(int nbLigne, int nbCol){
        this.grille = new int[nbLigne][nbCol];

        for(int i = 0; i < nbLigne; i++){
            for(int j = 0; j < nbCol; j++){
                if(i == 0 || j == 0 || i == nbLigne - 1 || j == nbCol - 1)
                    this.grille[i][j] = Valeur.mur.getValue();
                else
                    this.grille[i][j] = Valeur.caseVide.getValue();
            }
        }

        this.grillePersonnage = this.grille.clone();
    }
    @Override
    public int getNbColonne()
    {
        return this.grille.length;
    }

    @Override
    public int getNbLigne()
    {
        return this.grille[0].length;
    }

    @Override
    public int[] getLigne(int ligne)
    {
        return this.grillePersonnage[ligne];
    }

    @Override
    public int[] getColonne(int colonne)
    {
        int[] tabCol = new int[this.getNbLigne()];

        for(int i = 0; i < this.grillePersonnage.length; i++)
            tabCol[i] = this.grillePersonnage[i][colonne];

        return tabCol;
    }

    @Override
    public int getCase(int ligne, int colonne)
    {
        return this.grillePersonnage[ligne][colonne];
    }

    public int getOldCase(int ligne, int colonne){
        return this.grille[ligne][colonne];
    }

    @Override
    public int setCase(int ligne, int colonne, int v)
    {
        return this.grillePersonnage[ligne][colonne] = v;
    }

    @Override
    public int[][] getGrille()
    {
        return this.grille;
    }

    @Override
    public int[][] getGrillePersonnage()
    {
        return this.grillePersonnage;
    }
}
