package nl.bdmarktplaats.domain.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProductSoort {

    @Id
    @GeneratedValue
    private Long Id;

    private String omschrijving;
}
