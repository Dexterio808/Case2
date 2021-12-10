package nl.bdmarktplaats.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.AbstractEntity;
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
@NamedQueries({
        @NamedQuery(
                name = "Product.findAll",
                query = "select distinct p from Product p" ),
        @NamedQuery(
                name = "Product.search",
                query = "select p from Product p " +
                        "where p.naam LIKE :q " +
                        "OR p.omschrijving LIKE :q "),
})
public class Product implements AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
/*    @Column(name = "id", updatable = false, nullable = false)*/ //TODO:  niet nodig?
    private Long id;

    @Enumerated(EnumType.STRING)
    public ProductSoort soort;

    @Enumerated(EnumType.STRING)
    public ProductCategorie categorie;

    private String naam;
    private double prijs;
    private String omschrijving;
    private boolean verkocht;
    private boolean gereserveerd;
    private LocalDate postDate;

    @ManyToOne
    private Gebruiker verkoper;

    @Embedded
    private Betaalwijze betaalwijzen;

}
