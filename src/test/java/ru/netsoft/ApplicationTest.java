package ru.netsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netsoft.datagateway.DataGateway;
import ru.netsoft.datagateway.MemoryDataGateway;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {
    @Test
    public void test() {
        DataGateway dataGateway = new MemoryDataGateway();
        Application application = new Application(dataGateway);
        Assertions.assertAll(
                () -> assertTrue(application.run(1L) > 0),
                () -> assertTrue(application.run(1L) > 2500000),
                () -> assertTrue(application.run(2L) < 0),
                () -> assertTrue(application.run(2L) < -800000)
        );
    }
}
