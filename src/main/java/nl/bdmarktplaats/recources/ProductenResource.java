package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Persoon.Adres;
import nl.bdmarktplaats.domain.Persoon.Bezorgwijze;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.domain.Product.Product;
import nl.bdmarktplaats.domain.Product.ProductCategorie;
import nl.bdmarktplaats.domain.Product.ProductSoort;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/producten")
public class ProductenResource extends AbstractResource<Product> implements JsonResource {

    @Inject public void setDao(Dao<Product> dao) { this.dao = dao; }

    @GET
    @Path("/addproducttest")
    public String testAddProduct() {

        Product p = new Product();
        p.setCategorie(ProductCategorie.BOEKEN);
        p.setNaam("Harry Potter");
        p.setPrijs(10.00);
        p.setSoort(ProductSoort.ARTIKEL);

        dao.add(p);
        return "gelukt";
    }
}
