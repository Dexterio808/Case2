package dao;

import domain.Artikel;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static javax.ejb.TransactionAttributeType.REQUIRED;

@Stateless
public class ArtikelDao {

    @PersistenceContext
    private EntityManager em;

    @TransactionAttribute(REQUIRED)
    public Artikel add(Artikel c) {
        em.persist(c);
        return c;
    }

}