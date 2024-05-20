package org.max.home.accu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.max.home.accu.weather.Maximum;
import org.max.home.accu.weather.Minimum;
import org.max.home.accu.weather.Temperature;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.logging.Logger;
import static org.max.home.accu.GetCountryTest.LogManager;
import static org.mockito.Mockito.when;



public class GetSetTemperatureTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(String.valueOf(GetSetTemperatureTest.class));

    @Mock
    private Maximum mockMaximum;

    @Mock
    private Minimum mockMinimum;

    private Temperature temperature;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        temperature = new Temperature();
    }

    @Test
    public void checkGetMaximum() {
        when(mockMaximum.getValue()).thenReturn(40.0);
        temperature.setMaximum(mockMaximum);
        Maximum actualMaximum = temperature.getMaximum();
        logger.info("Осуществляется проверка максимального значения температуры");
        Assertions.assertEquals(mockMaximum, actualMaximum);
    }

    @Test
    public void checkSetMaximum() {
        when(mockMaximum.getValue()).thenReturn(40.0);
        temperature.setMaximum(mockMaximum);
        logger.info("Осуществляется установка максимального значения температуры!");
        Assertions.assertEquals(mockMaximum, temperature.getMaximum());
    }

    @Test
    public void checkGetMinimum() {
        when(mockMinimum.getValue()).thenReturn(1.0);
        temperature.setMinimum(mockMinimum);
        Minimum actualMinimum = temperature.getMinimum();
        logger.info("Осуществляется проверка минимального значения температуры");
        Assertions.assertEquals(mockMinimum, actualMinimum);
    }

    @Test
    public void checkSetMinimum() {
        when(mockMinimum.getValue()).thenReturn(40.0);
        temperature.setMinimum(mockMinimum);
        logger.info("Осуществляется установка минимального значения температуры!");
        Assertions.assertEquals(mockMinimum, temperature.getMinimum());
    }
}













