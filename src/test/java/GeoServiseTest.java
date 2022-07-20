import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


public class GeoServiseTest {

  private   GeoServiceImpl geoService;
  private Location locationExpected;
  private   Location locationRsult;

    @Test
    void geo_test_USA() {
        geoService = new GeoServiceImpl();
        locationExpected = new Location("New York", Country.USA, null, 0);
        locationRsult = geoService.byIp("96.42.183.179");


        final Country result = locationRsult.getCountry();
        final Country expected = locationExpected.getCountry();

        Assertions.assertEquals(expected, result);

    }

    @Test
    void geo_test_Russia() {
        geoService = new GeoServiceImpl();
        locationExpected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        locationRsult = geoService.byIp("172.44.183.149");


        final Country result = locationRsult.getCountry();
        final Country expected = locationExpected.getCountry();

        Assertions.assertEquals(expected, result);

    }
}
