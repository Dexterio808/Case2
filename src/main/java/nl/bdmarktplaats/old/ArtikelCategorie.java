package nl.bdmarktplaats.old;

public enum ArtikelCategorie {
    BOEK("Boeken"),
    MULTIMEDIA("MultiMedia"),
    TUIN("Tuin"),
    KEUKEN("Keuken"),
    HOBBY("Hobby"),
    OVERIG_ARTIKEl("Overige");

    public final String label;

    ArtikelCategorie(String label){
        this.label = label;
    }
}
