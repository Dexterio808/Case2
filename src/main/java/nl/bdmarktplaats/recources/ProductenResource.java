package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.old.ProductCategorieOud;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/producten")
public class ProductenResource extends AbstractResource<Artikel> implements JsonResource {

    @Inject public void setDao(Dao<Artikel> dao) { this.dao = dao; }

    @GET
    @Path("/addproducttest")
    public String testAddProduct() {

        Artikel p = new Artikel();
        p.setNaam("Harry Potter");
        p.setPrijs(10.00);

        dao.add(p);
        return "gelukt";
    }
}
