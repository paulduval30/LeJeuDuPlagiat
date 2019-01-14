package lejeuduplagiat.model;

import java.util.List;

public interface Game
{
    public Map getMap();

    public List<Personnage> getPersonnages();

    public Personnage getPersonnage(int joueur);

    public boolean deplacer(Personnage p, int ligne, int colonne);

    public void ajouterPersonnage(Personnage p);

    public void nextTurn();

    public Personnage getJ1();

    public Personnage getJ2();

    public Personnage getCurrent();
}
