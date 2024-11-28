package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentLineTest {

    @Test
    void testLineGettersSettersToString() {
        // Create an instance of Line
        Line line = new Line();

        // Set values
        line.setSrsName("EPSG:4326");
        line.setSrsDimension(2);
        line.setPosList("61.4991 23.7871 61.5000 23.8000");

        // Verify getters
        assertEquals("EPSG:4326", line.getSrsName());
        assertEquals(2, line.getSrsDimension());
        assertEquals("61.4991 23.7871 61.5000 23.8000", line.getPosList());

        // Verify toString output
        String toStringOutput = line.toString();
        assertTrue(toStringOutput.contains("srsName=EPSG:4326"));
        assertTrue(toStringOutput.contains("srsDimension=2"));
        assertTrue(toStringOutput.contains("posList=61.4991 23.7871 61.5000 23.8000"));
    }
}
