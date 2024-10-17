package fi.tuni.TampereTrafficApp.models.ApiResponse;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Meta;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.TrafficCamera;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TrafficCameraResponse {
    private Meta meta;
    private List<TrafficCamera> results;
}

