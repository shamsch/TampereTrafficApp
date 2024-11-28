package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.DetailedType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentDetailedTypeTest {

    @Test
    void testDetailedTypeGettersSettersToString() {
        // Create an instance of DetailedType
        DetailedType detailedType = new DetailedType();

        // Set the value
        detailedType.setValue("Accident");

        // Verify the getter
        assertEquals("Accident", detailedType.getValue());

        // Verify toString output
        String toStringOutput = detailedType.toString();
        assertTrue(toStringOutput.contains("value=Accident"));
    }
}
