package lejeuduplagiat.model;

import java.util.ArrayList;
import java.util.List;

public interface Personnage
{
    /**
     * Méthode qui donne la position du personnage en x
     * @return posX
     */
    public int getColonne();

    /**
     * Méthode qui donne la position du personnage en y
     * @return posY
     */
    public int getLigne();

    public String getNom();

    public int getVie();

    public int getForce();

    public int getArmure();

    public int getVitesse();

    public int getIntelligence();

    public int getChanceCritique();

    public int getPointMouvement();

    public int getPointAction();

    public int getId();

    public void setId(int id);

    public boolean deplacer(int ligne, int colonne);

    /**
     * retourne le nom associé à l'image qui sera affichée
     * @return nom d'image
     */
    public String getAvatar();

    public List<Equipement> getEquipements();

    public List<Sort> getSorts();

    boolean canWalk(int ligne, int colonne);

    public void endTurn();

    public ArrayList<int[]> getChemin(int ligneArr, int colArr);
}
