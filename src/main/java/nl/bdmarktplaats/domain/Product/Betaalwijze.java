package nl.bdmarktplaats.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Betaalwijze {
    private boolean ideal;
    private boolean creditcard;
    private boolean contant;
}