package nl.bdmarktplaats.domain.Product;

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


}
