package org.max.home.accu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.home.accu.weather.Night;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.logging.Logger;

import static org.max.home.accu.GetCountryTest.LogManager;


public class GetSetNightTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(String.valueOf(GetSetNightTest.class));
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private Night mockNight;

    public GetSetNightTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void checkGet_SetNight() throws Exception {
        Mockito.when(mockNight.getIcon()).thenReturn(1);
        Mockito.when(mockNight.getIconPhrase()).thenReturn("");
        Mockito.when(mockNight.getHasPrecipitation()).thenReturn(true);
        logger.info("Запуск теста GetSetNightTest");
        String json = objectMapper.writeValueAsString(mockNight);
        Night deserializedNight = objectMapper.readValue(json, Night.class);
        Assertions.assertAll(
                () -> Assertions.assertEquals(mockNight.getIcon(), deserializedNight.getIcon()),
                () -> Assertions.assertEquals(mockNight.getIconPhrase(), deserializedNight.getIconPhrase()),
                () -> Assertions.assertEquals(mockNight.getHasPrecipitation(), deserializedNight.getHasPrecipitation())
        );
        logger.info("Тест завершился!");
    }
}




