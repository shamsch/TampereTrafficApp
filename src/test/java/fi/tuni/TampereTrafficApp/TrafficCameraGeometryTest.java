package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.Coordinates;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Geometry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficCameraGeometryTest {

    @Test
    public void testGeometry() {
        String type = "Point";
        double lon = 25.1234;
        double lat = 61.1234;

        Coordinates coordinates = new Coordinates();
        coordinates.setLon(lon);
        coordinates.setLat(lat);

        Geometry geometry = new Geometry();
        geometry.setType(type);
        geometry.setCoordinates(coordinates);

        assertEquals(type, geometry.getType());
        assertEquals(lon, geometry.getCoordinates().getLon(), 0.0001);
        assertEquals(lat, geometry.getCoordinates().getLat(), 0.0001);
    }
}
