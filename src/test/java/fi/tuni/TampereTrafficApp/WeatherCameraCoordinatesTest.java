package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.Coordinates;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherCameraCoordinatesTest {
    
    @Test
    public void testCoordinates() {
        double lon = 25.1234;
        double lat = 61.1234;

        Coordinates coordinates = new Coordinates();
        coordinates.setLon(lon);
        coordinates.setLat(lat);

        assertEquals(lon, coordinates.getLon(), 0.0001);
        assertEquals(lat, coordinates.getLat(), 0.0001);
    } 
}


