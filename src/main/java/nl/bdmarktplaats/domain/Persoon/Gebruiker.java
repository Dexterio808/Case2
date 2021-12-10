package nl.bdmarktplaats.domain.Persoon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        name = "Gebruiker.findAll",
        query = "select distinct g from Gebruiker g" ),
        @NamedQuery(
                name = "Gebruiker.search",
                query = "select g from Gebruiker g " +
                        "where g.naam LIKE :q " +
                        "OR g.email LIKE :q "),
        @NamedQuery(
                name= "Gebruiker.findByEmail",
                query = "select g from Gebruiker g " +
                        "where g.email = :email"),
        @NamedQuery(
                name = "Gebruiker.findByEmailAndWachtwoord",
                query = "SELECT g FROM Gebruiker g" +
                        " WHERE g.email = :email" +
                        " AND g.wachtwoord = :wachtwoord"
        ),
})

public class Gebruiker extends Persoon {

    public static final String FIND_BY_EMAIL_WACHTWOORD = "Gebruiker.findByEmailAndWachtwoord";


    @Embedded
    private Adres adres;
    @Embedded
    private Bezorgwijze bezorgwijze;

}

