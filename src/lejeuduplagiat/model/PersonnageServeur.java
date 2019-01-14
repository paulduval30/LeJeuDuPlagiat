package lejeuduplagiat.model;

import java.util.List;

public class PersonnageServeur implements Personnage
{
    @Override
    public int getColonne()
    {
        return 0;
    }

    @Override
    public int getLigne()
    {
        return 0;
    }

    @Override
    public String getNom()
    {
        return null;
    }

    @Override
    public int getVie()
    {
        return 0;
    }

    @Override
    public int getForce()
    {
        return 0;
    }

    @Override
    public int getArmure()
    {
        return 0;
    }

    @Override
    public int getVitesse()
    {
        return 0;
    }

    @Override
    public int getIntelligence()
    {
        return 0;
    }

    @Override
    public int getChanceCritique()
    {
        return 0;
    }

    @Override
    public int getPointMouvement()
    {
        return 0;
    }

    @Override
    public int getPointAction()
    {
        return 0;
    }

    @Override
    public int getId()
    {
        return 0;
    }

    @Override
    public void setId(int id)
    {

    }

    @Override
    public boolean deplacer(int ligne, int colonne)
    {
        return false;
    }

    @Override
    public String getAvatar()
    {
        return null;
    }

    @Override
    public List<Equipement> getEquipements()
    {
        return null;
    }

    @Override
    public List<Sort> getSorts()
    {
        return null;
    }

    @Override
    public boolean canWalk(int ligne, int colonne)
    {
        return false;
    }

    @Override
    public void endTurn()
    {

    }
}
