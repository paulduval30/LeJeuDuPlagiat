package lejeuduplagiat.model;

public enum Valeur
{
    caseVide(0, "vide"),
    trou(1, "trou"),
    mur(2, "mur"),
    j1(3, "j1"),
    j2(4, "j2"),
    j3(5, "j3"),
    j4(6, "j4");

    private final int value;
    private final String name;

    Valeur(int value, String name){
        this.value = value;
        this.name = name;
    }

    public int getValue(){
        return this.value;
    }


    @Override
    public String toString()
    {
        return this.name;
    }
}
