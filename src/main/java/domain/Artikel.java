package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "artikel")
public class Artikel extends AbstractProduct {

    @Column
    @Basic
    @Enumerated(EnumType.STRING)
    public final ProductSoort soort = ProductSoort.ARTIKEL;

    @Column(name="Categorie", nullable=false)
    @Enumerated(EnumType.STRING)
    public ArtikelCategorie categorie;

    @Column(name="Bezorgwijzen", nullable=false)
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Bezorgwijzen> bezorgwijzen;

    @Column(name="Betaalwijzen", nullable=false)
    @Enumerated(EnumType.STRING)
    @ElementCollection
    public List<Betaalwijzen> betaalwijzen;

    public Artikel(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie) {
        this(name, price);
        this.categorie = categorie;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie, List<Bezorgwijzen> bezorgwijzen) {
        this(name, price, categorie);
        this.bezorgwijzen = bezorgwijzen;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie,
                   List<Bezorgwijzen> bezorgwijzen, List<Betaalwijzen> betaalwijzen){
        this(name, price, categorie, bezorgwijzen);
        this.betaalwijzen = betaalwijzen;
    }

    public boolean getGereserveerd(){
        return gereserveerd;
    }

    public void setGereserveerd(boolean gereserveerd){
        this.gereserveerd = gereserveerd;
    }

    public Long getId(){
        return id;
    }

}




