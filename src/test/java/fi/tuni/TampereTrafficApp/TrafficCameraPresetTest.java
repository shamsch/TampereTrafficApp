package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.CameraPreset;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.ZonedDateTime;

public class TrafficCameraPresetTest {
    
    @Test
    public void testCameraPreset() {
        String presetId = "testPresetId";
        String presentationName = "Test Presentation Name";
        String imageUrl = "https://example.com/image.jpg";
        String directionDescription = "Test Direction Description";
        ZonedDateTime latestPictureTimestamp = ZonedDateTime.now();

        CameraPreset cameraPreset = new CameraPreset();
        cameraPreset.setPresetId(presetId);
        cameraPreset.setPresentationName(presentationName);
        cameraPreset.setImageUrl(imageUrl);
        cameraPreset.setDirectionDescription(directionDescription);
        cameraPreset.setLatestPictureTimestamp(latestPictureTimestamp);

        assertEquals(presetId, cameraPreset.getPresetId());
        assertEquals(presentationName, cameraPreset.getPresentationName());
        assertEquals(imageUrl, cameraPreset.getImageUrl());
        assertEquals(directionDescription, cameraPreset.getDirectionDescription());
        assertEquals(latestPictureTimestamp, cameraPreset.getLatestPictureTimestamp());
    }   
}
