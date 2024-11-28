package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IncidentSituationPublicationLightTest {

    @Test
    void testSituationPublicationLightGettersSettersToString() {
        // Create a PublicationCreator instance
        PublicationCreator creator = new PublicationCreator();
        creator.setCountry("Finland");
        creator.setNationalIdentifier("FI-12345");

        // Create a Location instance
        Location location = new Location();
        location.setLocationDescriptor("Test Location");

        // Create a SituationRecord instance
        SituationRecord record = new SituationRecord(
                "1", "1.0", "2024-11-28T12:00:00", "2024-11-28T12:10:00", "2024-11-28T12:00:00", 
                "2024-11-28T12:05:00", new Type(), new Type(), "Detailed Type", "High", true,
                "Source Name", "General comment", "SID123", location, List.of("Temporary limit 1")
        );

        // Create an instance of SituationPublicationLight
        SituationPublicationLight publication = new SituationPublicationLight();
        publication.setLang("en");
        publication.setPublicationTime("2024-11-28T12:34:56");
        publication.setPublicationCreator(creator);
        publication.setSituationRecord(List.of(record));

        // Verify getters
        assertEquals("en", publication.getLang());
        assertEquals("2024-11-28T12:34:56", publication.getPublicationTime());
        assertEquals(creator, publication.getPublicationCreator());
        assertEquals(1, publication.getSituationRecord().size());
        assertEquals(record, publication.getSituationRecord().get(0));

        // Verify toString output
        String toStringOutput = publication.toString();
        assertTrue(toStringOutput.contains("lang=en"));
        assertTrue(toStringOutput.contains("publicationTime=2024-11-28T12:34:56"));
        assertTrue(toStringOutput.contains("publicationCreator="));
        assertTrue(toStringOutput.contains("country=Finland"));
        assertTrue(toStringOutput.contains("nationalIdentifier=FI-12345"));
        assertTrue(toStringOutput.contains("situationRecord="));

        // Check the SituationRecord fields inside the toString of SituationPublicationLight
        assertTrue(toStringOutput.contains("id=1"));
        assertTrue(toStringOutput.contains("version=1.0"));
        assertTrue(toStringOutput.contains("creationTime=2024-11-28 12:00"));
        assertTrue(toStringOutput.contains("type="));
        assertTrue(toStringOutput.contains("severity=High"));
        assertTrue(toStringOutput.contains("safetyRelatedMessage=true"));
        assertTrue(toStringOutput.contains("sourceName=Source Name"));
        assertTrue(toStringOutput.contains("situationId=SID123"));
        assertTrue(toStringOutput.contains("location="));
    }
}
