package nl.bdmarktplaats.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.AbstractEntity;

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
                name = "ProductCategorie.findAll",
                query = "select distinct p from ProductCategorie p" ),
        @NamedQuery(
                name = "ProductCategorie.search",
                query = "select p from ProductCategorie p " +
                        "where p.omschrijving LIKE :p "),
})
public class ProductCategorie implements AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long Id;

    private String omschrijving;

}