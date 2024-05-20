package org.max.home.accu;

import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.max.seminar.accu.AbstractTest;
import org.max.seminar.accu.location.Country;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class GetCountryTest extends AbstractTest {

    public static Logger LogManager;
    private static final Logger logger = Logger.getLogger(String.valueOf(GetCountryTest.class));

    @Mock
    private Country mockCountry;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkGetCountry() throws Exception {
        Mockito.when(mockCountry.getId()).thenReturn("");
        Mockito.when(mockCountry.getLocalizedName()).thenReturn("");
        //нельза передавать пустое значение в Double.valueOf
        Mockito.when(mockCountry.getEnglishName()).thenReturn(Double.valueOf(""));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(mockCountry);
        Country deserializedCountry = objectMapper.readValue(json, Country.class);
        Assertions.assertEquals(mockCountry.getId(), deserializedCountry.getId());
        Assertions.assertEquals(mockCountry.getEnglishName(), deserializedCountry.getEnglishName());
        Assertions.assertEquals(mockCountry.getLocalizedName(), deserializedCountry.getLocalizedName());
        logger.info("Успешное прохождение теста!");
    }
}











