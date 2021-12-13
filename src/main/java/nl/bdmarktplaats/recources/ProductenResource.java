package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Product;
import nl.bdmarktplaats.domain.Product.Artikel;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/producten")
public class ProductenResource extends AbstractResource<Product> implements JsonResource {

    @Inject
    public void setDao(Dao<Product> dao) {
        this.dao = dao;
    }

/*

    @Inject
    private ArtikelResource artikelResource;

    @Inject
    private DienstResource dienstResource;
*/


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
