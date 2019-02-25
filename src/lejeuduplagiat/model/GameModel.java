package lejeuduplagiat.model;

import lejeuduplagiat.network.client.Client;
import lejeuduplagiat.network.client.Paquet;
import lejeuduplagiat.network.serveur.Serveur;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements Game
{
    private Serveur serveur;
    private Map map;
    private Personnage localPlayer;
    private List<Personnage> personnages;
    private int current;

    private Client client;

    public GameModel()
    {
        int[][] mapModel = new int[][]{
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,2,0,1,0,1,0,2,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
        this.map = new StdMap(mapModel);
       //this.map = new StdMap(20,20);
       this.current = 0;
       this.personnages = new ArrayList<>();
       this.localPlayer = null;


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
        return this.personnages.size() > 0 ? this.personnages.get(joueur) : null;
    }

    @Override
    public boolean deplacer(Personnage p, int ligne, int colonne)
    {
        boolean canMove = false;
        if(p != null)
             canMove = p.deplacer(ligne, colonne);
        if(canMove && p.getId() == localPlayer.getId())
            Paquet.envoyerDeplacement(ligne, colonne, p, client);
        return canMove;
    }

    @Override
    public void ajouterPersonnage(Personnage p)
    {
        if(p == null)
            return;
        if(localPlayer == null)
        {
            this.localPlayer = p;
            this.personnages.add(p);
            this.map.setCase(p.getLigne(), p.getColonne(),p.getId());

        }
        else if(this.localPlayer.getId() != p.getId())
        {
            this.personnages.add(p);
            this.map.setCase(p.getLigne(), p.getColonne(),p.getId());
        }
    }

    public void creerClient()
    {
        if(this.client == null){
            this.client = new Client(this);
            this.client.connect("127.0.0.1",25566);
        }
    }

    @Override
    public void nextTurn()
    {
        this.personnages.get(current).endTurn();
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
        return this.personnages.size() > 0 ? this.personnages.get(this.current) : null;
    }

    public Personnage getLocalPlayer(){
        return this.localPlayer;
    }


    public Client getClient()
    {
        return client;
    }

    public void setCurrent(int current)
    {
        this.current = current;
    }
}
