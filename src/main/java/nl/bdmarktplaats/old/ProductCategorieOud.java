package nl.bdmarktplaats.old;

public enum ProductCategorieOud {
    BOEKEN("Artikel"),
    MULTIMEDIA("Artikel"),
    TUIN("Artikel"),
    KEUKEN("Artikel"),
    OVERIG("Artikel"),
    CURSUS("Dienst"),
    HUISHOUDEN("Dienst"),
    VERVOER("Dienst"),
    ANDERE("Dienst");

    public final String label;

    private ProductCategorieOud(String label) {
        this.label = label;
    }
}