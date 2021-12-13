package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.ProductDao;
import nl.bdmarktplaats.domain.Product.Product;
import nl.bdmarktplaats.domain.Product.Artikel;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.time.LocalDate;

@Path("/producten")
public class ProductenResource extends AbstractResource<Product> implements JsonResource {

    @Inject
    public void setDao(Dao<Product> dao) {
        this.dao = dao;
    }

    public ProductDao getDao(){
        return (ProductDao) this.dao;
    }

    @Override
    @POST
    public Product post(Product product) {
        product.setPostDate(LocalDate.now());
        if (getDao().add(product) != null) {
            return product;
        } else {
            throw new RuntimeException("Post " + product + " failed.");
        }
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
