package nl.bdmarktplaats.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.Persoon.Bezorgwijze;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement // to be able to send xml response with JAX-B
@NoArgsConstructor // idem
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Artikel.findAll",
                query = "select distinct a from Artikel a" ),
        @NamedQuery(
                name = "Artikel.search",
                query = "select a from Artikel a " +
                        "where a.naam LIKE :q " +
                        "OR a.omschrijving LIKE :a "),
})

public class Artikel extends AbstractProduct {

    @Embedded
    private Bezorgwijze bezorgwijzen;

}
