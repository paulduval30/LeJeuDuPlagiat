package lejeuduplagiat.IHM;

import lejeuduplagiat.model.GameModel;
import lejeuduplagiat.model.StdPersonnage;
import lejeuduplagiat.model.Valeur;
import lejeuduplagiat.network.client.Paquet;

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
                int ligne = (int)i;
                int colonne = (int)j;

                model.deplacer(model.getCurrent(), ligne, colonne);


                refresh();
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
                refresh();
            }
        };

        this.nextTurn.addActionListener(aL);
    }

    private void placeComponents()
    {
        this.mainFrame.add(graphicsMap, BorderLayout.CENTER);
        JPanel p = new JPanel();{
            p.add(nextTurn);
    }
    this.mainFrame.add(p, BorderLayout.SOUTH);
    }

    private void createView()
    {
        this.graphicsMap = new GraphicsMap(this.model, new Dimension(400,400));
        this.mainFrame = new JFrame();
        this.mainFrame.getContentPane().setBackground(Color.BLUE);

        this.nextTurn = new JButton("Next Turn");

    }

    private void display() {
        mainFrame.setLocation(10,10);
        this.mainFrame.setSize(800, 800);
        mainFrame.setVisible(true);
        mainFrame.setFocusable(false);
        refresh();
    }

    private void refresh()
    {
        this.mainFrame.repaint();
    }

    private void createModel()
    {
        this.model = new GameModel();
        model.creerClient();
        Paquet.envoyerJoueurAServeur(new StdPersonnage("Johnny", this.model.getMap()),this.model.getClient());

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
