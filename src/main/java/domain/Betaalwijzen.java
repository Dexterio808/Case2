package domain;

public enum Betaalwijzen {
    IDEAL("IDEAL"),
    CREDIT("Creditcard"),
    CONTANT("Contant");

    public final String label;

    Betaalwijzen(String label){
        this.label = label;
    }
}
