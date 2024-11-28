package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.CoordinatesForDisplay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentCoordinatesTest {

    @Test
    void testCoordinatesForDisplayGettersSettersToString() {
        // Create an instance of CoordinatesForDisplay
        CoordinatesForDisplay coordinates = new CoordinatesForDisplay();

        // Set values
        coordinates.setLatitude(61.4991);
        coordinates.setLongitude(23.7871);

        // Verify getters
        assertEquals(61.4991, coordinates.getLatitude());
        assertEquals(23.7871, coordinates.getLongitude());

        // Verify toString output
        String toStringOutput = coordinates.toString();
        assertTrue(toStringOutput.contains("latitude=61.4991"));
        assertTrue(toStringOutput.contains("longitude=23.7871"));
    }
}
