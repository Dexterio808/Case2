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
@Entity
@DiscriminatorValue("dienst")
@NamedQueries({
        @NamedQuery(
                name = "Dienst.findAll",
                query = "select distinct d from Dienst d" ),
        @NamedQuery(
                name = "Dienst.search",
                query = "select d from Dienst d " +
                        "where d.naam LIKE :q " +
                        "OR d.omschrijving LIKE :d "),
})

public class Dienst extends Product {

    public Dienst(Long id, ProductCategorie categorie, String naam, double prijs, String omschrijving, boolean verkocht, boolean gereserveerd, LocalDate postDate, Gebruiker verkoper, Betaalwijze betaalwijzen) {
        super(id, categorie, naam, prijs, omschrijving, verkocht, gereserveerd, postDate, verkoper, betaalwijzen);
    }

    public static Dienst of(ProductInput input, ProductCategorie c) {
        return new Dienst(input.getId(), c, input.getNaam(), input.getPrijs(), input.getOmschrijving(), input.isVerkocht(), input.isGereserveerd(), LocalDate.now(), input.getVerkoper(), input.getBetaalwijzen());
    }

}
