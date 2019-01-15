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

    private int[][] matriceA;
    private HashMap<Integer, ArrayList<Integer>> listSucc;

    public StdMap(int[][] grille){
        this.grille = grille;
        this.grillePersonnage = grille.clone();
        try
        {
            this.matriceA = this.genererMatrice();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        listSucc = new HashMap<>();

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
            try
            {
                this.matriceA = this.genererMatrice();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            listSucc = new HashMap<>();
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
    public int[][] genererMatrice() throws IOException
    {
        int[][] matrice = new int[grille.length * grille.length][grille.length * grille.length];

        for(int i = 0; i < grille.length; i++)
        {
            for(int j = 0; j < grille.length; j++)
            {

                if( i < grille.length - 1)
                {
                    matrice[this.getIncice(i, j)][this.getIncice(i + 1, j)] = grille[i + 1][j] < 1 ? 1 : 0;
                    matrice[this.getIncice(i + 1, j)][this.getIncice(i,j)] = grille[i + 1][j] < 1 ? 1 : 0;
                }
                if( i > 0)
                {
                    matrice[this.getIncice(i, j)][this.getIncice(i - 1, j)] = grille[i - 1][j] < 1 ? 1 : 0;
                    matrice[this.getIncice(i - 1, j)][this.getIncice(i,j)] = grille[i - 1][j] < 1 ? 1 : 0;
                }
                if( j < grille.length - 1)
                {
                    matrice[this.getIncice(i, j)][this.getIncice(i, j + 1)] = grille[i][j + 1] < 1 ? 1 : 0;
                    matrice[this.getIncice(i, j + 1)][this.getIncice(i,j)] = grille[i][j + 1] < 1 ? 1 : 0;
                }
                if( j > 0)
                {
                    matrice[this.getIncice(i, j)][this.getIncice(i , j - 1)] = grille[i][j - 1] < 1 ? 1 : 0;
                    matrice[this.getIncice(i , j - 1)][this.getIncice(i,j)] = grille[i][j - 1] < 1 ? 1 : 0;
                }
            }
        }
        System.out.println(matrice.length + "  " + matrice[0].length);
        FileWriter fw = new FileWriter(new File("test.txt"));
        for(int i = 0; i < matrice.length; i ++)
        {
            for(int j = 0; j < matrice[0].length; j++)
            {
                fw.write("|" + matrice[i][j] + "|");
            }
            fw.write("\n");
        }
        fw.close();
        return matrice;
    }

    private void remplirListSucc()
    {
        for(int i = 0; i < matriceA.length; i++)
        {
            this.listSucc.put(i, new ArrayList<>());
        }

        for(int i = 0; i < matriceA.length; i++)
        {
            for(int j = 0; j < matriceA.length; j++)
            {
                if(matriceA[i][j] == 1)
                    listSucc.get(i).add(j);
            }
        }
    }

    private int getIncice(int i, int j)
    {
        return j + i * this.grille.length;
    }
}
