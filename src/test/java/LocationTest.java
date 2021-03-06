import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.i18n.LocalizationServiceImpl;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class LocationTest {

  private   LocalizationServiceImpl localizationService;

    @Test
    void locationTestUSA() {

        localizationService = new LocalizationServiceImpl();


        final String result = localizationService.locale(USA);
        final String expected = "Welcome";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void locationTestRussia() {

        localizationService = new LocalizationServiceImpl();


        final String result = localizationService.locale(RUSSIA);
        final String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, result);
    }

}

