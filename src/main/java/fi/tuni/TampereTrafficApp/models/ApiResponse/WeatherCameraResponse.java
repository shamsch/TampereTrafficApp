package fi.tuni.TampereTrafficApp.models.ApiResponse;

import fi.tuni.TampereTrafficApp.models.WeatherCamera.WeatherCameraFeature;
import fi.tuni.TampereTrafficApp.models.WeatherCamera.Meta;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class WeatherCameraResponse {
    private Meta meta;
    private List<WeatherCameraFeature> results;

    public List<WeatherCameraFeature> getResults() {
        return results;
    }

    public Meta getMeta() {
        return meta;
    }
}
