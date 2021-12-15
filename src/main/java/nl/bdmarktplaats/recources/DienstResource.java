package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.DienstDao;
import nl.bdmarktplaats.dao.ProductCategorieDao;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.Dienst;
import nl.bdmarktplaats.domain.Product.ProductCategorie;
import nl.bdmarktplaats.domain.Product.ProductInput;
import nl.bdmarktplaats.filters.Authorized;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.time.LocalDate;

@Authorized
@Path("/diensten")
public class DienstResource extends AbstractResource<Dienst> implements JsonResource {

    @Inject
    private ProductCategorieDao pcd;

    @Inject
    public void setDao(Dao<Dienst> dao) { this.dao = dao; }

    public DienstDao getDao(){
        return (DienstDao) this.dao;
    }

    @Path("/input")
    @POST
    public Dienst post(ProductInput input) {
        ProductCategorie productCategorie = pcd.getById(input.getCategorie());
        Dienst dienst = Dienst.of(input, productCategorie);

        /*artikel.setPostDate(LocalDate.now());*/
        if (getDao().add(dienst) != null) {
            return dienst;
        } else {
            throw new RuntimeException("Post " + dienst + " failed.");
        }
    }
}

