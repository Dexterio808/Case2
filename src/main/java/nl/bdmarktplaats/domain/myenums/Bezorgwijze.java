package nl.bdmarktplaats.domain.myenums;

public enum Bezorgwijze {
    AFHAAL("Afhalen magazijn"),
    THUIS("Thuis afhalen"),
    POST("Laten versturen"),
    REMBOURS("Rembours versturen");

    public final String label;

    Bezorgwijze(String label){
        this.label = label;
    }
}
