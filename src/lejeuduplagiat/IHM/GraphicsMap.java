package lejeuduplagiat.IHM;

import lejeuduplagiat.model.GameModel;
import lejeuduplagiat.model.Valeur;

import javax.swing.*;
import java.awt.*;

public class GraphicsMap extends JComponent
{
    private GameModel model;
    private Dimension dim;
    private int mouseLigne;
    private int mouseCol;

    public GraphicsMap(GameModel model, Dimension dim){
        this.model = model;
        this.dim = dim;
        this.setPreferredSize(dim);
        System.out.println(this.getHeight() + "  " + this.getWidth());

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        this.paintMap(g);
    }

    private void paintMap(Graphics g)
    {
        int[][] grille = this.model.getMap().getGrillePersonnage();

        int tailleCase = (int) (grille.length >= grille[0].length ?
                this.getHeight() / grille.length :
                this.getWidth() / grille[0].length);
        int diagonal = (int) (Math.sqrt(tailleCase * tailleCase + tailleCase * tailleCase) * (0.7));

        for (int i = 0; i < grille.length; i++)
        {
            for (int j = 0; j < grille[0].length; j++)
            {
                if (grille[i][j] == Valeur.caseVide.getValue())
                {
                    if(this.model.getCurrent().canWalk(i,j))
                        g.setColor(Color.GREEN);
                    else
                        g.setColor(Color.GRAY);
                }
                else if (grille[i][j] == Valeur.trou.getValue())
                    g.setColor(Color.BLACK);
                else if (grille[i][j] == Valeur.mur.getValue())
                    g.setColor(Color.DARK_GRAY);
                else if(grille[i][j] == Valeur.j1.getValue())
                    g.setColor(Color.RED);
                else if(grille[i][j] == Valeur.j2.getValue())
                    g.setColor(Color.cyan);
                int[] xPoints = new int[]{this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) - diagonal / 2 + 1,
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) + diagonal / 2 - 1};
                int[] yPoints = new int[]{i * (diagonal / 2) + j * (diagonal / 2) + 1,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 2,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal - 1,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 2};
                int[] xPoints2 = new int[]{this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) - diagonal / 2,
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) + diagonal / 2};
                int[] yPoints2 = new int[]{i * (diagonal / 2) + j * (diagonal / 2),
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 2,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 2};
                g.fillPolygon(xPoints2, yPoints2, 4);
                g.setColor(Color.WHITE);
                if (grille[i][j] == Valeur.mur.getValue())
                {
                    int[] xPoints3 = new int[]{this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                            this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) + (int) ((double) diagonal / 2.0) - 1,
                            this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                            this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) - (int) ((double) diagonal / 2.0) + 1};
                    int[] yPoints3 = new int[]{i * (diagonal / 2) + j * (diagonal / 2) + diagonal - diagonal / 4 - 1,
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 4,
                            i * (diagonal / 2) + j * (diagonal / 2) - diagonal / 4 + 1,
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 4};
                    g.setColor(new Color(146, 149, 155));
                    g.fillPolygon(xPoints3, yPoints3, 4);
                    g.setColor(Color.WHITE);
                    g.drawLine(this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal,
                            this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal - diagonal / 4);
                    g.drawLine(this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) + (int) ((double) diagonal / 2.0),
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 4,
                            this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal - diagonal / 4);
                    g.drawLine(this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) - (int) ((double) diagonal / 2.0),
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 4,
                            this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                            i * (diagonal / 2) + j * (diagonal / 2) + diagonal - diagonal / 4);

                } else
                    g.drawPolygon(xPoints2, yPoints2, 4);

            }
        }
        int[] xPoints;
        int[] yPoints;
        int i = mouseLigne;
        int j = mouseCol;
        g.setColor(Color.green);
        if ( mouseLigne >= 0 && mouseLigne < grille.length && mouseCol >= 0 && mouseCol < grille[mouseLigne].length)
        {
            if( grille[mouseLigne][mouseCol] < 1){
                xPoints = new int[]{this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) - diagonal / 2 + 1,
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2),
                        this.getWidth() / 2 + j * (diagonal / 2) - i * (diagonal / 2) + diagonal / 2 - 1};
                yPoints = new int[]{i * (diagonal / 2) + j * (diagonal / 2) + 1,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 2,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal - 1,
                        i * (diagonal / 2) + j * (diagonal / 2) + diagonal / 2};
                g.setColor(new Color(255, 123, 0,50));
                g.fillPolygon(xPoints, yPoints, 4);
            }
            else
              System.out.println(i + " " + j + " " + Valeur.values()[grille[i][j]].toString());
        }
    }

    public void setMousePosition(int ligne, int colonne)
    {
        this.mouseLigne = ligne;
        this.mouseCol = colonne;
    }
}
