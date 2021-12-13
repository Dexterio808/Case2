package nl.bdmarktplaats.recources;

import nl.bdmarktplaats.dao.Dao;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.Dienst;

import javax.inject.Inject;

public class DienstResource extends AbstractResource<Dienst> implements JsonResource {

    @Inject
    public void setDao(Dao<Dienst> dao) { this.dao = dao; }
}

