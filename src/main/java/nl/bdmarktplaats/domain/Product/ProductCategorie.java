package nl.bdmarktplaats.domain.Product;

public enum ProductCategorie {
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

    private ProductCategorie(String label) {
        this.label = label;
    }
}