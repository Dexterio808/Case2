package nl.bdmarktplaats.domain.Persoon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.myenums.Bezorgwijze;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

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
})

public class Gebruiker extends Persoon {

    @Embedded
    private Adres adres;
    @Embedded
    private Bezorgwijzentest bezorgwijze;

}

 /*   @ElementCollection
    private Set<Bezorgwijze> Bezorgwijzen;*/
