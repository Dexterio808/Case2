package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.ProductCategorie;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/categorie")
public class ProductCategorieResource extends AbstractResource<ProductCategorie> implements JsonResource {

    @Inject
    public void setDao(Dao<ProductCategorie> dao) { this.dao = dao; }

/*    public ArtikelDao getDao(){
        return (ArtikelDao) this.dao;
    }*/

}
