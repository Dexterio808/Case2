package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.DienstDao;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.Dienst;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.time.LocalDate;

@Path("/diensten")
public class DienstResource extends AbstractResource<Dienst> implements JsonResource {

    @Inject
    public void setDao(Dao<Dienst> dao) { this.dao = dao; }

    public DienstDao getDao(){
        return (DienstDao) this.dao;
    }

    @Override
    @POST
    public Dienst post(Dienst dienst) {
        dienst.setPostDate(LocalDate.now());
        if (getDao().add(dienst) != null) {
            return dienst;
        } else {
            throw new RuntimeException("Post " + dienst + " failed.");
        }
    }
}

