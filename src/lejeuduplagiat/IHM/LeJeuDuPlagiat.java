package lejeuduplagiat.IHM;

import lejeuduplagiat.model.GameModel;
import lejeuduplagiat.model.StdPersonnage;
import lejeuduplagiat.model.Valeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeJeuDuPlagiat
{
    private GameModel model;
    private JFrame mainFrame;
    private GraphicsMap graphicsMap;
    private JButton nextTurn;

    public LeJeuDuPlagiat(){
        this.createModel();
        this.createView();
        this.placeComponents();
        this.createController();
    }

    private void createController()
    {
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MouseListener mL = new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                double x = e.getX();
                double y = e.getY();
                double tailleCase = (model.getMap().getGrille().length >= model.getMap().getGrille()[0].length ?
                        graphicsMap.getHeight() / model.getMap().getGrille().length :
                        graphicsMap.getWidth() / model.getMap().getGrille()[0].length);
                double diagonal = ( Math.sqrt(tailleCase * tailleCase + tailleCase * tailleCase) * (0.7));
                double d = diagonal / 2;


                double i = (((graphicsMap.getWidth() / 2 + y - x)/ 2)/d);
                double j = (y / d) - i;
                System.out.println(i + "           " + j);
                int ligne = (int)i;
                int colonne = (int)j;

                System.out.println(ligne + "          " + colonne);
                model.deplacer(model.getCurrent(), ligne, colonne);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        };

        MouseMotionListener mLL = new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {

            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                double x = e.getX();
                double y = e.getY();
                double tailleCase = (model.getMap().getGrille().length >= model.getMap().getGrille()[0].length ?
                        graphicsMap.getHeight() / model.getMap().getGrille().length :
                        graphicsMap.getWidth() / model.getMap().getGrille()[0].length);
                double diagonal = ( Math.sqrt(tailleCase * tailleCase + tailleCase * tailleCase) * (0.7));
                double d = diagonal / 2;


                double i = (((graphicsMap.getWidth() / 2 + y - x)/ 2)/d);
                double j = (y / d) - i;
                int ligne = (int)i;
                int colonne = (int)j;

                graphicsMap.setMousePosition(ligne, colonne);
                System.out.println(ligne + " " + colonne);
                refresh();
            }
        };

        graphicsMap.addMouseMotionListener(mLL);
        graphicsMap.addMouseListener(mL);

        ActionListener aL = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.nextTurn();
            }
        };

        this.nextTurn.addActionListener(aL);
    }

    private void placeComponents()
    {
        this.mainFrame.add(graphicsMap, BorderLayout.CENTER);
        this.mainFrame.add(nextTurn, BorderLayout.WEST);
    }

    private void createView()
    {
        this.graphicsMap = new GraphicsMap(this.model, new Dimension(400,400));
        this.mainFrame = new JFrame();
        this.mainFrame.getContentPane().setBackground(Color.BLUE);

        this.nextTurn = new JButton("Next Turn");

    }

    private void display() {
        refresh();
        mainFrame.setLocation(20,20);
        this.mainFrame.setSize(800, 800);
        mainFrame.setVisible(true);
    }

    private void refresh()
    {
        this.mainFrame.repaint();
    }

    private void createModel()
    {
        this.model = new GameModel();
        StdPersonnage j1 = new StdPersonnage(this.model.getMap(), Valeur.j1.getValue());
        model.ajouterPersonnage(j1);
        StdPersonnage j2 = new StdPersonnage(this.model.getMap(), Valeur.j2.getValue());
        model.ajouterPersonnage(j2);
    }

    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LeJeuDuPlagiat().display();
            }
        });
    }
}
