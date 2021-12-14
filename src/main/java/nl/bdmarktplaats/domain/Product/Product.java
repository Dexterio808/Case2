package nl.bdmarktplaats.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.AbstractEntity;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;

import javax.persistence.*;
import java.time.LocalDate;

@Data @AllArgsConstructor
@NoArgsConstructor
/*@MappedSuperclass*/
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "productsoort", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
        @NamedQuery(
                name = "Product.findAll",
                query = "select distinct p from Product p" ),
        @NamedQuery(
                name = "Product.search",
                query = "select p from Product p " +
                        "where p.naam LIKE :q " +
                        "OR p.omschrijving LIKE :p "),
})
public class Product implements AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ProductCategorie categorie;

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

    /*public static Product of(ProductInput input, ProductCategorie c) {
        return new Product(input.getId(), c, input.getNaam(), input.getPrijs(), input.getOmschrijving(), input.isVerkocht(), input.isGereserveerd(), LocalDate.now(), input.getVerkoper(), input.getBetaalwijzen());
    }*/

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}

