package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.CameraPreset;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Coordinates;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Geometry;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Location;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.TrafficCamera;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class TrafficCameraTest {

    @Test
    public void testTrafficCamera() {
        String cameraId = "testCameraId";
        String cameraName = "Test Camera Name";

        // Create a Location
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

        // Create a CameraPreset
        String presetId = "testPresetId";
        String presentationName = "Test Presentation Name";
        String imageUrl = "https://en.wikipedia.org/wiki/File:Internet1.jpg";
        String directionDescription = "Test Direction Description";
        ZonedDateTime latestPictureTimestamp = ZonedDateTime.now();

        CameraPreset cameraPreset = new CameraPreset();
        cameraPreset.setPresetId(presetId);
        cameraPreset.setPresentationName(presentationName);
        cameraPreset.setImageUrl(imageUrl);
        cameraPreset.setDirectionDescription(directionDescription);
        cameraPreset.setLatestPictureTimestamp(latestPictureTimestamp);

        List<CameraPreset> cameraPresets = new ArrayList<>();
        cameraPresets.add(cameraPreset);

        // Create a TrafficCamera
        TrafficCamera trafficCamera = new TrafficCamera();
        trafficCamera.setCameraId(cameraId);
        trafficCamera.setCameraName(cameraName);
        trafficCamera.setLocation(location);
        trafficCamera.setCameraPresets(cameraPresets);

        assertEquals(cameraId, trafficCamera.getCameraId());
        assertEquals(cameraName, trafficCamera.getCameraName());
        assertEquals(type, trafficCamera.getLocation().getGeometry().getType());
        assertEquals(lon, trafficCamera.getLocation().getGeometry().getCoordinates().getLon(), 0.0001);
        assertEquals(lat, trafficCamera.getLocation().getGeometry().getCoordinates().getLat(), 0.0001);
        assertEquals(presetId, trafficCamera.getCameraPresets().get(0).getPresetId());
    }
}
