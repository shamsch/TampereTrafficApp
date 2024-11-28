package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.*;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.Type;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.DetailedType;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IncidentSituationRecordTest {

    @Test
    void testSituationRecordGettersSettersToString() {
        // Create a Type instance for 'type' and 'detailedType'
        Type type = new Type();
        type.setValue("Incident Type");

        Type detailedType = new Type();
        detailedType.setValue("Detailed Incident Type");

        // Create a Location instance
        Location location = new Location();
        location.setLocationDescriptor("Test Location");

        // Create a SituationRecord instance
        SituationRecord record = new SituationRecord(
                "1", "1.0", "2024-11-28T12:00:00", "2024-11-28T12:10:00", "2024-11-28T12:00:00", 
                "2024-11-28T12:05:00", type, detailedType, "Detailed Type", "High", true,
                "Source Name", "General comment", "SID123", location, List.of("Temporary limit 1")
        );

        // Verify getters
        assertEquals("1", record.getId());
        assertEquals("1.0", record.getVersion());
        assertEquals("2024-11-28 12:00", record.getCreationTime());
        assertEquals("2024-11-28 12:10", record.getVersionTime());
        assertEquals("2024-11-28 12:00", record.getStartTime());
        assertEquals("2024-11-28 12:05", record.getEndTime());
        assertEquals(type, record.getType());
        assertEquals(detailedType, record.getDetailedType());
        assertEquals("Detailed Type", record.getDetailedTypeText());
        assertEquals("High", record.getSeverity());
        assertTrue(record.isSafetyRelatedMessage());
        assertEquals("Source Name", record.getSourceName());
        assertEquals("General comment", record.getGeneralPublicComment());
        assertEquals("SID123", record.getSituationId());
        assertEquals(location, record.getLocation());
        assertEquals(1, record.getTemporaryLimitText().size());
        assertEquals("Temporary limit 1", record.getTemporaryLimitText().get(0));

        // Verify toString output
        String toStringOutput = record.toString();
        assertTrue(toStringOutput.contains("id=1"));
        assertTrue(toStringOutput.contains("version=1.0"));
        assertTrue(toStringOutput.contains("creationTime=2024-11-28 12:00"));
        assertTrue(toStringOutput.contains("severity=High"));
        assertTrue(toStringOutput.contains("safetyRelatedMessage=true"));
        assertTrue(toStringOutput.contains("sourceName=Source Name"));
        assertTrue(toStringOutput.contains("situationId=SID123"));
        assertTrue(toStringOutput.contains("location="));
    }
}
