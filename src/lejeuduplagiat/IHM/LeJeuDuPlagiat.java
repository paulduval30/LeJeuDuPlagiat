package lejeuduplagiat.IHM;

import lejeuduplagiat.model.GameModel;

import javax.swing.*;
import java.awt.*;

public class LeJeuDuPlagiat
{
    private GameModel model;
    private JFrame mainFrame;
    private GraphicsMap graphicsMap;

    public LeJeuDuPlagiat(){
        this.createModel();
        this.createView();
        this.placeComponents();
        this.createController();
    }

    private void createController()
    {
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void placeComponents()
    {
        this.mainFrame.add(graphicsMap, BorderLayout.CENTER);
    }

    private void createView()
    {
        this.graphicsMap = new GraphicsMap(this.model, new Dimension(400,400));
        this.mainFrame = new JFrame();
        this.mainFrame.getContentPane().setBackground(Color.BLUE);

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
