package lejeuduplagiat.model;

import java.util.List;

public interface Personnage
{
    /**
     * Méthode qui donne la position du personnage en x
     * @return posX
     */
    public int getPosX();

    /**
     * Méthode qui donne la position du personnage en y
     * @return posY
     */
    public int getPosY();

    public String getNom();

    public int getVie();

    public int getForce();

    public int getArmure();

    public int getVitesse();

    public int getIntelligence();

    public int getChanceCritique();

    public int getPointMouvement();

    public int getPointAction();

    public boolean deplacer();

    /**
     * retourne le nom associé à l'image qui sera affichée
     * @return nom d'image
     */
    public String getAvatar();

    public List<Equipement> getEquipements();

    public List<Sort> getSorts();
}
