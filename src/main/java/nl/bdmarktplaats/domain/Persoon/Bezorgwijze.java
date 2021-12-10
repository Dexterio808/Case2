package nl.bdmarktplaats.domain.Persoon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bezorgwijze {
    private boolean thuis;
    private boolean magazijn;
    private boolean versturen;
    private boolean rembours;
}

