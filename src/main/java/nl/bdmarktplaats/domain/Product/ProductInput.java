package nl.bdmarktplaats.domain.Product;

import lombok.Data;
import nl.bdmarktplaats.domain.AbstractEntity;
import nl.bdmarktplaats.domain.Persoon.Bezorgwijze;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class ProductInput {


    private Long id;

    private Long categorie;

    private String naam;
    private double prijs;
    private String omschrijving;
    private boolean verkocht;
    private boolean gereserveerd;
    private LocalDate postDate;

    private Gebruiker verkoper;

    private Betaalwijze betaalwijzen;
    private Bezorgwijze bezorgwijzen;


}

