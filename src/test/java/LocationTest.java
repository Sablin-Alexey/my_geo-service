import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.i18n.LocalizationServiceImpl;

import static ru.netology.entity.Country.USA;

public class LocationTest {

    LocalizationServiceImpl sut;

    @Test
    void location_test_USA() {

        sut = new LocalizationServiceImpl();


        final String result = sut.locale(USA);
        final String expected = "Welcome";

        Assertions.assertEquals(expected, result);
    }

}

