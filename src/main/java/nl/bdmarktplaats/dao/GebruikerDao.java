package nl.bdmarktplaats.dao;

import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.sucurity.Password;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.security.NoSuchAlgorithmException;

@Stateless
public class GebruikerDao extends Dao<Gebruiker>{

    public Gebruiker findByEmail(String email){
        TypedQuery<Gebruiker> namedQuery = em.createNamedQuery("Gebruiker.findByEmail", Gebruiker.class);
        namedQuery.setParameter("email", email );
        return namedQuery.getSingleResult();
    }

    public Gebruiker authenticate(String email, String wachtwoord) throws NoSuchAlgorithmException {
            System.out.println(email);
            System.out.println(wachtwoord);
            System.out.println(findByEmail(email));
            System.out.println(findByEmail(email).getSalt());
        TypedQuery<Gebruiker> query = em.createNamedQuery(Gebruiker.FIND_BY_EMAIL_WACHTWOORD, Gebruiker.class);
        query.setParameter("email", email);
            System.out.println(Password.hashPassword((findByEmail(email).getSalt()),wachtwoord));
        query.setParameter("wachtwoord", Password.hashPassword((findByEmail(email).getSalt()),wachtwoord));

        Gebruiker gebruiker = query.getSingleResult();

        if (gebruiker == null) throw new SecurityException("Invalid user/password");

        return gebruiker;
    }

}
