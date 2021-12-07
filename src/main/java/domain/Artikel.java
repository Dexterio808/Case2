package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    private Set<Bezorgwijzen> bezorgwijzen;

    @Column(name="Betaalwijzen", nullable=false)
    @Enumerated(EnumType.STRING)
    @ElementCollection
    public Set<Betaalwijzen> betaalwijzen;

    public Artikel(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie) {
        this(name, price);
        this.categorie = categorie;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie, Set<Bezorgwijzen> bezorgwijzen) {
        this(name, price, categorie);
        this.bezorgwijzen = bezorgwijzen;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie,
                   Set<Bezorgwijzen> bezorgwijzen, Set<Betaalwijzen> betaalwijzen){
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




