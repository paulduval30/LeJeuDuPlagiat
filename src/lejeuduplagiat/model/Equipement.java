package lejeuduplagiat.model;

public enum Equipement
{
    CASQUE(0,0,0,0,0,0,0,0);

    private int vie;
    private int force;
    private int armure;
    private int vitesse;
    private int intell;
    private int chanceCrit;
    private int ptsMouvement;
    private int ptsAction;

    Equipement(int vie, int force, int armure, int vitesse, int intell,
               int chanceCrit, int ptsMouvement, int ptsAction){
        this.vie = vie;
        this.force = force;
        this.armure = armure;
        this.vitesse = vitesse;
        this.intell = intell;
        this.chanceCrit = chanceCrit;
        this.ptsMouvement = ptsMouvement;
        this.ptsAction = ptsAction;
    }

    public int getVie()
    {
        return vie;
    }

    public int getForce()
    {
        return force;
    }

    public int getArmure()
    {
        return armure;
    }

    public int getVitesse()
    {
        return vitesse;
    }

    public int getIntell()
    {
        return intell;
    }

    public int getChanceCrit()
    {
        return chanceCrit;
    }

    public int getPtsMouvement()
    {
        return ptsMouvement;
    }

    public int getPtsAction()
    {
        return ptsAction;
    }
}
