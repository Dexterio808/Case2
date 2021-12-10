package nl.bdmarktplaats.recources;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.GebruikerDao;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.sucurity.KeyGenerator;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import static java.time.LocalDateTime.now;

@Path("/gebruikers")
public class GebruikersRecource extends AbstractResource<Gebruiker> implements JsonResource{

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger log;

    @Inject
    private KeyGenerator keyGenerator;

    @Inject public void setDao(Dao<Gebruiker> dao) {
        this.dao = dao;
    }

    public GebruikerDao getDao() { return (GebruikerDao) this.dao; }

    @GET
    @Path("/email/{email}")
    public Gebruiker getByEmail(@PathParam("email") String email){
        return getDao().findByEmail(email);
    }

    @POST
    @Path("/login")
    public Gebruiker login(Gebruiker g) {
        try {
            String username = g.getEmail();
            String password = g.getWachtwoord();

            Gebruiker gebruiker = getDao().authenticate(username, password);
            String jwt = issueToken(username);
            gebruiker.setToken(jwt);
            g.setWachtwoord("");

            return gebruiker;
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
