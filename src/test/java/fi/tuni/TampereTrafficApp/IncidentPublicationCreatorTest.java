package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.PublicationCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentPublicationCreatorTest {

    @Test
    void testPublicationCreatorGettersSettersToString() {
        // Create an instance of PublicationCreator
        PublicationCreator creator = new PublicationCreator();

        // Set values
        creator.setCountry("Finland");
        creator.setNationalIdentifier("FI-12345");

        // Verify getters
        assertEquals("Finland", creator.getCountry());
        assertEquals("FI-12345", creator.getNationalIdentifier());

        // Verify toString output
        String toStringOutput = creator.toString();
        assertTrue(toStringOutput.contains("country=Finland"));
        assertTrue(toStringOutput.contains("nationalIdentifier=FI-12345"));
    }
}
