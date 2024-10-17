package fi.tuni.TampereTrafficApp.models.TrafficCamera;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TrafficCamera {
    private String cameraId;
    private String cameraName;
    private Location location;
    private List<CameraPreset> cameraPresets;

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<CameraPreset> getCameraPresets() {
        return cameraPresets;
    }

    public void setCameraPresets(List<CameraPreset> cameraPresets) {
        this.cameraPresets = cameraPresets;
    }
}
