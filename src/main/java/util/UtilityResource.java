package util;

import dao.ArtikelDao;
import domain.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("test")
public class UtilityResource {

    @Inject
    ArtikelDao ArtikelDao;

    @GET
    @Path("filldatabase")
    @Produces(MediaType.APPLICATION_JSON)
    public String testAddContact () {
    /*
        ATTRIBUTEN:
            - ABSTRACTPRODUCT:
        protected String name;
        protected double price;
        protected String omschrijving;
        protected boolean verkocht;
        protected boolean gereserveerd;
        protected LocalDate postDate;
            - ARTIKEL
        public final ProductSoort soort = ProductSoort.ARTIKEL;
        public ArtikelCategorie categorie;
        private List<Bezorgwijzen> bezorgwijzen;
        public List<Betaalwijzen> betaalwijzen;
    */
        List<Bezorgwijzen> bezorgwijzen = new ArrayList<>();
        bezorgwijzen.add(Bezorgwijzen.AFHAAL);
        bezorgwijzen.add(Bezorgwijzen.POST);
        List<Betaalwijzen> betaalwijzen = new ArrayList<>();
        betaalwijzen.add(Betaalwijzen.CONTANT);
        betaalwijzen.add(Betaalwijzen.IDEAL);
        Artikel a2 = Artikel.builder()
                .categorie(ArtikelCategorie.BOEK)
                .betaalwijzen(betaalwijzen)
                .bezorgwijzen(bezorgwijzen)
                .build();
        ArtikelDao.add(a2);
        return("Producten toegevoegd");
    }
}
