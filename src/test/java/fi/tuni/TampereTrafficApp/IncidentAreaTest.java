package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.Area;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.GmlPolygon;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    void testAreaGettersSettersToString() {
        // Create mock data for GmlPolygon
        GmlPolygon polygon1 = new GmlPolygon();
        GmlPolygon polygon2 = new GmlPolygon();

        // Create a list of polygons
        List<GmlPolygon> polygons = Arrays.asList(polygon1, polygon2);

        // Create and set values for Area
        Area area = new Area();
        area.setGmlAreaName("Test Area");
        area.setGmlPolygon(polygons);

        // Verify getters
        assertEquals("Test Area", area.getGmlAreaName());
        assertEquals(polygons, area.getGmlPolygon());

        // Verify toString output
        String expectedString = "Area(gmlAreaName=Test Area, gmlPolygon=[polygon1, polygon2])";
        String actualString = area.toString();
        assertTrue(actualString.contains("Test Area"));
        assertTrue(actualString.contains("gmlPolygon"));
    }
}
