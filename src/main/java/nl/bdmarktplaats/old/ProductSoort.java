package nl.bdmarktplaats.old;

public enum ProductSoort {
    ARTIKEL("Artikel"),
    DIENST("Dienst");

    public final String label;

   ProductSoort(String label){
        this.label = label;
    }
}
