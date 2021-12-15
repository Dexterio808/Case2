package nl.bdmarktplaats.dao;

import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.domain.Product.Product;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Stateless
public class ProductDao extends Dao<Product> {

    public Collection<Product> findByGebruiker(long id){
        TypedQuery<Product> namedQuery = em.createNamedQuery("Product.findByGebruiker", Product.class);
        namedQuery.setParameter("id", id );
        return namedQuery.getResultList();
    }
}

