package nl.bdmarktplaats.domain.Persoon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.bdmarktplaats.domain.AbstractEntity;
import nl.bdmarktplaats.sucurity.Password;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Data
@MappedSuperclass
public abstract class Persoon implements AbstractEntity<Long> {
    @Id
    @GeneratedValue
    private Long Id;
    private String naam;
    private String email;

    private String wachtwoord;
    private String salt;

    @PrePersist
    public void hashPassword() {
        try {
            this.salt = Password.createSalt();
            this.wachtwoord = Password.genAndHash(this.salt);
        }
        catch (NoSuchAlgorithmException e){
            log.info("Password gen Error");
        }
    }
}
