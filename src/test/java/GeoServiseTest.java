import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


public class GeoServiseTest {

    GeoServiceImpl sut;
    Location sutE;
    Location sutR;

    @Test
    void geo_test() {
        sut = new GeoServiceImpl();
        sutE = new Location("New York", Country.USA, null, 0);
        sutR = sut.byIp("96.42.183.179");


        final Country result = sutR.getCountry();
        final Country expected = sutE.getCountry();

        Assertions.assertEquals(expected, result);

    }
}
