/*
package nl.bdmarktplaats.resources;

import nl.bdmarktplaats.App;
import nl.bdmarktplaats.domain.Persoon.Adres;
import nl.bdmarktplaats.domain.Persoon.Bezorgwijze;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;
import nl.bdmarktplaats.domain.Product.Betaalwijze;
import nl.bdmarktplaats.domain.Product.Artikel;
import nl.bdmarktplaats.domain.Product.ProductCategorie;
import nl.bdmarktplaats.old.ProductCategorieOud;
import nl.bdmarktplaats.domain.Product.ProductSoort;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Arquillian.class) // 1: dit is een arquillian test
public class ProductenResourceIT {

    // Ik maak hier een api-test van: aanroepen van (alle?) endpoints, kijken of die het doen, en of ie teruggeven wat je verwacht.

    @ArquillianResource
    private URL deploymentURL;

    private String gebruikersResourcePath;

    @Before
    public void setup() {
        gebruikersResourcePath = deploymentURL + "api/producten";
        Gebruiker g = new Gebruiker();
        g.setNaam("Stan");
        g.setId(123L);
        Adres a = new Adres("Teststraat", "11", "1111AA", "Arnhem");
        g.setAdres(a);
        g.setEmail("Stan@mail.com");
        Bezorgwijze b = new Bezorgwijze(true, true, false, false);
        g.setBezorgwijze(b);

        Client postman = ClientBuilder.newClient();
        postman.target(deploymentURL + "api/gebruikers")
                .request()
                .post(entity(g, APPLICATION_JSON), String.class);
    }

    // 2: creeer een war zodat arq deze kan deployen
    @Deployment
    public static Archive<?> createDeployment() {

        WebArchive warEmpty = ShrinkWrap.create(WebArchive.class, "MarktplaatsV2.war");
        WebArchive warFilled = warEmpty
                .addPackages(true, App.class.getPackage())
                .addAsWebInfResource("META-INF/beans-test.xml", "META-INF/beans.xml") // to activate CDI
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml") // for JPA
*/
/*                .addAsResource(new ClassLoaderAsset("log4j2.xml"), "log4j2.xml")
                .addAsResource("log4j2.xml", "log4j2-test.xml")*//*

                ;


        return warFilled;
    }

    @Test // 3: maak testjes
    @SuppressWarnings("unchecked")
    public void whenIGetAllProductenIGetTheCorrectResult() {

        Client postman = ClientBuilder.newClient();
        Gebruiker gebruiker = postman.target(deploymentURL+"api/gebruikers/123")
                .request()
                .get().readEntity(Gebruiker.class);
        Betaalwijze b = new Betaalwijze(true, true, true);
        LocalDate date = LocalDate.parse("2020-01-08");

        Artikel x = new Artikel(1L, new ProductCategorie(1L,"boeken"),
                "Harry Potter 1", 10.00, "omschrijving",
                false, false, date, gebruiker, b );

        postman.target(gebruikersResourcePath)
                .request()
                .post(entity(x, APPLICATION_JSON), String.class);

        // get all contacts
        List<Artikel> list = postman
                .target(gebruikersResourcePath)
                .request().get(new GenericType<List<Artikel>>() {
                });

        Artikel p1 = list.get(0);
        assertEquals(list.size(), 1);
        assertEquals("Harry Potter 1", p1.getNaam());
        assertEquals(p1.getVerkoper().getNaam(), "Stan");
        Assert.assertTrue(p1.getVerkoper().getBezorgwijze().isMagazijn());
        assertEquals("Teststraat", p1.getVerkoper().getAdres().getStraat());
        assertEquals("Arnhem", p1.getVerkoper().getAdres().getStad());
        assertEquals("11", p1.getVerkoper().getAdres().getHuisnummer());
        assertEquals("1111AA", p1.getVerkoper().getAdres().getPostcode());
    }
}
*/
