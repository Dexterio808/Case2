package nl.bdmarktplaats.old;

public enum ArtikelCategorieOud {
    BOEK("Boeken"),
    MULTIMEDIA("MultiMedia"),
    TUIN("Tuin"),
    KEUKEN("Keuken"),
    HOBBY("Hobby"),
    OVERIG_ARTIKEl("Overige");

    public final String label;

    ArtikelCategorieOud(String label){
        this.label = label;
    }
}
