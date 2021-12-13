package nl.bdmarktplaats.domain.Persoon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import nl.bdmarktplaats.domain.AbstractEntity;
import nl.bdmarktplaats.sucurity.Password;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.security.NoSuchAlgorithmException;


@Data
@AllArgsConstructor
public class GebruikerOutput  {
    private String email;
    private String token;

}
