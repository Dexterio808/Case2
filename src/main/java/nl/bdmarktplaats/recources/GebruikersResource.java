package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.GebruikerDao;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;

import javax.inject.Inject;
import javax.ws.rs.*;


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
