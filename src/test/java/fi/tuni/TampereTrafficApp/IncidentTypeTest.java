package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentTypeTest {

    @Test
    void testTypeGettersSettersToString() {
        // Create an instance of Type
        Type type = new Type();

        // Set a value for the type
        type.setValue("Traffic Incident");

        // Verify getters
        assertEquals("Traffic Incident", type.getValue());

        // Verify toString output
        String toStringOutput = type.toString();
        assertTrue(toStringOutput.contains("value=Traffic Incident"));
    }
}
