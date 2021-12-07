package domain;

public enum Bezorgwijzen {
    AFHAAL("Afhalen magazijn"),
    THUIS("Thuis afhalen"),
    POST("Laten versturen"),
    REMBOURS("Rembours versturen");

    public final String label;

    Bezorgwijzen(String label){
        this.label = label;
    }
}
