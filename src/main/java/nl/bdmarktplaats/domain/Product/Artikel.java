package nl.bdmarktplaats.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.Persoon.Bezorgwijze;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Data
@Builder
@XmlRootElement // to be able to send xml response with JAX-B
@NoArgsConstructor // idem
@AllArgsConstructor
@Entity
@DiscriminatorValue("artikel")
@NamedQueries({
        @NamedQuery(
                name = "Artikel.findAll",
                query = "select distinct a from Artikel a" ),
        @NamedQuery(
                name = "Artikel.search",
                query = "select a from Artikel a " +
                        "where a.naam LIKE :q " +
                        "OR a.omschrijving LIKE :q " +
                        "OR a.categorie.omschrijving LIKE :q") ,
})

public class Artikel extends Product {

    public Artikel(Long id, ProductCategorie categorie, String naam, double prijs, String omschrijving, boolean verkocht, boolean gereserveerd, LocalDate postDate, Gebruiker verkoper, Betaalwijze betaalwijzen, Bezorgwijze bezorgwijzen) {
        super(id, categorie, naam, prijs, omschrijving, verkocht, gereserveerd, postDate, verkoper, betaalwijzen);
        this.bezorgwijzen = bezorgwijzen;
    }

    public static Artikel of(ProductInput input, ProductCategorie c) {
        return new Artikel(input.getId(), c, input.getNaam(), input.getPrijs(), input.getOmschrijving(), input.isVerkocht(), input.isGereserveerd(), LocalDate.now(), input.getVerkoper(), input.getBetaalwijzen(), input.getBezorgwijzen());
    }

    @Embedded
    private Bezorgwijze bezorgwijzen;

}
