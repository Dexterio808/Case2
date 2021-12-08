package nl.bdmarktplaats.domain.Persoon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.bdmarktplaats.domain.AbstractEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Persoon implements AbstractEntity<Long> {
    @Id
    @GeneratedValue
    private Long Id;
    private String naam;
    private String email;

    /*
    private String wachtwoord;
    private String Salt;
    */
}
