package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.Coordinates;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Geometry;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficCameraLocationTest {

    @Test
    public void testLocation() {
        String type = "Point";
        double lon = 25.1234;
        double lat = 61.1234;

        Coordinates coordinates = new Coordinates();
        coordinates.setLon(lon);
        coordinates.setLat(lat);

        Geometry geometry = new Geometry();
        geometry.setType(type);
        geometry.setCoordinates(coordinates);

        Location location = new Location();
        location.setGeometry(geometry);

        assertEquals(type, location.getGeometry().getType());
        assertEquals(lon, location.getGeometry().getCoordinates().getLon(), 0.0001);
        assertEquals(lat, location.getGeometry().getCoordinates().getLat(), 0.0001);
    }
}
