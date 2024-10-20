package fi.tuni.TampereTrafficApp.models.TrafficCamera;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrafficCamera {
    private String cameraId;
    private String cameraName;
    private Location location;
    private List<CameraPreset> cameraPresets;
}
