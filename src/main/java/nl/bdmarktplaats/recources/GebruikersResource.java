package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;


import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/gebruikers")
public class GebruikersResource extends AbstractResource<Gebruiker> implements JsonResource{


    @Inject public void setDao(Dao<Gebruiker> dao) {
        this.dao = dao;
    }
}
