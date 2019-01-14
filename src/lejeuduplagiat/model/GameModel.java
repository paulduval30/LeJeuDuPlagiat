package lejeuduplagiat.model;

import java.util.List;

public class GameModel implements Game
{
    private Map map;
    private List<Personnage> personnages;
    private int current;

    public GameModel()
    {
        int[][] mapModel = new int[][]{
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
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
        this.current = 0;
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
    }

    @Override
    public void nextTurn()
    {
        this.current ++;
        if(current >= this.personnages.size())
            current = 0;
    }


}
