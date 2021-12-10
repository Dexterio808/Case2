package nl.bdmarktplaats.resources;

import nl.bdmarktplaats.App;
import nl.bdmarktplaats.domain.Persoon.Adres;
import nl.bdmarktplaats.domain.Persoon.Bezorgwijze;
import nl.bdmarktplaats.domain.Persoon.Gebruiker;
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
import java.util.List;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class) // 1: dit is een arquillian test
public class GebruikersResourceIT {

    // Ik maak hier een api-test van: aanroepen van (alle?) endpoints, kijken of die het doen, en of ie teruggeven wat je verwacht.

    @ArquillianResource
    private URL deploymentURL;

    private String gebruikersResourcePath;

    @Before
    public void setup() {
        gebruikersResourcePath = deploymentURL + "api/gebruikers";
    }

    // 2: creeer een war zodat arq deze kan deployen
    @Deployment
    public static Archive<?> createDeployment() {
        WebArchive warEmpty = ShrinkWrap.create(WebArchive.class, "MarktplaatsV2.war");
        WebArchive warFilled = warEmpty
                .addPackages(true, App.class.getPackage())
                .addAsWebInfResource("META-INF/beans-test.xml", "META-INF/beans.xml") // to activate CDI
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml") // for JPA
                ;

        return warFilled;
    }

    @Test // 3: maak testjes
    @SuppressWarnings("unchecked")
    public void whenIGetAllGebruikersIGetTheCorrectResult() {
        // We gaan hier voor POSTMAN spelen.
        Client postman = ClientBuilder.newClient();

        Gebruiker g = new Gebruiker();
        g.setNaam("Stan");
        Adres a = new Adres("Teststraat", "11", "1111AA", "Arnhem");
        g.setAdres(a);
        g.setEmail("Stan@mail.com");
        Bezorgwijze b = new Bezorgwijze(true, true, false, false);
        g.setBezorgwijze(b);

        // post some contacts
        String contactJson = postman
                .target(gebruikersResourcePath)
                .request()
                .post(entity(g, APPLICATION_JSON), String.class);

        String contactJson2 = postman
                .target(gebruikersResourcePath)
                .request()
                .post(entity(g, APPLICATION_JSON), String.class);

        // get all contacts
        List<Gebruiker> list = postman
                .target(gebruikersResourcePath)
                .request().get(new GenericType<List<Gebruiker>>() {
                });

        Gebruiker g2 = list.get(0);

        assertEquals(list.size(), 2);
        assertEquals("Stan", g2.getNaam());
        assertEquals("Teststraat", g2.getAdres().getStraat());
        assertEquals("Arnhem", g2.getAdres().getStad());
        assertEquals("11", g2.getAdres().getHuisnummer());
        assertEquals("1111AA", g2.getAdres().getPostcode());
        Assert.assertTrue(g2.getBezorgwijze().isThuis());
        Assert.assertTrue(g2.getBezorgwijze().isMagazijn());
        Assert.assertFalse(g2.getBezorgwijze().isVersturen());
        Assert.assertFalse(g2.getBezorgwijze().isRembours());
    }
}
