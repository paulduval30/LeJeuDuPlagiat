package lejeuduplagiat.model;

public enum Valeur
{
    caseVide(0),
    trou(1),
    mur(2),
    j1(3),
    j4(4);

    private final int value;

    Valeur(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
