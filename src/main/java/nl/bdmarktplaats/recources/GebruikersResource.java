package nl.bdmarktplaats.recources;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.GebruikerDao;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.domain.Persoon.GebruikerOutput;
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
public class GebruikersResource extends AbstractResource<Gebruiker> implements JsonResource {

    public GebruikerDao getDao() {
        return (GebruikerDao) this.dao;
    }

    @Inject
    public void setDao(Dao<Gebruiker> dao) {
        this.dao = dao;
    }

    @GET
    @Path("/email/{email}")
    public Gebruiker getByEmail(@PathParam("email") String email) {
        return getDao().findByEmail(email);
    }


}
