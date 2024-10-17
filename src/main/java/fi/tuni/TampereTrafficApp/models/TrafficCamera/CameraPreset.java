package fi.tuni.TampereTrafficApp.models.TrafficCamera;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class CameraPreset {
    private String presetId;
    private String presentationName;
    private String imageUrl;
    private String directionDescription;
    private ZonedDateTime latestPictureTimestamp;
}
