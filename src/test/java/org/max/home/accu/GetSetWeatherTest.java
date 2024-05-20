package org.max.home.accu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.max.home.accu.weather.DailyForecast;
import org.max.home.accu.weather.Headline;
import org.max.home.accu.weather.Weather;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.List;
import static org.mockito.Mockito.when;


public class GetSetWeatherTest extends AbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(String.valueOf(GetSetWeatherTest.class).getClass());

    @Mock
    private Headline mockHeadline;

    @Mock
    private DailyForecast mockDailyForecast;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getSetWeatherTest() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(mockHeadline.toString()).thenReturn("Mock Headline");
        when(mockDailyForecast.toString()).thenReturn("Mock Daily Forecast");
        Weather weather = new Weather() {
            @Override
            public String get() {
                return "";
            }
        };
        weather.setHeadline(mockHeadline);
        weather.setDailyForecasts(List.of(mockDailyForecast));
        String json = objectMapper.writeValueAsString(weather);
        Weather deserializedWeather = objectMapper.readValue(json, Weather.class);
        logger.info("Преобразование класса - Погода");
        Assertions.assertNotNull(deserializedWeather.getHeadline());
        Assertions.assertNotNull(deserializedWeather.getDailyForecasts().get(0));
        Assertions.assertEquals(1, deserializedWeather.getDailyForecasts().size());
    }
}