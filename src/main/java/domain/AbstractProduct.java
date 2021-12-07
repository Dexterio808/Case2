package domain;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    //@Column
    protected String name;
    protected double price;
    protected String omschrijving;
    protected boolean verkocht;
    protected boolean gereserveerd;
    protected LocalDate postDate;
    //protected Gebruiker verkoper

 /*   public abstract String selectProduct();

    public abstract Long getId();*/
}
