package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Artikel;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.time.LocalDate;

@Path("/artikelen")
public class ArtikelResource extends AbstractResource<Artikel> implements JsonResource {

    @Inject
    public void setDao(Dao<Artikel> dao) { this.dao = dao; }

    public ArtikelDao getDao(){
        return (ArtikelDao) this.dao;
    }

    @Override
    @POST
    public Artikel post(Artikel artikel) {
        artikel.setPostDate(LocalDate.now());
        if (getDao().add(artikel) != null) {
            return artikel;
        } else {
            throw new RuntimeException("Post " + artikel + " failed.");
        }
    }
}
