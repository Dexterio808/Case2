package nl.bdmarktplaats.recources;

import lombok.extern.slf4j.Slf4j;
import nl.bdmarktplaats.dao.ArtikelDao;
import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.dao.ProductCategorieDao;
import nl.bdmarktplaats.dao.ProductDao;
import nl.bdmarktplaats.domain.Product.Product;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.ProductCategorie;
import nl.bdmarktplaats.domain.Product.ProductInput;
import nl.bdmarktplaats.filters.Authorized;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.time.LocalDate;
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
