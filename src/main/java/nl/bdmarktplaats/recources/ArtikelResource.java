package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.ProductCategorieDao;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.Product;
import nl.bdmarktplaats.domain.Product.ProductCategorie;
import nl.bdmarktplaats.domain.Product.ProductInput;
import nl.bdmarktplaats.filters.Authorized;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.time.LocalDate;

@Authorized
@Path("/artikelen")
public class ArtikelResource extends AbstractResource<Artikel> implements JsonResource {

    @Inject
    private ProductCategorieDao pcd;

    @Inject
    public void setDao(Dao<Artikel> dao) { this.dao = dao; }

    public ArtikelDao getDao(){
        return (ArtikelDao) this.dao;
    }

    @Path("/input")
    @POST
    public Artikel post(ProductInput input) {
        ProductCategorie productCategorie = pcd.getById(input.getCategorie());
        Artikel artikel = Artikel.of(input, productCategorie);

        /*artikel.setPostDate(LocalDate.now());*/
        if (getDao().add(artikel) != null) {
            return artikel;
        } else {
            throw new RuntimeException("Post " + artikel + " failed.");
        }
    }
}
