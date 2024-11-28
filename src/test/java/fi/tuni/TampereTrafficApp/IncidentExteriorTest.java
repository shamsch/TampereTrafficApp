package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.Exterior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentExteriorTest {

    @Test
    void testExteriorGettersSettersToString() {
        // Create an instance of Exterior
        Exterior exterior = new Exterior();

        // Set values
        exterior.setSrsName("EPSG:4326");
        exterior.setSrsDimension(2);
        exterior.setPosList("61.4991 23.7871 61.5000 23.8000");

        // Verify getters
        assertEquals("EPSG:4326", exterior.getSrsName());
        assertEquals(2, exterior.getSrsDimension());
        assertEquals("61.4991 23.7871 61.5000 23.8000", exterior.getPosList());

        // Verify toString output
        String toStringOutput = exterior.toString();
        assertTrue(toStringOutput.contains("srsName=EPSG:4326"));
        assertTrue(toStringOutput.contains("srsDimension=2"));
        assertTrue(toStringOutput.contains("posList=61.4991 23.7871 61.5000 23.8000"));
    }
}
