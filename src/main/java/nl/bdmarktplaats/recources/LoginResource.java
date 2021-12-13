package nl.bdmarktplaats.recources;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.GebruikerDao;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.domain.Persoon.GebruikerOutput;
import nl.bdmarktplaats.sucurity.KeyGenerator;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import static java.time.LocalDateTime.now;

@Path("/login")
public class LoginResource implements JsonResource {

    protected Dao<Gebruiker> dao;

    @Inject
    public void setDao(Dao<Gebruiker> dao){
        this.dao = dao;
    }

    public GebruikerDao getDao() {
        return (GebruikerDao) this.dao;
    }

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger log;

    @Inject
    private KeyGenerator keyGenerator;

    @POST
    @Path("")
    public GebruikerOutput login(Gebruiker g) {
        try {
            Gebruiker gebruiker = getDao().authenticate(g.getEmail(), g.getWachtwoord());
            return new GebruikerOutput(getDao().findByEmail(g.getEmail()).getId(), gebruiker.getEmail(), issueToken(g.getEmail()));
        } catch (Exception e) {
            throw new NotAuthorizedException("User " + g + " is not authorized.");
        }
    }


    private String issueToken(String username) {
        Key password = keyGenerator.generateKey();
        String jwt = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, password)
                .compact();
        log.info("#### generated token: " + jwt);
        return jwt;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
