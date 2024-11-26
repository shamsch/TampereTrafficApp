// WeatherCameraController.java
package fi.tuni.TampereTrafficApp.controllers;

import fi.tuni.TampereTrafficApp.models.WeatherCamera.WeatherCameraFeature;
import fi.tuni.TampereTrafficApp.services.WeatherCameraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * Controller for handling weather camera-related requests.
 */
@Controller
public class WeatherCameraController {
    private final WeatherCameraService weatherCameraService;

    public WeatherCameraController(WeatherCameraService weatherCameraService) {
        this.weatherCameraService = weatherCameraService;
    }

    /**
     * Handles GET request to display the weather camera map.
     *
     * @param showTienpinta Flag to show only Tienpinta cameras
     * @param model The model to add attributes to.
     * @return The view name for the weather camera map.
     */
    @GetMapping("/weathercam/map")
    public String showCameraMap(@RequestParam(required = false, defaultValue = "false") boolean showTienpinta, Model model) {
        List<WeatherCameraFeature> features = showTienpinta ?
                weatherCameraService.getTienpintaCameras() :
                weatherCameraService.getWeatherCameras();
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
    public String showCameraDetails(@PathVariable String id, Model model) {
        WeatherCameraFeature feature = weatherCameraService.getWeatherCameraById(id).orElse(null);
        model.addAttribute("camera", feature);
        return "WeatherDetailView";
    }
}