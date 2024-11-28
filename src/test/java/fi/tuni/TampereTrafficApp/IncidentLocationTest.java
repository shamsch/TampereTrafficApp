package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentLocationTest {

    @Test
    void testLocationGettersSettersToString() {
        // Create instances of dependent classes
        CoordinatesForDisplay coordinates = new CoordinatesForDisplay();
        coordinates.setLatitude(61.4991);
        coordinates.setLongitude(23.7871);

        Line line = new Line();
        line.setSrsName("EPSG:4326");
        line.setSrsDimension(2);
        line.setPosList("61.4991 23.7871 61.5000 23.8000");

        Area area = new Area();
        area.setGmlAreaName("Test Area");
        area.setGmlPolygon(null); // Assuming no polygons for simplicity

        // Create an instance of Location and set values
        Location location = new Location();
        location.setLocationDescriptor("Test Descriptor");
        location.setCoordinatesForDisplay(coordinates);
        location.setLine(line);
        location.setArea(area);

        // Verify getters
        assertEquals("Test Descriptor", location.getLocationDescriptor());
        assertEquals(coordinates, location.getCoordinatesForDisplay());
        assertEquals(line, location.getLine());
        assertEquals(area, location.getArea());

        // Verify toString output
        String toStringOutput = location.toString();
        assertTrue(toStringOutput.contains("locationDescriptor=Test Descriptor"));
        assertTrue(toStringOutput.contains("coordinatesForDisplay="));
        assertTrue(toStringOutput.contains("latitude=61.4991"));
        assertTrue(toStringOutput.contains("longitude=23.7871"));
        assertTrue(toStringOutput.contains("line="));
        assertTrue(toStringOutput.contains("srsName=EPSG:4326"));
        assertTrue(toStringOutput.contains("area="));
        assertTrue(toStringOutput.contains("gmlAreaName=Test Area"));
    }
}
