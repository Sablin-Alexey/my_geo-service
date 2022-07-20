import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class IpTest {

  private   Map<String, String> sut = new HashMap<String, String>();

    @Test
    void test_ip_USA() {
        sut.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");


        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(geoService.byIp("172.44.183.149"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);


        String result = messageSenderImpl.send(sut);
        String expected = "Welcome";
        Assertions.assertEquals(result, expected);


    }
    @Test
    void test_ip_RU() {
        sut.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.44.183.149");


        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(geoService.byIp("172.44.183.149"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);


        String result = messageSenderImpl.send(sut);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(result, expected);


    }



}
