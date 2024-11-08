package fi.tuni.TampereTrafficApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.tuni.TampereTrafficApp.config.AppConfig;
import fi.tuni.TampereTrafficApp.models.WeatherCamera.WeatherCameraFeature;
import fi.tuni.TampereTrafficApp.services.WeatherCameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for handling weather camera-related requests.
 */
@Controller
public class WeatherCameraController {

    // Dependency injection for ObjectMapper, WeatherCameraService, and AppConfig
    private final ObjectMapper mapper;
    private final WeatherCameraService weatherCameraService;
    private final AppConfig appConfig;

    @Autowired
    public WeatherCameraController(ObjectMapper mapper, WeatherCameraService weatherCameraService, AppConfig appConfig) {
        this.mapper = mapper;
        this.weatherCameraService = weatherCameraService;
        this.appConfig = appConfig;
    }

    /**
     * Handles GET request to display the weather camera map.
     * 
     * @param model The model to add attributes to.
     * @return The view name for the weather camera map.
     */
    @GetMapping("/weathercam/map")
    public String getWeatherCameraMap(Model model) {
        String[] cameraIds = appConfig.getCameraIds();
        String baseUrl = appConfig.getDigitrafficApiUrl();
        
        // Construct URLs for each camera
        String[] urls = Stream.of(cameraIds)
                .map(id -> baseUrl + "/api/weathercam/v1/stations/" + id)
                .toArray(String[]::new);
        
        // Fetch camera data
        List<WeatherCameraFeature> features = weatherCameraService.getWeatherCamerasByUrls(urls);
        model.addAttribute("weatherCameras", features);
        return "WeatherMapView";
    }

    /**
     * Handles GET request to display details of a specific weather camera.
     * 
     * @param id The ID of the weather camera.
     * @param model The model to add attributes to.
     * @return The view name for the weather camera details.
     */
    @GetMapping("/weathercam/details/{id}")
    public String getWeatherCameraDetails(@PathVariable String id, Model model) {
        String baseUrl = appConfig.getDigitrafficApiUrl();
        String url = baseUrl + "/api/weathercam/v1/stations/" + id;

        // Fetch camera detail
        WeatherCameraFeature feature = weatherCameraService.getWeatherCameraByUrl(url);
        model.addAttribute("camera", feature);
        return "WeatherDetailView";
    }
    
    public String getWeatherCameraTienpinta(Model model) {
        String[] cameraIds = appConfig.getCameraIds();
        String baseUrl = appConfig.getDigitrafficApiUrl();
        
        // Construct URLs for each camera
        String[] urls = Stream.of(cameraIds)
                .map(id -> baseUrl + "/api/weathercam/v1/stations/" + id)
                .toArray(String[]::new);
        
        // Fetch camera data where PresentationName = Tienpinta
        List<WeatherCameraFeature> features = weatherCameraService.getWeatherCamerasByUrls(urls);
        // Filter features where PresentationName = Tienpinta
        features = features.stream()
               .filter(feature -> feature.getProperties().getPresets().stream()
                       .anyMatch(preset -> preset.getPresentationName()!= null &&!preset.getPresentationName().isEmpty()
                                && preset.getPresentationName().equals("Tienpinta")))
               .collect(Collectors.toList());
        
        model.addAttribute("weatherCameras", features);
        return "WeatherMapView";
    } 
}