package nl.bdmarktplaats.old;

import lombok.*;
import nl.bdmarktplaats.domain.AbstractProduct;
import nl.bdmarktplaats.domain.myenums.Bezorgwijze;

import javax.persistence.*;
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
    private final ProductSoort soort = ProductSoort.ARTIKEL;

    @Column(name="Categorie", nullable=false)
    @Enumerated(EnumType.STRING)
    private ArtikelCategorie categorie;

    @Column(name="Bezorgwijzen", nullable=false)
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Bezorgwijze> bezorgwijzen;

    @Column(name="Betaalwijzen", nullable=false)
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Betaalwijzen> betaalwijzen;

    public Artikel(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie) {
        this(name, price);
        this.categorie = categorie;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie, Set<Bezorgwijze> bezorgwijzen) {
        this(name, price, categorie);
        this.bezorgwijzen = bezorgwijzen;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie,
                   Set<Bezorgwijze> bezorgwijzen, Set<Betaalwijzen> betaalwijzen){
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




