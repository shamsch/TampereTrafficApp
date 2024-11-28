package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.Exterior;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.GmlPolygon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentGmlPolygonTest {

    @Test
    void testGmlPolygonGettersSettersToString() {
        // Create an instance of Exterior
        Exterior exterior = new Exterior();
        exterior.setSrsName("EPSG:4326");
        exterior.setSrsDimension(2);
        exterior.setPosList("61.4991 23.7871 61.5000 23.8000");

        // Create an instance of GmlPolygon and set the Exterior
        GmlPolygon gmlPolygon = new GmlPolygon();
        gmlPolygon.setExterior(exterior);

        // Verify the getter
        assertEquals(exterior, gmlPolygon.getExterior());

        // Verify toString output
        String toStringOutput = gmlPolygon.toString();
        assertTrue(toStringOutput.contains("exterior="));
        assertTrue(toStringOutput.contains("srsName=EPSG:4326"));
        assertTrue(toStringOutput.contains("srsDimension=2"));
        assertTrue(toStringOutput.contains("posList=61.4991 23.7871 61.5000 23.8000"));
    }
}
