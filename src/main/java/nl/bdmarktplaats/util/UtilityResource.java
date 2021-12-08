package nl.bdmarktplaats.util;


import nl.bdmarktplaats.domain.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

//@Path("test")
public class UtilityResource {
/*
    @Inject
    ArtikelDao ArtikelDao;

    @GET
    @Path("filldatabase")
    @Produces(MediaType.APPLICATION_JSON)
    public String testAddContact () {
    *//*
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
    *//*
        //Set<Bezorgwijzen> bezorgwijzen = new HashSet<Bezorgwijzen>(Collections.list());
       // Set<Bezorgwijzen> set = new HashSet<Bezorgwijzen>(Collections.list(Bezorgwijzen.AFHAAL));
        //Set<Bezorgwijzen> set = new HashSet<Bezorgwijzen>(Collections.list(Bezorgwijzen.AFHAAL, Bezorgwijzen.POST));
        //EnumSet<Bezorgwijzen> e = new EnumSet<Bezorgwijzen>();
        Set<Bezorgwijzen> bezorgwijzen = EnumSet.of(Bezorgwijzen.AFHAAL, Bezorgwijzen.POST);
        Set<Betaalwijzen> betaalwijzen = EnumSet.of(Betaalwijzen.IDEAL, Betaalwijzen.CONTANT);
        Artikel a2 = Artikel.builder()
                .categorie(ArtikelCategorie.BOEK)
                .betaalwijzen(betaalwijzen)
                .bezorgwijzen(bezorgwijzen)
                .build();
        ArtikelDao.add(a2);
        return("Producten toegevoegd");
    }*/
}
