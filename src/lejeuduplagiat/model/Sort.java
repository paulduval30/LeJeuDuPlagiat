package lejeuduplagiat.model;

public enum Sort
{
    SORT("Sort");

    private String nom;

    Sort(String nom)
    {
        this.nom = nom;
    }

    public static Sort getSort(String nom)
    {
        for (Sort s : Sort.values())
            if (s.getNom().equals(nom))
                return s;
        return null;
    }

    public String getNom()
    {
        return nom;
    }
}
