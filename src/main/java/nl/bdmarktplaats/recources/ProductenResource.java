package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Product;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/producten")
public class ProductenResource extends AbstractResource<Product> implements JsonResource {

    @Inject public void setDao(Dao<Product> dao) { this.dao = dao; }
}
