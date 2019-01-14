package lejeuduplagiat.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements Game
{
    private Map map;
    private List<Personnage> personnages;
    private int current;

    public GameModel()
    {
        int[][] mapModel = new int[][]{
                {1,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
        this.map = new StdMap(mapModel);
//       this.map = new StdMap(20,20);
       this.current = 0;
       this.personnages = new ArrayList<>();
    }

    @Override
    public Map getMap()
    {
        return this.map;
    }

    @Override
    public List<Personnage> getPersonnages()
    {
        return this.personnages;
    }

    @Override
    public Personnage getPersonnage(int joueur)
    {
        return this.personnages.get(joueur);
    }

    @Override
    public boolean deplacer(Personnage p, int ligne, int colonne)
    {
        return p != null && p.deplacer(ligne, colonne);
    }

    @Override
    public void ajouterPersonnage(Personnage p)
    {
        if(p == null)
            return;
        this.personnages.add(p);
        this.map.setCase(p.getLigne(), p.getColonne(),p.getId());
    }

    @Override
    public void nextTurn()
    {
        this.current ++;
        if(current >= this.personnages.size())
            current = 0;
    }

    @Override
    public Personnage getJ1()
    {
        return null;
    }

    @Override
    public Personnage getJ2()
    {
        return null;
    }

    @Override
    public Personnage getCurrent()
    {
        return this.personnages.get(current);
    }


}
