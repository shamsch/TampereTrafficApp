package fi.tuni.TampereTrafficApp.models.WeatherCamera;

import lombok.Data;
import java.util.List;

@Data
public class WeatherCameraStation {
    private List<WeatherCameraFeature> features;
}
