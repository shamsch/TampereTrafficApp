package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.Meta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.ZonedDateTime;

public class TrafficCameraMetaTest {

    @Test
    public void testMeta() {
        Object requestFilters = new Object();
        ZonedDateTime responseTs = ZonedDateTime.now();

        Meta meta = new Meta();
        meta.setRequestFilters(requestFilters);
        meta.setResponseTs(responseTs);

        assertEquals(requestFilters, meta.getRequestFilters());
        assertEquals(responseTs, meta.getResponseTs());
    }
}
