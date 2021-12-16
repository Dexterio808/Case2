package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.ProductCategorieDao;
import nl.bdmarktplaats.dao.ProductDao;
import nl.bdmarktplaats.domain.Product.Product;
import nl.bdmarktplaats.filters.Authorized;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;

@Authorized
@Path("/producten")
public class ProductenResource extends AbstractResource<Product> implements JsonResource {

    @Inject
    private ProductCategorieDao pcd;

    @Inject
    public void setDao(Dao<Product> dao) {
        this.dao = dao;
    }

    public ProductDao getDao(){
        return (ProductDao) this.dao;
    }

    @GET
    @Path("/gebruiker/{id}")
    public Collection<Product> getProductenFromGebruiker(@PathParam("id")long id) {

           return getDao().findByGebruiker(id);
    }
}
