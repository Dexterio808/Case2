package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Artikel;

import javax.inject.Inject;

public class ArtikelResource extends AbstractResource<Artikel> implements JsonResource {

    @Inject
    public void setDao(Dao<Artikel> dao) { this.dao = dao; }
}
