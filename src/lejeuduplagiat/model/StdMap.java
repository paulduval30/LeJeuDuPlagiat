package lejeuduplagiat.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StdMap implements Map
{
    private int[][] grille;

    private int[][] grillePersonnage;


    public StdMap(int[][] grille){
        this.grille = grille;
        this.grillePersonnage = new int[grille.length][grille.length];
        for(int i = 0; i < grille.length; i++)
            for (int j = 0; j < grille.length; j++)
                this.grillePersonnage[i][j] = grille[i][j];
    }

    public StdMap(int nbLigne, int nbCol){

        this.grille = new int[nbLigne][nbCol];
        for(int i = 0; i < nbLigne; i++)
        {
            for(int j = 0; j < nbCol; j++)
            {
                if(i == 0 || j == 0 || i == nbLigne - 1 || j == nbCol - 1)
                    this.grille[i][j] = Valeur.mur.getValue();
                else
                    this.grille[i][j] = Valeur.caseVide.getValue();
            }
        }

        this.grillePersonnage = new int[grille.length][grille.length];
        for(int i = 0; i < grille.length; i++)
            for (int j = 0; j < grille.length; j++)
                this.grillePersonnage[i][j] = grille[i][j];
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

    public int getOldCase(int ligne, int colonne)
    {
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

    @Override
    public int getIncice(int i, int j)
    {
        return j + i * this.grille.length;
    }

    @Override
    public ArrayList<int[]> getChemin(int ligneDep, int colDep, int ligneArr, int colArr, int pm)
    {
        ArrayList<int[]> chemin = new ArrayList<>();

        return chemin;
    }

    @Override
    public int[][] genererMatriceCoup(int[][] matriceCoup, int id, int ligneArr, int colArr)
    {

        matriceCoup[ligneArr][colArr] = id;
        id++;
        if ((ligneArr - 1) >= 0 && this.grille[ligneArr - 1][colArr] < 1
                && matriceCoup[ligneArr - 1][colArr] > id)
        {
            this.genererMatriceCoup(matriceCoup, id, ligneArr - 1, colArr);
        }

        if (ligneArr + 1 < this.grille.length && this.grille[ligneArr + 1][colArr] < 1
                && matriceCoup[ligneArr + 1][colArr] > id)
        {
            this.genererMatriceCoup(matriceCoup, id, ligneArr + 1, colArr);
        }

        if (colArr - 1 >= 0 && this.grille[ligneArr][colArr - 1] < 1
                && matriceCoup[ligneArr][colArr - 1] > id)
        {
            this.genererMatriceCoup(matriceCoup, id, ligneArr, colArr - 1);
        }

        if (colArr + 1 < this.grille.length && this.grille[ligneArr][colArr + 1] < 1
                && matriceCoup[ligneArr][colArr + 1] > id)
        {
            this.genererMatriceCoup(matriceCoup, id, ligneArr, colArr + 1);
        }

        return matriceCoup;
    }

    @Override
    public int getDistance(int iDep, int jDep, int iArr, int jArr)
    {
        return Math.abs(iDep - iArr)+ Math.abs(jDep - jArr);
    }
}
